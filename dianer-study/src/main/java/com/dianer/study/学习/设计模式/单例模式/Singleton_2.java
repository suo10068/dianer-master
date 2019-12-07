package com.dianer.study.学习.设计模式.单例模式;

/**
 * 单例模式 - 2
 * 静态内部类实现
 * 延迟加载
 */
public class Singleton_2 {

    static class Instance {
        private static final Singleton_2 singleton = new Singleton_2();
    }

    static Singleton_2 getInstance() {
        return Instance.singleton;
    }

    public static void main(String[] args) {
        Singleton_2 singleton1 = Singleton_2.getInstance();
        Singleton_2 singleton2 = Singleton_2.getInstance();
        System.out.println(singleton1 == singleton2);
    }


}
