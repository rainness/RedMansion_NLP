package com.rainness.nlp.segmentor;

/**
 * Created by rainness on 16-11-7.
 */
public class Term {

    private String value;

    public Term(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
