package com.rainness.nlp.segmentor;

import com.google.common.collect.Lists;
import com.rainness.nlp.utils.FileSeperator;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * Created by rainness on 16-11-7.
 */
public class Sentence {

    private List<Term> termList = Lists.newLinkedList();

    public Sentence() {}

    public void addTerm(String term) {
        termList.add(new Term(term));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Term term : termList) {
            sb.append(term.toString() + FileSeperator.TAB_SEPERATOR);
        }
        return StringUtils.removeEnd(sb.toString(), FileSeperator.TAB_SEPERATOR);
    }
}
