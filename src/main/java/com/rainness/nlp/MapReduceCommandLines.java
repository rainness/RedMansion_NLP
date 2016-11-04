package com.rainness.nlp;

import com.lexicalscope.jewel.cli.Option;
import org.apache.hadoop.fs.Path;

/**
 * Created by rainness on 16-11-4.
 */
public interface MapReduceCommandLines {

        @Option(longName = "input-path")
        Path inputPath();

        @Option(longName = "output-path")
        Path outputPath();

        @Option(longName = "is-compressed")
        boolean compressedEnable();

        @Option(longName = "cluster", defaultValue = "local")
        String cluster();

}
