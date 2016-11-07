package com.rainness.nlp;

import com.rainness.nlp.term.TermAnalysisLearning;
import com.rainness.nlp.utils.ReaderAccess;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.*;

/**
 * Created by rainness on 16-11-7.
 */
public class TestTermFrequency {

    @ClassRule
    public static TemporaryFolder tmpDir = new TemporaryFolder();

    @Test
    public void testTermFrequencyJob() throws Exception {
        Configuration conf = new Configuration();
        Path inputPath = new Path(TestTermFrequency.class.getResource("The_Dream_of_Red_Mansion.simple.data").getPath());
        Path outputPath = new Path(tmpDir.newFolder().getPath(), "output");
        TermAnalysisLearning.learn(inputPath, outputPath, conf);
        Map<String, Integer> wordMap = ReaderAccess.readWordMap(new Path(outputPath, "part-r-00000").toString());
        Assert.assertEquals(wordMap.get("街市").longValue(), 1L);
        Assert.assertEquals(wordMap.get("书房").longValue(), 3L);
        List<Map.Entry<String, Integer>> entryList = new LinkedList();
        entryList.addAll(wordMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return -Integer.compare(o1.getValue(), o2.getValue());
            }
        });
        List<Map.Entry<String, Integer>> result = entryList.subList(0, entryList.size() < 100 ? entryList.size() : 100);
        for (Map.Entry<String, Integer> item : result) {
            System.out.println(item.getKey() + "\t" + item.getValue());
        }

    }
}
