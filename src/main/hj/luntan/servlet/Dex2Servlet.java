package main.hj.luntan.servlet;

import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.Session;
import main.hj.luntan.entity.Login;
import main.hj.luntan.entity.User;
import main.hj.luntan.seriver.impl.LoginSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Dex2Servlet",urlPatterns = "/denglu")
public class Dex2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        String pwd=request.getParameter("password");
        String na9=request.getParameter("name9");
        LoginSeriverImpl loginSeriver=new LoginSeriverImpl();
        int id=loginSeriver.selectUser(name);
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setMima(pwd);
        try {
            List<User> list=loginSeriver.cha(user);
            if (list.size()==0){
                request.setAttribute("aa","用户名或密码不正确");
                response.sendRedirect("luntan/index.jsp");
            }else {
                request.getSession().setAttribute("shoujihao", user);

               /* if ("y".equals(na9)){

                if ("y".equals(na9)){

                /*if ("y".equals(na9)){
                    Cookie cookie=new Cookie("name",name);
                    Cookie cookie1=new Cookie("password",pwd);
                    cookie.setMaxAge(60*60*24*36);
                    cookie1.setMaxAge(60*60*24*36);
                    response.addCookie(cookie);
                    response.addCookie(cookie1);
                }else {
                    Cookie[] coo=request.getCookies();
                    if (coo!=null){
                    for (Cookie c:coo){
                    c.setMaxAge(0);
                    response.addCookie(c);
                    }
                    }
                }*/
                response.sendRedirect("luntan/articles-list.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}