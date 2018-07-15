package com.example.demo25.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
public class QuartzMain {

    public static void main(String[] args) throws SchedulerException {


        //创建Job对象，你要做什么事？
        JobDetail jobDetail = JobBuilder.newJob(QuartzDemo.class).build();

        //创建Trigger对象，在什么时间做?
        /**
         * 简单的trigger触发时间，通过Quartz提供一个方法来完成简单的重复调用
         * cron表达式，按照Cron的表达式来给定触发的时间
         */
        TriggerBuilder<CronTrigger> trigger = TriggerBuilder.newTrigger().withSchedule((ScheduleBuilder<CronTrigger>) CronScheduleBuilder.cronSchedule("0/2 * * * * ?").build());

        //创建Scheduler对象，在什么时间做什么事？
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail, (Trigger) trigger);
    }
}
