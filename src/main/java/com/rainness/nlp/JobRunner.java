package com.rainness.nlp;

import com.google.common.base.Strings;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by zhangjinpeng on 9/11/16.
 */
public class JobRunner {

    private static final Logger LOG = LoggerFactory.getLogger(JobRunner.class);

    public static class WordFrequencyRunner {

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

        private static final class WordFrequencyMapper
                extends Mapper<Writable, Text, Text, IntWritable> {

            @Override
            public void map(
                    Writable ignored, Text value, Context context) {
                String line = value.toString();
                if (Strings.isNullOrEmpty(line)) {
                    return;
                }
                for (char word : line.toCharArray()) {
                    try {
                        context.write(new Text(String.valueOf(word)), new IntWritable(1));
                    } catch (IOException e) {
                        LOG.error("Class WordFrequencyRunner map exception, error message:" + e);
                        throw new AssertionError(e);
                    } catch (InterruptedException e) {
                        LOG.error("Class WordFrequencyRunner map exception, error message:" + e);
                        throw new AssertionError(e);
                    }
                }
            }
        }

        private static final class WordFrequencyReducer
                extends Reducer<Text, IntWritable, NullWritable, Text> {

            @Override
            public void reduce(
                    Text key, Iterable<IntWritable> values, Context context) {
                Iterator<IntWritable> iterator = values.iterator();
                int count = 0;
                while (iterator.hasNext()) {
                    iterator.next();
                    count++;
                }
                try {
                    context.write(NullWritable.get(), new Text(key.toString() + "\t" + count));
                } catch (IOException e) {
                    LOG.error("Class WordFrequencyRunner reduce exception, error message:" + e);
                    throw new AssertionError(e);
                } catch (InterruptedException e) {
                    LOG.error("Class WordFrequencyRunner reduce exception, error message:" + e);
                    throw new AssertionError(e);
                }
            }
        }

        public static void runWordFrequencyCalculation(Path inputPath, Path outputPath, Configuration conf) {
            try {
                Job job = Job.getInstance(conf, "SimpleMapReduceJob");
                job.setJarByClass(WordFrequencyRunner.class);
                TextInputFormat.setInputPaths(job, inputPath);
                TextOutputFormat.setOutputPath(job, outputPath);
                job.setMapperClass(WordFrequencyMapper.class);
                job.setReducerClass(WordFrequencyReducer.class);
                job.setMapOutputKeyClass(Text.class);
                job.setMapOutputValueClass(IntWritable.class);
                job.setOutputKeyClass(NullWritable.class);
                job.setOutputValueClass(Text.class);
                job.setInputFormatClass(TextInputFormat.class);
                job.setOutputFormatClass(TextOutputFormat.class);
                int reducerNumber = guessReducerNumber(new Path[]{inputPath}, conf);
                job.setNumReduceTasks(reducerNumber);
                job.waitForCompletion(true);
            } catch (IOException e) {
                LOG.error("Class WordFrequencyRunner job runner exception, error message:" + e);
                throw new AssertionError(e);
            } catch (InterruptedException e) {
                LOG.error("Class WordFrequencyRunner job runner exception, error message:" + e);
                throw new AssertionError(e);
            } catch (ClassNotFoundException e) {
                LOG.error("Class WordFrequencyRunner job runner exception, error message:" + e);
                throw new AssertionError(e);
            }
        }
    }

    public static void main(String[] args) {
    }
}
