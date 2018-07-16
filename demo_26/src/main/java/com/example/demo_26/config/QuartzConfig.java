package com.example.demo_26.config;

import com.example.demo_26.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Quartz配置类
 */
@Configuration
public class QuartzConfig {

    /**
     * 创建Job对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {

        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        //关联自己的Job类
        factoryBean.setJobClass(QuartzDemo.class);

        return factoryBean;
    }
    /**
     * 创建Trigger对象
     * 简单的Trigger对象
     */
   /* @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){

        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();

        //关联JobDetail对象
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());

        //该参数表示一个执行的毫秒数
        factoryBean.setRepeatInterval(2000);

        //设置重复次数
        factoryBean.setRepeatCount(5);

        return factoryBean;

    }*/
    /**
     * 创建Trigger对象
     * Cron Trigger
     */
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){

        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();

        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());

        //设置触发时间
        factoryBean.setCronExpression("0/2 * * * * ?");


        return factoryBean;

    }


    /**
     * 创建Scheduler对象
     */
    @Bean
    public SchedulerFactoryBean schedulerFactory(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory){



        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        //关联Trigger
        factoryBean.setTriggers(cronTriggerFactoryBean.getObject());

        factoryBean.setJobFactory(myAdaptableJobFactory);
        return factoryBean;
    }
}
