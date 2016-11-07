package com.rainness.nlp.segmentor;

import com.rainness.nlp.utils.WordAnalysis;

/**
 * Created by rainness on 16-11-7.
 */
public class SentenceRetail {

    private static StringBuilder sb = new StringBuilder();

    public static String parse(String source) {
        return chineseLemma(source);
    }

    private static String chineseLemma(String source) {
        sb.delete(0, sb.length());
        for (char word : source.toCharArray()) {
            if (WordAnalysis.isPunctuation(word)) {
                continue;
            }
            if (!WordAnalysis.isChinese(word)) {
                continue;
            }
            sb.append(word);
        }
        return sb.toString();
    }
}
