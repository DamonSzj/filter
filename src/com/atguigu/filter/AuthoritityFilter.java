package com.atguigu.filter;

import com.atguigu.javaweb.Authority;
import com.atguigu.javaweb.User;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthoritityFilter extends HttpFilter {
    public void destroy() {
    }
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //使用 Filter 如何进行过滤:

        String URL = request.getRequestURL().toString();
        String URI = request.getRequestURI();
        //获取 servletPath, 类似于 /app_3/article1.jsp
        String servletPath = request.getServletPath();

        System.out.println(URL);
        System.out.println(URI);
        System.out.println(servletPath);

        //不需要拦截的url列表
        List<String> urls = Arrays.asList("/app/403.jsp", "/app/articles.jsp", "/app/authority-manager.jsp", "/login.jsp", "/logout.jsp");
        if (urls.contains(servletPath)) {
            chain.doFilter(request, response);
            return;
        }
        //- 在用户已经登录(可使用 用户是否登录 的过滤器)的情况下, 获取用户信息. session.getAttribute("user")
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        List<Authority> authorities = user.getAuthorities();

        Authority authority = new Authority(null, servletPath);
        //- 检验用户是否有请求  servletPath 的权限: 可以思考除了遍历以外, 有没有更好的实现方式
        if (authorities.contains(authority)) {
            //- 若有权限则: 响应
            chain.doFilter(request, response);
            return;
        }
        //- 若没有权限: 重定向到 403.jsp
        response.sendRedirect(request.getContextPath() + "/app/403.jsp");
        return;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
