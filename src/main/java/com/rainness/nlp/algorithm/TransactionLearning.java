package com.rainness.nlp.algorithm;

import com.google.common.collect.Lists;
import com.rainness.nlp.segmentor.Sentence;
import com.rainness.nlp.segmentor.SentenceRetail;
import com.rainness.nlp.segmentor.SmartTokenizer;
import com.rainness.nlp.utils.FileSeperator;
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
    private SmartTokenizer tokenizer = new SmartTokenizer();

    public TransactionLearning(File inputFile, File outputDir, int shardNumber) {
        this.inputFile = inputFile;
        this.outputDir = outputDir;
        this.shardNumber = shardNumber;
    }

    public void transform() {
        if (shardNumber <= 0) {
            throw new AssertionError("shard-number should be bigger than zero");
        }
        BufferedReader bin = null;
        List<BufferedWriter> outputList = Lists.newLinkedList();
        try {
            for (int i = 0; i < shardNumber; i++) {
                BufferedWriter output = new BufferedWriter(new FileWriter(new File(outputDir, "output." + i)));
                outputList.add(output);
            }
            bin = new BufferedReader(new FileReader(inputFile));
            while (true) {
                String line = bin.readLine();
                if (line == null) {
                    break;
                }
                String source = SentenceRetail.parse(line);
                Sentence sentence = tokenizer.tokenizer(source);
                int pos = Math.abs(sentence.hashCode()) % outputList.size();
                outputList.get(pos).write(sentence.toString() + FileSeperator.RETURN_SEPERATOR);
            }
            for (BufferedWriter writer : outputList) {
                writer.flush();
                closeQuietly(writer);
            }
            bin.close();
        } catch (Exception e) {
            LOG.error("Class TransactionLearning function[transform] error:" +e);
        } finally {
            closeQuietly(bin);
            for (BufferedWriter writer : outputList) {
                closeQuietly(writer);
            }
        }
    }
    private <T extends Closeable> void closeQuietly(T obj) {
        if (obj != null) {
            try {
                obj.close();
            } catch (Exception e) {
                //ignore
            }
        }
    }
}
