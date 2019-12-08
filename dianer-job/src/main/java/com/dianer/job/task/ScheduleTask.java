package com.dianer.job.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Async
public class ScheduleTask {

    @Scheduled(cron = "0/5 * * * * *") // 每5秒触发一次
    public void task1() throws Exception {
        Thread.sleep(10000);
        System.out.println("【定时任务-1】 ==== " + Thread.currentThread().getName());
    }

    @Scheduled(cron = "0/3 * * * * *") // 每3秒触发一次
    public void task2() {
        System.out.println("【定时任务-2】 ==== " + Thread.currentThread().getName());
    }

}
