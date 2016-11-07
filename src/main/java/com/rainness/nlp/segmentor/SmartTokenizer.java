package com.rainness.nlp.segmentor;

import com.google.common.collect.Lists;
import com.rainness.nlp.term.TermAnalysisLearning;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Properties;

/**
 * Created by rainness on 16-11-7.
 */
public class SmartTokenizer<T> implements Tokenizer<T> {

    private static final Logger LOG = LoggerFactory.getLogger(TermAnalysisLearning.class);
    private Properties props = new Properties();
    private CRFClassifier<CoreLabel> segmentor;

    public SmartTokenizer() {
        try {
            String basedir = SmartTokenizer.class.getResource("/data").getPath();
            props.setProperty("sighanCorporaDict", basedir);
            props.setProperty("serDictionary", basedir + "/dict-chris6.ser.gz");
            props.setProperty("inputEncoding", "UTF-8");
            props.setProperty("sighanPostProcessing", "true");
            segmentor = new CRFClassifier(props);
            segmentor.loadClassifierNoExceptions(basedir + "/pku.gz", props);
        } catch (Exception e) {
            LOG.error("Class SmartTokenizer function[construct] error:" + e);
        }
    }

    @Override
    public List<T> tokenizer(T src, Class<T> clazz) {
        List<T> termList = Lists.newLinkedList();
        try {
            if (clazz == String.class) {
                String dst = (String) src;
                List<String> segList = segmentor.segmentString(dst);
                for (String term : segList) {
                    termList.add((T) term);
                }
            }
        } catch (Exception e) {
            LOG.error("Class SmartTokenizer function[tokenizer] error:" + e);
        }
        return termList;
    }
}
