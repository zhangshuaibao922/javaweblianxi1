package com.atguigu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;

/**
 * @author Ricardo
 * @create 2022-11-01 18:28
 */
public class Demo01Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo01");
        //服务器内部转发
//        req.getRequestDispatcher("demo02").forward(req,resp);
        //客户端重定向
        resp.sendRedirect("demo02");
    }
}
