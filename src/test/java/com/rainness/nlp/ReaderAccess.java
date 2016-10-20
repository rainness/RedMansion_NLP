package com.rainness.nlp;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

/**
 * Created by zhangjinpeng on 16-10-20.
 */
public class ReaderAccess {

    private static final Logger LOG = LoggerFactory.getLogger(ReaderAccess.class);

    public static Map<String, Integer> readWordMap(String fileName) {
        BufferedReader bin = null;
        Map<String, Integer> wordMap = Maps.newHashMap();
        try {
            bin = new BufferedReader(new FileReader(fileName));
            String line;
            while (true) {
                line = bin.readLine();
                if (line == null) {
                    break;
                }
                String[] array = line.split("\t");
                wordMap.put(array[0], Integer.valueOf(array[1]));
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
        return wordMap;
    }
}
