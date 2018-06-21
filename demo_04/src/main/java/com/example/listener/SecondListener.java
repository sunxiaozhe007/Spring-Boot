package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * springBoot整合Listener方式二
 */
public class SecondListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("SecondListener......init........");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
