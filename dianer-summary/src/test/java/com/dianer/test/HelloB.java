package com.dianer.test;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-07-16 10:02
 **/


public class HelloB {

    static void pong() {
        System.out.println("pong");
    }

    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run(){
                pong();
            }
        };
        t.start();
        System.out.println("ping");
    }
}
