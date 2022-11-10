package com.atguigu.fruit.servlets;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.myssm.myspringmvc.ViewBaseServlet;
import com.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ricardo
 * @create 2022-11-08 15:51
 */
@WebServlet("/del.do")
public class DelServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO=new FruitDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidstr=req.getParameter("fid");
        if(StringUtil.isNotEmpty(fidstr)){
            int fid=Integer.parseInt(fidstr);
            fruitDAO.delFruit(fid);
            resp.sendRedirect("index");
        }
    }
}
