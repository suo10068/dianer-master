package com.dianer.study.学习.设计模式.单例模式;

/**
 * 枚举实现方式
 */
public class Singleton {

    private Singleton() {
    }

    enum Instance {
        INSTANCE;
        private Singleton singleton;

        Instance() {
            System.out.println("实例化。。。。。");
            singleton = new Singleton();
        }

        public Singleton getInstance() {
            return singleton;
        }
    }

    public static Singleton getInstance() {
        return Instance.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }


}
