package com.dianer.学习模块.多线程;

import java.util.concurrent.CountDownLatch;

/**
 * @program: root
 * @description:
 * @author: dianer
 * @create: 2020-03-11 21:43
 **/

/**
 * 双重检查锁定
 */
public class _Volatile2 {

    private static volatile Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (_Volatile2.class) {
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }

}

class Instance {

}

