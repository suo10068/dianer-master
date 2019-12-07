package com.dianer.study.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class _ThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(2);
        executor.submit(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

}
