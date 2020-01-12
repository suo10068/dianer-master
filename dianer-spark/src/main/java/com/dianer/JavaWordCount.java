package com.dianer;

import com.alibaba.fastjson.JSON;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * -Dspark.master=local
 */
public final class JavaWordCount {
    private static final Pattern SPACE = Pattern.compile(" ");
    private static final String FILE_IN = "C:\\Users\\dianer\\Desktop\\log\\bbb.txt";
    private static final String FILE_OUT = "C:\\Users\\dianer\\Desktop\\log\\bbb.out";

    public static void main(String[] args) throws Exception {

        SparkSession sparkSession = SparkSession
                .builder()
                .appName("JavaWordCount")
                .master("local")
                .getOrCreate();

        JavaRDD<String> lines = sparkSession.read().textFile(FILE_IN).javaRDD();
        System.out.println("lines: " + JSON.toJSONString(lines.collect()));

//        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)).iterator());

        FlatMapFunction<String, String> flatMapFunction = new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(SPACE.split(s)).iterator();
            }
        };
        JavaRDD<String> words = lines.flatMap(flatMapFunction);
        System.out.println("words: " + JSON.toJSONString(words.collect()));

//        JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));

        PairFunction<String, String, Integer> pairFunction = new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s, 1);
            }
        };
        JavaPairRDD<String, Integer> ones = words.mapToPair(pairFunction);
        System.out.println("ones:" + JSON.toJSONString(ones.collect()));

        // 函数把key相同的键值对通过value进行累加
        JavaPairRDD<String, Integer> counts = ones.reduceByKey((v1, v2) -> v1 + v2);

        counts.saveAsTextFile(FILE_OUT);

        List<Tuple2<String, Integer>> output = counts.collect();

        for (Tuple2<?, ?> tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }

        sparkSession.stop();
    }
}