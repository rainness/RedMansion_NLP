package com.rainness.nlp;

import com.rainness.nlp.algorithm.ItemSetModel;
import com.rainness.nlp.utils.FileSeperator;
import com.rainness.nlp.utils.ReaderAccess;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.util.Map;

/**
 * Created by zhangjinpeng on 9/11/16.
 */
public class TestJobRunner {

    @ClassRule
    public static TemporaryFolder tempDir = new TemporaryFolder();
    public static String localFolder = System.getProperty("user.dir") + "/data/item";

    @Test
    public void testWordFrequencyJob() throws Exception {
        Configuration conf = new Configuration();
        Path inputPath = new Path(TestJobRunner.class.getResource("The_Dream_of_Red_Mansion.data").getPath());
        Path outputPath = new Path(localFolder);
        WordFrequencyLearning.learn(inputPath, outputPath, conf);
        Map<String, Integer> wordMap = ReaderAccess.readWordMap(new Path(outputPath, "part-r-00000").toString());
        Assert.assertEquals(wordMap.get("丐").longValue(), 1L);
        Assert.assertEquals(wordMap.get("东").longValue(), 4L);
        Path outputFile = new Path(outputPath, "part-r-00000");
        ItemSetModel model = new ItemSetModel(outputFile.toString(), 2, 0.8, 10, "local", FileSeperator.TAB_SEPERATOR);
        model.train();
    }
}
