package main.hj.luntan.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import main.hj.luntan.entity.Tiezi;
import main.hj.luntan.seriver.impl.LoginSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "neirongServlet",urlPatterns = "/neirongServlet")
public class neirongServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int name=Integer.parseInt(request.getParameter("name"));
        LoginSeriverImpl loginSeriver=new LoginSeriverImpl();
        List<Tiezi> list=loginSeriver.findByUserId(name);
        JSONObject object=new JSONObject();
        object.put("name", list);
        PrintWriter printWriter=response.getWriter();
        printWriter.print(object);
        printWriter.flush();
        printWriter.close();
    }
}
