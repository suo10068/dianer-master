package 学习模块.多线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 * 1、ReentrantLock
 */
public class _ReentrantLock2 implements Runnable {

    private static ReentrantLock lock1 = new ReentrantLock(true);
    private static ReentrantLock lock2 = new ReentrantLock(true);

    int lock;

    public _ReentrantLock2(int lock) {
        this.lock = lock;
    }

    public static void main(String[] args) throws InterruptedException {
        _ReentrantLock2 r1 = new _ReentrantLock2(1);
        _ReentrantLock2 r2 = new _ReentrantLock2(2);

        Thread t1 = new Thread(r1, "[Thread-r1]");
        Thread t2 = new Thread(r2, "[Thread-r2]");
        t1.start();
        t2.start();

        Thread.sleep(2000);

        t2.interrupt();

    }

    @Override
    public void run() {
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
    }
}
