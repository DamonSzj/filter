package com.atguigu.encoding;

import com.atguigu.filter.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingCharsetFilter extends HttpFilter {
    private String encoding;
    /**
     * 抽象方法，为 Http 请求定制，必须实现的方法
     *
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(encoding);
        chain.doFilter(request,response);
    }

    /**
     * 供子类继承的初始化方法，可以通过 getFilterConfig() 获取 FilterConfig 对象
     */
    @Override
    protected void init() {
         encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
    }
}
