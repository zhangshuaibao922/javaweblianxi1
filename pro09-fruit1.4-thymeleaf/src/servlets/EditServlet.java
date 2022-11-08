package servlets;


import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.fruit.pojo.com.atguigu.myssm.myspringmvc.ViewBaseServlet;
import com.atguigu.fruit.pojo.com.atguigu.myssm.util.StringUtil;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author Ricardo
 * @create 2022-11-04 11:57
 */
@WebServlet("/edit")
public class EditServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO=new FruitDAOImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fid = request.getParameter("fid");
        if(StringUtil.isNotEmpty(fid)){
            int i = Integer.parseInt(fid);
            Fruit fruit = fruitDAO.getFruitById(i);
            request.setAttribute("fruit",fruit);
            super.processTemplate("edit",request,response);

        }
    }

}
