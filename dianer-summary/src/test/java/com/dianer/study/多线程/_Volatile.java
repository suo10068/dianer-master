package 学习模块.多线程;

import java.util.concurrent.CountDownLatch;

/**
 * @program: root
 * @description:
 * @author: dianer
 * @create: 2020-03-11 21:43
 **/

/**
 * 期望结果：20 x 1000 = 20000
 * 实际结果：无确切结果，可能会小于期望值
 * volatile特性：
 *  1、可以保证该变量对所有线程的可见性
 *  2、保证单个变量读写的原子性，但是无法保证类似i++这种复合操作的原子性
 * 原因：volatile无法保证`N++`操作的原子性，可能会出现两个线程的工作内存同时读取到N=10，再对N赋值+1，
 * 两个线程会将N=11，同步到主内存，两次N++操作，但主内存中N的结果为11，而不是12
 */
public class _Volatile {

    private static volatile int N = 0;

    public static void main(String args[]) throws InterruptedException {
        System.out.println("=======");
        CountDownLatch countDownLatch = new CountDownLatch(20);
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int i = 0;
                    while (i < 1000) {
                        N++;
                        i++;
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("===== " + N);
    }


}
