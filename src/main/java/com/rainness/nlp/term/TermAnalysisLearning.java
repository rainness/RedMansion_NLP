package com.rainness.nlp.term;

import com.google.common.base.Strings;
import com.rainness.nlp.segmentor.SentenceRetail;
import com.rainness.nlp.segmentor.SmartTokenizer;
import com.rainness.nlp.utils.MapReduceUtils;
import com.rainness.nlp.word.WordFrequencyLearning;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
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
import java.util.List;

/**
 * Created by rainness on 16-11-7.
 */
public class TermAnalysisLearning {

    private static final Logger LOG = LoggerFactory.getLogger(TermAnalysisLearning.class);

    private static final class TermFrequencyMapper
            extends Mapper<Writable, Text, Text, IntWritable> {

        private SmartTokenizer<String> tokenizer = new SmartTokenizer();

        @Override
        public void map(
                Writable ignored, Text value, Context context) {
            try {
                String line = value.toString();
                if (Strings.isNullOrEmpty(line)) {
                    return;
                }
                List<String> termList = tokenizer.tokenizer(SentenceRetail.parse(line), String.class);
                for (String term : termList) {
                    context.write(new Text(term), new IntWritable(1));
                }
            } catch (Exception e) {
                LOG.error("Class TermAnalysisLearning.TermFrequencyMapper function[map], error:" + e);
                throw new AssertionError(e);
            }
        }
    }

    private static final class TermFrequencyReducer
            extends Reducer<Text, IntWritable, Text, IntWritable> {

        @Override
        public void reduce(
                Text key, Iterable<IntWritable> values, Context context) {
            try {
                Iterator<IntWritable> iterator = values.iterator();
                int count = 0;
                while (iterator.hasNext()) {
                    int value = iterator.next().get();
                    count += value;
                }
                context.write(key, new IntWritable(count));
            } catch (Exception e) {
                LOG.error("Class TermAnalysisLearning.TermFrequencyReducer function[reduce], error:" + e);
                throw new AssertionError(e);
            }
        }
    }

    public static void learn(Path inputPath, Path outputPath, Configuration conf) {
        try {
            Job job = Job.getInstance(conf, "TermFrequencyLearningJob");
            job.setJarByClass(WordFrequencyLearning.class);
            TextInputFormat.setInputPaths(job, inputPath);
            TextOutputFormat.setOutputPath(job, outputPath);
            job.setMapperClass(TermFrequencyMapper.class);
            job.setCombinerClass(TermFrequencyReducer.class);
            job.setReducerClass(TermFrequencyReducer.class);
            job.setMapOutputKeyClass(Text.class);
            job.setMapOutputValueClass(IntWritable.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            job.setInputFormatClass(TextInputFormat.class);
            job.setOutputFormatClass(TextOutputFormat.class);
            int reducerNumber = MapReduceUtils.guessReducerNumber(new Path[]{inputPath}, conf);
            job.setNumReduceTasks(reducerNumber);
            job.waitForCompletion(true);
        } catch (Exception e) {
            LOG.error("Class TermFrequencyLearning function[learn], error:" + e);
            throw new AssertionError(e);
        }
    }
}
