package 学习模块.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class _Executors implements Runnable {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Future<?> future = executorService.submit(new _Executors());
            System.out.println("======");
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":执行");
    }
}
