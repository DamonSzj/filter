package com.atguigu.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserNameFilter extends HttpFilter {
    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String username = request.getParameter("username");
        String initUserName = filterConfig.getInitParameter("username");
        if(!username.equals(initUserName)){
            request.setAttribute("message","用户名不正确");
            request.getRequestDispatcher("/filter/login.jsp").forward(request,response);
            return;
        }
        chain.doFilter(request,response);
    }
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig config) throws ServletException {
       this.filterConfig = config;
    }
}
