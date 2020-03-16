package com.atguigu.javaweb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class AuthorityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String methodName = request.getParameter("method");
        try {
            Method method = getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private UserDao userDao = new UserDao();
    public void getAuthorities(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String userName = request.getParameter("userName");
        User user = null;
        if (userName != null&&!userName.trim().equals("")) {
            user = userDao.getUserInfo(userName);
        }
        request.setAttribute("user", user);
        request.setAttribute("authorities",userDao.getAuthorities());
        request.getRequestDispatcher("/app/authority-manager.jsp").forward(request, response);
    }
    public void updateAuthority(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String userName = request.getParameter("userName");
        String []urls = request.getParameterValues("authority");

        List<Authority>authorities = userDao.getAuthorities(urls);

        userDao.update(userName,authorities);
        response.sendRedirect(request.getContextPath()+"/app/authority-manager.jsp");
    }

}
