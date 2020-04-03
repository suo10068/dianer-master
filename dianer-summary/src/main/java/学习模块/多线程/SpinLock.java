package 学习模块.多线程;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 注：该例子为非公平锁，获得锁的先后顺序，不会按照进入lock的先后顺序进行。
 */
public class SpinLock {
    private AtomicReference<Thread> reference = new AtomicReference<>();

    public static void main(String[] args) {
        SpinLock lock = new SpinLock();
        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }).start();
    }


    public void lock() {
        Thread current = Thread.currentThread();
        while (!reference.compareAndSet(null, current)) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " === 等待加锁。。。");
        }
        System.out.println(Thread.currentThread().getName() + " === 加锁成功！！！");
    }

    public void unlock() {
        Thread current = Thread.currentThread();
        boolean result = reference.compareAndSet(current, null);
        System.out.println(Thread.currentThread().getName() + " === 解锁成功！！！");
    }


}
