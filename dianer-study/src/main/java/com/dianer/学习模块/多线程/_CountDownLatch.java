package com.dianer.学习模块.多线程;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch 倒计数器
 * 多个线程执行完毕后，才执行另一个线程
 */
public class _CountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

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
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("老司机发车。。。。");
    }

}
