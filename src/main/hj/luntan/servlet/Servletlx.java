package main.hj.luntan.servlet;

import com.alibaba.fastjson.JSONObject;
import main.hj.luntan.entity.Shouyanzheng;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Servletlx",urlPatterns = "/aa")
public class Servletlx extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
//        boolean b=false;
//        if (name.equals("111")){
//            b=true;
//        }else {
//            b=false;
//        }
        response.setContentType("application/json;charset=utf-8");
        PrintWriter o=response.getWriter();
//        o.print(b);
//        o.flush();
//        o.close();
        JSONObject jsonObject=new JSONObject();
        Shouyanzheng shouyanzheng=new Shouyanzheng("123",23,"23");
        Shouyanzheng shouyanzheng2=new Shouyanzheng("1723",23,"23");
        Shouyanzheng shouyanzheng1=new Shouyanzheng("123",243,"23");
        Shouyanzheng[] shouyanzhengs=new Shouyanzheng[3];
        shouyanzhengs[1]=shouyanzheng;
        shouyanzhengs[2]=shouyanzheng2;
        shouyanzhengs[0]=shouyanzheng1;
        jsonObject.put("na", jsonObject.toJSONString(shouyanzhengs));
        o.print(jsonObject);
        o.flush();
        o.close();
    }
}
