package com.rainness.nlp;

import com.google.common.collect.Lists;
import com.rainness.nlp.algorithm.TransactionLearning;
import com.rainness.nlp.utils.FileSeperator;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rainness on 16-11-8.
 */
public class TestTransactionLearing {

    @ClassRule
    public static TemporaryFolder tempDir = new TemporaryFolder();

    @Test
    public void testTransactionLearning() throws Exception {
        File inputFile = new File(TestTransactionLearing.class.getResource("The_Dream_of_Red_Mansion.simple.data.copy").getPath());
        File outputDir = new File(tempDir.newFolder("output").getPath());
        TransactionLearning transactionLearning = new TransactionLearning(inputFile, outputDir, 3);
        transactionLearning.transform();
        List<String> termList = parse(outputDir);
        Assert.assertTrue(termList.contains("祖母"));
        Assert.assertTrue(termList.contains("葫芦案"));
    }

    private List<String> parse(File outputDir) {
        List<String> termList = Lists.newLinkedList();
        File[] outputFiles = outputDir.listFiles();
        for (File file : outputFiles) {
            BufferedReader bin = null;
            try {
                bin = new BufferedReader(new FileReader(file));
                while (true) {
                    String line = bin.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] array = line.split(FileSeperator.TAB_SEPERATOR);
                    termList.addAll(Arrays.asList(array));
                }
            } catch (Exception e) {
                throw new AssertionError(e);
            } finally {
                if (bin != null) {
                    try {
                        bin.close();
                    } catch (Exception e) {
                        //ignore
                    }
                }
            }
        }
        return termList;
    }
}
