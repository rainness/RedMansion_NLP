package com.rainness.nlp.word;

import com.lexicalscope.jewel.cli.CliFactory;
import com.rainness.nlp.MapReduceCommandLines;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * Created by rainness on 16-11-4.
 */
public class WordAnalysisTool extends Configured implements Tool {

    public interface WordCommandLines extends MapReduceCommandLines {}

    @Override
    public int run(String[] args) throws Exception {
        Configuration conf = new Configuration();
        WordCommandLines cli = CliFactory.parseArguments(WordCommandLines.class, args);
        WordFrequencyLearning.learn(cli.inputPath(), cli.outputPath(), conf);
        return 0;
    }

    public static void main(String[] args) throws Exception {
        ToolRunner.run(new WordAnalysisTool(), args);
    }
}
