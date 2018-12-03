package main.hj.luntan.servlet;

import com.alibaba.fastjson.JSONObject;
import main.hj.luntan.common.Gong;
import main.hj.luntan.entity.HufuTieZi;
import main.hj.luntan.seriver.impl.HuifuTieZiSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

@WebServlet(name = "HuifuTiZi1Servlet",urlPatterns = "/ggg")
public class HuifuTiZi1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        Gong gong=new Gong(1,"huifutz","huifutzid",name);
        request.getSession().setAttribute("huifu",gong);
        HuifuTieZiSeriverImpl tieziSeriver=new HuifuTieZiSeriverImpl();
        List<HufuTieZi> list=tieziSeriver.de(gong);
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
