package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义 HttpFilter，实现自Filter 接口
 */
public abstract class HttpFilter implements Filter {
    /**
     * 用于保存 FilterConfig 对象
     */
    private FilterConfig filterConfig;

    /**
     * 空的 destroy 方法
     */
    public void destroy() {
    }

    /**
     * 原生的 doFilter 方法，在方法内部把 ServletRequest 和 ServletResponse
     * 转为了 HttpServletRequest 和 HttpServletResponse 并调用了
     * doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
     * 若编写 filter的过滤方法不建议直接继承此方法，而建议继承
     * doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 方法
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request =(HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) resp;
        doFilter(request,response,chain);
    }

    /**
     * 抽象方法，为 Http 请求定制，必须实现的方法
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException;

    /**
     * 不建议子类直接覆盖，若直接覆盖，将可能会导致 filterConfig 成员变量初始化失败
     * @param filterConfig
     * @throws ServletException
     */
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        init();
    }

    /**
     * 供子类继承的初始化方法，可以通过 getFilterConfig() 获取 FilterConfig 对象
     */
    protected void init() {
    }

    /**
     * 直接返回 init(FilterConfig) 的 FilterConfig 对象
     * @return
     */
    public FilterConfig getFilterConfig() {
        return filterConfig;
    }
}
