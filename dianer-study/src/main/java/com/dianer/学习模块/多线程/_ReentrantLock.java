package com.dianer.学习模块.多线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 * 1、ReentrantLock
 */
public class _ReentrantLock {

    /**
     * 1、默认非公平锁
     * 2、指定是否公平锁：true-公平锁 false-非公平锁
     */
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static ReentrantLock reentrantLock2 = new ReentrantLock(true);
    private static ReentrantLock lock1 = new ReentrantLock(true);
    private static ReentrantLock lock2 = new ReentrantLock(true);

    int lock;

    public _ReentrantLock(int lock) {
        this.lock = lock;
    }

    public static void main(String[] args) {
        _ReentrantLock r1 = new _ReentrantLock(1);
        _ReentrantLock r2 = new _ReentrantLock(2);

        r1.lock_2("[Thread-r1]");
        r2.lock_2("[Thread-r2]");
    }


    private void lock_1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                reentrantLock.lock();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
                System.out.println(Thread.currentThread().getName() + " end");
            }
        }, "[Thread--1]").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.lock();
                reentrantLock.unlock();
                System.out.println(Thread.currentThread().getName() + " end");
            }
        }, "[Thread--2]").start();
    }

    private void lock_2(String name) {
        new Thread(() -> {
            try {
                if (lock == 1) {
                    lock1.lockInterruptibly();
                    try {
                        TimeUnit.MILLISECONDS.sleep(500);
                    } catch (InterruptedException e) {

                    }
                    lock2.lockInterruptibly();
                } else {
                    lock2.lockInterruptibly();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

                    }
                    lock1.lockInterruptibly();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getName() + "：线程退出");
            }

        }, name).start();
    }


}
