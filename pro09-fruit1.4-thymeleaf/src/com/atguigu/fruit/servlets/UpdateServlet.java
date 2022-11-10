package com.atguigu.fruit.servlets;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.myssm.myspringmvc.ViewBaseServlet;
import com.atguigu.fruit.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Ricardo
 * @create 2022-11-08 15:00
 */
@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO=new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取参数
        String fidstr=request.getParameter("fid");
        int fid=Integer.parseInt(fidstr);
        String fname=request.getParameter("fname");
        String pricestr=request.getParameter("price");
        int price=Integer.parseInt(pricestr);
        String fcountstr=request.getParameter("fcount");
        int fcount=Integer.parseInt(fcountstr);
        String remark=request.getParameter("remark");
        //执行更新
        fruitDAO.updateFruit(new Fruit(fid,fname,price,fcount,remark));
        //资源跳转
//        super.processTemplate("index",request,response);
        //此处需要重定向，目的是重新获取fruitlis，然后覆盖session中，这样页面显示的数据是新的
        response.sendRedirect("index");
    }
}

//java.lang.NumberFormatException: For input string: ""