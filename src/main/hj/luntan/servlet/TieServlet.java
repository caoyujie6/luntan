package main.hj.luntan.servlet;

import com.alibaba.fastjson.JSONObject;
import main.hj.luntan.common.Gong;
import main.hj.luntan.entity.Tiezi;
import main.hj.luntan.seriver.impl.TieziSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

@WebServlet(name = "TieServlet",urlPatterns = "/tt")
public class TieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String n=request.getParameter("y");
        Gong gong=new Gong(1,"zhutitz","biaoti",name,n,"bankuanid");
        TieziSeriverImpl tieziSeriver=new TieziSeriverImpl();
        List<Tiezi> list=tieziSeriver.mohu(gong);
        request.getSession().setAttribute("gong",gong);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name",list);
        jsonObject.put("n",new Random().nextInt(1000));
        PrintWriter printWriter=response.getWriter();
        printWriter.print(jsonObject);
        printWriter.flush();
        printWriter.close();
    }
}
