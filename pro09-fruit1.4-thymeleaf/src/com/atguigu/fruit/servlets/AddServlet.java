package com.atguigu.fruit.servlets;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.myssm.myspringmvc.ViewBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ricardo
 * @create 2022-11-08 16:16
 */
@WebServlet("/add.do")
public class AddServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO=new FruitDAOImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fname = req.getParameter("fname");
        String pricestr = req.getParameter("price");
        int price =Integer.parseInt(pricestr);
        String fcountstr = req.getParameter("fcount");
        int fcount = Integer.parseInt(fcountstr);
        String remark = req.getParameter("remark");

        Fruit fruit=new Fruit(0,fname,price,fcount,remark);
        fruitDAO.addFruit(fruit);
        resp.sendRedirect("index");
    }
}
