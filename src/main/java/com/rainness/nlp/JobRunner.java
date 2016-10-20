package com.rainness.nlp;

import com.lexicalscope.jewel.cli.CliFactory;
import com.lexicalscope.jewel.cli.Option;
import com.rainness.nlp.algorithm.ItemSetModel;
import com.rainness.nlp.utils.Constants;
import com.rainness.nlp.utils.FileSeperator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangjinpeng on 9/11/16.
 */
public class JobRunner extends Configured implements Tool {

    private static final Logger LOG = LoggerFactory.getLogger(JobRunner.class);

    public interface CommandLine {

        @Option(longName = "raw-input-path")
        Path rawInputPath();

        @Option(longName = "word-frequency-output-path")
        Path wordFrequencyOutputPath();

        @Option(longName = "mode")
        String mode();

        @Option(longName = "min-support")
        double minSupport();

        @Option(longName = "min-confidence")
        double minConfidence();

        @Option(longName = "separator")
        String separator();

        @Option(longName = "frequency-itemset-output-path")
        String itemsetOutputPath();

        @Option(longName = "rule-output-path")
        String ruleOutputPath();
    }

    @Override
    public int run(String[] args) {
        try {
            Configuration conf = new Configuration();
            conf.set(Constants.FILE_SEPARATOR, FileSeperator.TAB_SEPERATOR);
            CommandLine cli = CliFactory.parseArguments(CommandLine.class, args);
            WordFrequencyLearning.learn(cli.rawInputPath(), cli.wordFrequencyOutputPath(), conf);
            ItemSetModel model = new ItemSetModel(
                    cli.wordFrequencyOutputPath().toString(),
                    cli.minSupport(),
                    cli.minConfidence(),
                    10,
                    "local",
                    FileSeperator.TAB_SEPERATOR,
                    cli.itemsetOutputPath(),
                    cli.ruleOutputPath());
            model.train();
        } catch (Exception e) {
            LOG.error("Class JobRunner function[run] error:" + e);
            throw new AssertionError(e);
        }
        return 0;
    }

    public static void main(String[] args) {
        try {
            ToolRunner.run(new JobRunner(), args);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
