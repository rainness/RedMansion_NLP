package com.rainness.nlp.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by zhangjinpeng on 16-10-20.
 */
public class MapReduceUtils {

    public static int guessReducerNumber(Path[] paths, Configuration conf) throws IOException {
        long blockTotalSize = 0;
        for (int i = 0; i < paths.length; i++) {
            blockTotalSize += guessblockSize(paths[i], conf);
        }
        int reducerNumber = (int)(blockTotalSize / 1044841824L);  //1G
        return Math.max(1, reducerNumber);
    }

    public static long guessblockSize(Path path, Configuration conf) throws IOException {

        FileSystem fileFS = path.getFileSystem(conf);
        FileStatus[] fileStatuses = fileFS.listStatus(path);
        if (fileStatuses == null) {
            return 0;
        }
        long sum = 0;
        for (FileStatus fileStatus : fileStatuses) {
            if (fileStatus.isDirectory()) {
                sum += guessblockSize(fileStatus.getPath(), conf);
            } else {
                sum += fileStatus.getLen();
            }
        }
        return sum;
    }
}
