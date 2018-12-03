package main.hj.LTHoutai.servlet;

import com.alibaba.fastjson.JSONObject;
import main.hj.LTHoutai.common.Gong;
import main.hj.LTHoutai.entiy.GlTz;
import main.hj.LTHoutai.seriver.SeriverImpl.TieZiSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

@WebServlet(name = "JzServlet",urlPatterns = "/jz")
public class JzServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        JSONObject jsonObject=new JSONObject();
        if (request.getSession().getAttribute("jzgd")==null){
            jsonObject.put("list",1);
        }else {
            Gong gong= (Gong) request.getSession().getAttribute("jzgd");
            if (name.equals("1")){
                gong.setDianji(gong.getDianji()+1);
            }else {
                gong.setDianji(gong.getDianji()+1);
                gong.setYemian(gong.getYemianshu());
            }
            request.getSession().setAttribute("jzgd",gong);
            TieZiSeriverImpl tieZiSeriver=new TieZiSeriverImpl();
            List<GlTz> list=tieZiSeriver.cha(gong);
            jsonObject.put("list",list);
        }
        jsonObject.put("n",new Random().nextInt(1000));
        PrintWriter printWriter=response.getWriter();
        printWriter.print(jsonObject);
        printWriter.flush();
        printWriter.close();
    }
}
