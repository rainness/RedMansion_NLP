package com.rainness.nlp;

import com.rainness.nlp.segmentor.SmartTokenizer;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

/**
 * Created by rainness on 16-11-7.
 */
public class TestTokenizer {

    @Test
    public void testSmartTokenizer() throws Exception {
        SmartTokenizer tokenizer = new SmartTokenizer();
        List<String> termList = tokenizer.tokenizer("我是一个中国人", String.class);
        Assert.assertTrue(termList.contains("中国"));
        Assert.assertTrue(termList.contains("我"));
    }
}
