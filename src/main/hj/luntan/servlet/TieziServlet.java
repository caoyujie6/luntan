package main.hj.luntan.servlet;

import com.alibaba.fastjson.JSONObject;
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

@WebServlet(name = "TieziServlet",urlPatterns = "/g")
public class TieziServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String qing=request.getParameter("name");
        Tiezi tiezi=new Tiezi();
        tiezi.setBiaoti(qing);
        TieziSeriverImpl tieziSeriver=new TieziSeriverImpl();
        List<String> list=tieziSeriver.chaxun(tiezi);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name", list);
        PrintWriter o=response.getWriter();
        o.print(jsonObject);
        o.flush();
        o.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doPost(request,response);
    }
}
