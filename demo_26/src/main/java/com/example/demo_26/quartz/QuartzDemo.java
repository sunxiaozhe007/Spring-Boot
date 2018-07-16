package com.example.demo_26.quartz;

import com.example.demo_26.service.UsersService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class QuartzDemo implements Job {

    @Autowired
    private UsersService usersService;


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Execute..."+new Date());
        usersService.addUsers();
    }
}
