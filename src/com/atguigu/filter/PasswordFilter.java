package com.atguigu.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PasswordFilter extends HttpFilter {
    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
            String password = request.getParameter("password");
            String initPassword = filterConfig.getInitParameter("password");
            if(!password.equals(initPassword)){
                request.setAttribute("message","密码不正确");
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
