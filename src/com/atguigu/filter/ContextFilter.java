package com.atguigu.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class ContextFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String context = request.getParameter("context");
        System.out.println(request);
        //if(context!=null){
            if(context.contains(" fuck ")){

            }
        HttpServletRequest req = new MyHttpServletRequest(request);
        chain.doFilter(req,response);
    }
}
