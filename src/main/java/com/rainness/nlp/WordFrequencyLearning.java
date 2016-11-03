package com.rainness.nlp;

import com.google.common.base.Strings;
import com.rainness.nlp.utils.MapReduceUtils;
import com.rainness.nlp.utils.WordAnalysis;
import org.apache.hadoop.conf.Configuration;
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
import java.util.Iterator;

/**
 * Created by zhangjinpeng on 9/11/16.
 */
public class WordFrequencyLearning {

    private static final Logger LOG = LoggerFactory.getLogger(WordFrequencyLearning.class);

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
                } catch (Exception e) {
                    LOG.error("Class WordFrequencyMapper map exception, error message:" + e);
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
            if (WordAnalysis.isPunctuation(key.toString().charAt(0))) {
                return;
            }
            if (!WordAnalysis.isChinese(key.toString().charAt(0))) {
                return;
            }
            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }
            try {
                context.write(NullWritable.get(), new Text(key.toString() + "\t" + count));
            } catch (Exception e) {
                LOG.error("Class WordFrequencyReducer reduce exception, error message:" + e);
                throw new AssertionError(e);
            }
        }
    }

    public static void learn(Path inputPath, Path outputPath, Configuration conf) {
        try {
            Job job = Job.getInstance(conf, "WordFrequencyLearningJob");
            job.setJarByClass(WordFrequencyLearning.class);
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
            int reducerNumber = MapReduceUtils.guessReducerNumber(new Path[]{inputPath}, conf);
            job.setNumReduceTasks(reducerNumber);
            job.waitForCompletion(true);
        } catch (Exception e) {
            LOG.error("Class WordFrequencyLearning learn exception, error message:" + e);
            throw new AssertionError(e);
        }
    }
}