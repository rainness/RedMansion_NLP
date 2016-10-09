package com.rainness.nlp;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import com.rainness.nlp.JobRunner.WordFrequencyRunner;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by zhangjinpeng on 9/11/16.
 */
public class TestJobRunner {

    @ClassRule
    public static TemporaryFolder tempDir = new TemporaryFolder();

    @Test
    public void testWordFrequencyJob() throws Exception {
        Configuration conf = new Configuration();
        Path inputPath = new Path(TestJobRunner.class.getResource("The_Dream_of_Red_Mansion.data").getPath());
        Path outputPath = new Path(tempDir.newFolder().getPath(), "output");
        WordFrequencyRunner.runWordFrequencyCalculation(inputPath, outputPath, conf);
        readFromFile(new Path(outputPath, "part-r-00000").toString());
    }

    private void readFromFile(String fileName) {
        BufferedReader bin = null;
        try {
            bin = new BufferedReader(new FileReader(fileName));
            String line;
            while (true) {
                line = bin.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
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
}
