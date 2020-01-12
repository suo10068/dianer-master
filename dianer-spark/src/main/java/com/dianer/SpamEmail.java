package com.dianer;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.mllib.classification.LogisticRegressionModel;
import org.apache.spark.mllib.classification.LogisticRegressionWithSGD;
import org.apache.spark.mllib.feature.HashingTF;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SpamEmail {

    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) {
        SparkSession sparkSession = SparkSession
                .builder()
                .appName("spam-email")
                .master("local[2]")
                .getOrCreate();
        JavaSparkContext javaSparkContext = JavaSparkContext.fromSparkContext(sparkSession.sparkContext());

        // 垃圾邮件数据
        JavaRDD<String> spamEmail = javaSparkContext.textFile("spam.json");
        // 优质邮件数据
        JavaRDD<String> normalEmail = javaSparkContext.textFile("normal.json");

        // 创建hashingTF实例把邮件文本映射为包含10000个特征的向量
        final HashingTF hashingTF = new HashingTF(10000);

        JavaRDD<LabeledPoint> spamExamples = spamEmail.map(new Function<String, LabeledPoint>() {
            @Override
            public LabeledPoint call(String v1) throws Exception {
                return new LabeledPoint(0, hashingTF.transform(Arrays.asList(SPACE.split(v1))));
            }
        });

        JavaRDD<LabeledPoint> normaExamples = normalEmail.map(new Function<String, LabeledPoint>() {
            @Override
            public LabeledPoint call(String v1) throws Exception {
                return new LabeledPoint(1, hashingTF.transform(Arrays.asList(SPACE.split(v1))));
            }
        });

        // 训练数据
        JavaRDD<LabeledPoint> trainData = spamExamples.union(normaExamples);
        // 逻辑回归需要迭代,先缓存
        trainData.cache();

        // 随机梯度下降法  SGD 逻辑回归
        LogisticRegressionModel model = new LogisticRegressionWithSGD().run(trainData.rdd());

        Vector spamModel = hashingTF.transform(Arrays.asList(SPACE.split("垃 圾 钱 恶 心 色 情 赌 博 毒 品 败 类 犯罪")));
        Vector normaModel = hashingTF.transform(Arrays.asList(SPACE.split("work 工作 你好 我们 请问 时间 领导")));
        System.out.println("预测负面的例子: " + model.predict(spamModel));
        System.out.println("预测积极的例子: " + model.predict(normaModel));
    }
}
