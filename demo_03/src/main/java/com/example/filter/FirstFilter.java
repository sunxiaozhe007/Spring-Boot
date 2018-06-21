package com.example.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * SpringBoot整合Filter方式一
 */
//@WebFilter(filterName = "FirstFilter",urlPatterns = {"*.do","*.jsp"}) 配置多个url
@WebFilter(filterName = "FirstFilter",urlPatterns = "/first")

public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入Filter");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("离开Filter");
    }

    @Override
    public void destroy() {

    }
}
