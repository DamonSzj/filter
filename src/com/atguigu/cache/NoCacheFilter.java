package com.atguigu.cache;

import com.atguigu.filter.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCacheFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //使浏览器不缓存页面的过滤器
        //有三个http响应头字段都可以禁止浏览器缓存当前页面，
        response.setDateHeader("Expires",-1);
         response.setHeader("Cache-Control","no-cache");
         response.setHeader("Pragma","no-cache");
         //放行
         chain.doFilter(request,response);
    }
}
