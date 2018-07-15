package com.example.demo25.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;

public class QuartzDemo implements Job {

    /**
     * 任务被触发时所执行的方法
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("Execute..."+new Date());
    }
}
