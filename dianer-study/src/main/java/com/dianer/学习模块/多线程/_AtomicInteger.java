package com.dianer.学习模块.多线程;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger
 * 多个线程执行完毕后，才执行另一个线程
 */
public class _AtomicInteger {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(3);
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int time = random.nextInt(5);
                    System.out.println(Thread.currentThread().getName() + "在路上耗时" + time + "秒");
                    try {
                        TimeUnit.SECONDS.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("atomicInteger = " + atomicInteger.decrementAndGet());
                }
            }).start();
        }
        while (atomicInteger.intValue() > 0) {}
        System.out.println("老司机发车。。。。");
    }
}
