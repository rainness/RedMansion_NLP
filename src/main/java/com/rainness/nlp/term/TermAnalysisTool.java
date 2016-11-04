package com.rainness.nlp.term;

import com.rainness.nlp.MapReduceCommandLines;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;

/**
 * Created by netease on 16-11-4.
 */
public class TermAnalysisTool extends Configured implements Tool {

    public interface TermCommandLines extends MapReduceCommandLines {}

    @Override
    public int run(String[] args) throws Exception {
        return 0;
    }

    public static void main(String[] args) {

    }
}
