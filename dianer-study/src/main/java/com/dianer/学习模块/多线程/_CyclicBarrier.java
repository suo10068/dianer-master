package com.dianer.学习模块.多线程;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 多个线程执行完毕后，才执行另一个线程
 * [ˈsaɪklɪk]
 */
public class _CyclicBarrier {

    private final static Random random = new Random();

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("老司机发车。。。。");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("老司机发车完成。。。。");
            }
        };
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, runnable);

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                int time = random.nextInt(5);
                System.out.println(Thread.currentThread().getName() + "在路上耗时" + time + "秒");
                try {
                    TimeUnit.SECONDS.sleep(time);
                    System.out.println(Thread.currentThread().getName() + "中断任务，等待。。。");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "继续完成最后的任务");
            }
        };

        for (int i = 0; i < 1; i++) {
            new Thread(runnable2, "[Thread-" + i * 3 + 1 + "]").start();
            new Thread(runnable2, "[Thread-" + i * 3 + 2 + "]").start();
            new Thread(runnable2, "[Thread-" + i * 3 + 3 + "]").start();
            System.out.println("++++++++++++++++++++++++++++++++++");
            System.out.println();
        }

    }

}
