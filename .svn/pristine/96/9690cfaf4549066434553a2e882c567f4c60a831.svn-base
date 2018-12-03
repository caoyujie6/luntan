package main.hj.LTHoutai.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import main.hj.LTHoutai.entiy.Bankuai;
import main.hj.LTHoutai.seriver.SeriverImpl.TieZiSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "BkServlet",urlPatterns = "/cbk")
public class BkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TieZiSeriverImpl tieZiSeriver=new TieZiSeriverImpl();
        List<Bankuai> list=tieZiSeriver.kan();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("list",list);
        PrintWriter printWriter=response.getWriter();
        printWriter.print(jsonObject);
        printWriter.flush();
        printWriter.close();
    }
}
