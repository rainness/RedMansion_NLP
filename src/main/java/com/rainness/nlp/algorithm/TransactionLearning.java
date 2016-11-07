package com.rainness.nlp.algorithm;

import com.google.common.collect.Lists;
import com.rainness.nlp.segmentor.SentenceRetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.List;

/**
 * Created by rainness on 16-11-7.
 */
public class TransactionLearning {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionLearning.class);

    private File inputFile;
    private File outputDir;
    private int shardNumber;

    public TransactionLearning(File inputFile, File outputDir, int shardNumber) {
        this.inputFile = inputFile;
        this.outputDir = outputDir;
        this.shardNumber = shardNumber;
    }

    public void transform() {
        if (shardNumber <= 0) {
            throw new AssertionError("shard-number should be bigger than zero");
        }
        try {
            List<BufferedWriter> outputList = Lists.newLinkedList();
            for (int i = 0; i < shardNumber; i++) {
                BufferedWriter output = new BufferedWriter(new FileWriter(new File(outputDir, "output." + i)));
                outputList.add(output);
            }
            BufferedReader bin = new BufferedReader(new FileReader(inputFile));
            while (true) {
                String line = bin.readLine();
                if (line == null) {
                    break;
                }
                String source = SentenceRetail.parse(line);

            }
        } catch (Exception e) {
            LOG.error("Class TransactionLearning function[transform] error:" +e);
        }
    }

}
