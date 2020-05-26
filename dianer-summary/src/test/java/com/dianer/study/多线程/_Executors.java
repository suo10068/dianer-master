package 学习模块.多线程;

import java.util.concurrent.*;

public class _Executors implements Runnable {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(),
            Executors.defaultThreadFactory(),
            new MyHandler());

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Future<?> future = executorService.submit(new _Executors());
            Future<?> future1 = executor.submit(new _Executors());
            System.out.println("======");
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":执行");
    }

    /**
     * 自定义拒绝策略
     */
    public static class MyHandler implements RejectedExecutionHandler {
        public MyHandler() {
        }

        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            throw new RejectedExecutionException("Task " + r.toString() + " rejected from " + e.toString());
        }
    }

}
