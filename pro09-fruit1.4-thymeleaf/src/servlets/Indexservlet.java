package servlets;

import com.atguigu.fruit.dao.com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.fruit.pojo.com.atguigu.myssm.myspringmvc.ViewBaseServlet;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FruitDAOImpl fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList();
        //保存到session作用域
        HttpSession session = req.getSession();
        session.setAttribute("fruitList",fruitList);
        //thymeleaf会将这个逻辑视图名称对应到物理视图名称上去
        //逻辑视图名称index
        //物理视图名称view-prefix+逻辑视图名称+view-suffix
        //所以真实视图名称是：/ index  .html
        super.processTemplate("index",req,resp);


    }
}
