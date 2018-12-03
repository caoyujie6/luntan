package main.hj.luntan.servlet;

import com.alibaba.fastjson.JSONObject;
import main.hj.luntan.entity.User;
import main.hj.luntan.seriver.impl.TieziSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShanchutzServlet",urlPatterns = "/sc")
public class ShanchutzServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a=request.getParameter("name");
        String b=request.getParameter("id");
        String fanhui=null;
        if (request.getSession().getAttribute("shoujihao")==null){
            fanhui="请先登陆后再进行操作";
        }else {
            User user= (User) request.getSession().getAttribute("shoujihao");
            if (user.getId()==Integer.parseInt(a)){
                TieziSeriverImpl tieziSeriver=new TieziSeriverImpl();
                int cc=tieziSeriver.shanchu(b);
                if (cc<1){
                    fanhui="删除失败，可能服务器在打盹";
                }else {
                    fanhui="删除成功";
                }
            }else {
                fanhui="帖子需要本人才可以删除，谢谢合作";
            }
        }
        System.out.println(fanhui);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("fan",fanhui);
        PrintWriter printWriter=response.getWriter();
        printWriter.print(jsonObject);
        printWriter.flush();
        printWriter.close();
    }
}
