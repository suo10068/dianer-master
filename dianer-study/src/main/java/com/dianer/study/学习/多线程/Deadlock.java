package com.dianer.study.学习.多线程;

/**
 * 死锁 - 互相持有对方想要获得的锁对象
 */
public class Deadlock {

    private String a = "a";
    private String b = "b";

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            while (true) {
                new A().doSomething();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                new B().doSomething();
            }
        }).start();

    }

    static class A {
        public void doSomething() {
            synchronized (B.class) {
                synchronized (A.class) {
                    System.out.println("A doSomething()" + Thread.currentThread().getName());
                }
            }
        }
    }

    static class B {
        public void doSomething() {
            synchronized (A.class) {
                synchronized (B.class) {
                    System.out.println("B doSomething()" + Thread.currentThread().getName());
                }
            }
        }
    }
}

