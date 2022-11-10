package com.atguigu.fruit.servlets;

import com.atguigu.fruit.dao.com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.myssm.myspringmvc.ViewBaseServlet;
import com.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Ricardo
 * @create 2022-11-03 15:35
 */
//servlet从3.0开始支持注解方式的注册
@WebServlet("/index")
public class Indexservlet extends ViewBaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session=req.getSession();
        int pageNo=1;
        String oper = req.getParameter("oper");
        //如果是空则说明不是通过表单的查询按钮
        //如果不是空则说明是通过表单的查询按钮

        String keyword=null;
        if(StringUtil.isNotEmpty(oper)&&"search".equals(oper)){
            //说明是点击表单查询发送过来的请求
            //此时pageNo应该还原为1，keyword应该从请求参数中获取
            pageNo=1;
            keyword=req.getParameter("keyword");
            if(StringUtil.isEmpty(keyword)){
                keyword="";
            }
            session.setAttribute("keyword",keyword);
        }else{
            //说明此处不是通过点击表单查询发送过来的请求
            //此时keyword应该从session作用域获取
            String pageNostr = req.getParameter("pageNo");
            if(StringUtil.isNotEmpty(pageNostr)){
                pageNo=Integer.parseInt(pageNostr);
            }
            Object keyword1 = session.getAttribute("keyword");
            if(keyword1!=null){
                keyword=(String) keyword1;
            }else {
                keyword="";
            }
        }



        session.setAttribute("pageNo",pageNo);


        FruitDAOImpl fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword,pageNo);
        //保存到session作用域
        session.setAttribute("fruitList",fruitList);


        int fruitCount = fruitDAO.getFruitCount(keyword);
        int pageCount=fruitCount/5+1;
        session.setAttribute("pageCount",pageCount);
        //thymeleaf会将这个逻辑视图名称对应到物理视图名称上去
        //逻辑视图名称index
        //物理视图名称view-prefix+逻辑视图名称+view-suffix
        //所以真实视图名称是：/ index  .html
        super.processTemplate("index",req,resp);


    }
}
