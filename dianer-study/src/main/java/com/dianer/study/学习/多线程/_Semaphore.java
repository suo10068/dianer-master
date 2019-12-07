package com.dianer.study.学习.多线程;

import java.util.concurrent.Semaphore;

/**
 * Semaphore(信号量)
 * 用来控制访问特定资源的线程数量，通过协调各个线程，以保证合理的使用公共资源
 *
 * 应用场景：流量控制
 */
public class _Semaphore {

    public static void main(String[] args) {
        int N = 8; // 工人数
        Semaphore semaphore = new Semaphore(2); // 机器数目
        for (int i = 0; i < N; i++) {
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人" + this.num + "占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人" + this.num + "释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
