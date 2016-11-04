package com.rainness.nlp.algorithm;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.mllib.fpm.AssociationRules;
import org.apache.spark.mllib.fpm.FPGrowth;
import org.apache.spark.mllib.fpm.FPGrowthModel;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rainness on 16-10-20.
 */
public class ItemSetModel implements Model, Serializable {

    private String filePath;
    private double minSupport;
    private double minConfidence;
    private int numPartition;
    private String mode;
    private String separator;

    public ItemSetModel(
            String filePath,
            double minSupport,
            double minConfidence,
            int numPartition,
            String mode,
            String separator) {
        this.filePath = filePath;
        this.minSupport = minSupport;
        this.minConfidence = minConfidence;
        this.numPartition = numPartition;
        this.mode = mode;
        this.separator = separator;
    }

    @Override
    public void train() {
        SparkConf conf = new SparkConf().setAppName("ItemSetJob").setMaster(mode);
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> raw = sc.textFile(filePath);
        JavaRDD<List<String>> transactions = raw.map(
                new Function<String, List<String>>() {
                    public List<String> call(String line) {
                        String[] parts = line.split(separator);
                        return Arrays.asList(parts);
                    }
                }
        );
        FPGrowth fpg = new FPGrowth()
                .setMinSupport(minSupport)
                .setNumPartitions(numPartition);
        FPGrowthModel<String> model = fpg.run(transactions);

        for (FPGrowth.FreqItemset<String> itemSet : model.freqItemsets().toJavaRDD().collect()) {
            System.out.println("[" + itemSet.javaItems() + "], " + itemSet.freq());
        }
        for (AssociationRules.Rule<String> rule
                : model.generateAssociationRules(minConfidence).toJavaRDD().collect()) {
            System.out.println(
                    rule.javaAntecedent() + " => " + rule.javaConsequent() + ", " + rule.confidence());
        }
    }
}
