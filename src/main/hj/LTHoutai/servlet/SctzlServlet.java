package main.hj.LTHoutai.servlet;

import com.alibaba.fastjson.JSONObject;
import main.hj.LTHoutai.seriver.SeriverImpl.TieZiSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SctzServlet",urlPatterns = "/sct")
public class SctzlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        TieZiSeriverImpl tieZiSeriver=new TieZiSeriverImpl();
        int i=tieZiSeriver.shan(Integer.parseInt(id));
        String chu=null;
        if (i>0){
            chu="删除成功";
        }else {
            chu="删除失败";
        }
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("chu",chu);
        PrintWriter printWriter=response.getWriter();
        printWriter.print(jsonObject);
        printWriter.flush();
        printWriter.close();
    }
}
