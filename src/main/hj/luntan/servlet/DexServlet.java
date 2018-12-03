package main.hj.luntan.servlet;

import main.hj.luntan.entity.Login;
import main.hj.luntan.entity.User;
import main.hj.luntan.seriver.impl.LoginSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DexServlet",urlPatterns = "/o")
public class DexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("Name");/*  String pwd=request.getParameter("password");*/
        String password=request.getParameter("password");
        boolean fla=false;
       LoginSeriverImpl loginService=new LoginSeriverImpl();
        try {
            List<User> list=loginService.findAll();
            User user=new User();
            for (int i = 0; i<list.size(); i++) {
                if (list.get(i).getName().equals(name)){
                    fla=true;
                    break;
                }else {
                    fla=false;
                }
            }
            if (fla==false){
                user.setName(name);
                user.setMima(password);
                loginService.insert(user);
            }
            response.setContentType("test/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print(fla);
            out.flush();
            out.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
