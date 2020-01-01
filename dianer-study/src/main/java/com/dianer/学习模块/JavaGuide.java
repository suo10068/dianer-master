package com.dianer.学习模块;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1、HashMap 与 ConcurrentHashMap
 * 2
 */
public class JavaGuide {
    public static void main(String[] args) {
        System.out.println("================ Java Guide ====================");
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("", "");

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


        System.out.println("================ END ====================");
    }

}
