package com.dianer;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.FlatMapFunction2;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.Iterator;

public class JSONToObject {
    private static String FILE_PATH = "C:\\Users\\dianer\\Desktop\\log\\person";

    public static void main(String[] args) {
        SparkSession sparkSession = SparkSession
                .builder()
                .appName("JSON")
                .master("local")
                .getOrCreate();

        JavaRDD<String> javaRDD = sparkSession.read().textFile(FILE_PATH).toJavaRDD();

        JavaRDD<String> rstJavaRDD = javaRDD.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String v1) throws Exception {
                return v1.contains("男");
            }
        });

        System.out.println("性别为男的人数：" + rstJavaRDD.count());

        for (String s : rstJavaRDD.collect()) {
            System.out.println(s);
        }


        FlatMapFunction2<Integer, Integer, String> flatMapFunction2 = new FlatMapFunction2<Integer, Integer, String>() {
            @Override
            public Iterator<String> call(Integer integer, Integer integer2) throws Exception {
                return Arrays.asList(integer.toString() + integer2).iterator();
            }
        };


    }


}
