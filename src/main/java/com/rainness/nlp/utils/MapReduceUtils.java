package com.rainness.nlp.utils;

import com.rainness.nlp.WordFrequencyLearning;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * Created by zhangjinpeng on 16-10-20.
 */
public class MapReduceUtils {

    private static final Logger LOG = LoggerFactory.getLogger(WordFrequencyLearning.class);

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

    public static void write(Path dst, Configuration conf, String result) {
        FileSystem fs = null;
        FSDataOutputStream output = null;
        try {
            fs = FileSystem.get(conf);
            output = fs.create(dst);
            output.writeUTF(result);
        } catch (Exception e) {
            LOG.error("Class MapReduceUtils function[write] error:" + e);
        } finally {
          closeQuietly(fs);
          closeQuietly(output);
        }
    }

    public static void batchWrite(Path dst, Configuration conf, List<String> resultList) {
        FileSystem fs = null;
        FSDataOutputStream output = null;
        try {
            fs = FileSystem.get(conf);
            output = fs.create(dst);
            for (String result : resultList) {
                //add '\n' to result in order to check
                output.writeUTF(result + "\n");
            }
            fs.close();
            output.close();
        } catch (Exception e) {
            closeQuietly(fs);
            closeQuietly(output);
        }
    }

    private static <T extends Closeable> void closeQuietly(T obj) {
        try {
            if (obj != null) {
                obj.close();
            }
        } catch (Exception e) {
            //ignore
        }
    }
}
