package com.rainness.nlp.segmentor;

import java.util.List;

/**
 * Created by rainness on 16-11-7.
 */
public interface Tokenizer<T> {

    public List<T> tokenizer(T source, Class<T> clazz);
}
