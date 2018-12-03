package main.hj.luntan.servlet;

import com.alibaba.fastjson.JSONObject;
import main.hj.luntan.entity.HufuTieZi;
import main.hj.luntan.entity.User;
import main.hj.luntan.seriver.impl.LoginSeriverImpl;
import main.hj.luntan.util.BadWordUtil2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HufuTieServlet",urlPatterns = "/huifutie")
public class HufuTieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int code=0;
        if (request.getSession().getAttribute("shoujihao")==null) {
            JSONObject jsonObject=new JSONObject();
            code=0;
            jsonObject.put("code",code);
            PrintWriter writer=response.getWriter();
            writer.print(jsonObject);
            writer.flush();
            writer.close();

        }else {
            code=1;
            String comment=request.getParameter("comment");
            comment=BadWordUtil2.replaceBadWord(comment,1,"*");
            String id=request.getParameter("id");
            int id2=Integer.parseInt(id);
            Date date=new Date();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=format.format(date);
            HufuTieZi tz=new HufuTieZi();
            //根据name找到登录人的id
            User user= (User) request.getSession().getAttribute("shoujihao");
            int uid=user.getId();
            tz.setHuifuTZid(id2);
            tz.setHuifuneirong(comment);
            tz.setHuifuze(uid);
            LoginSeriverImpl impl=new LoginSeriverImpl();
            //添加回复帖子
            impl.huifutiezi(tz);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("neirong",comment);
            jsonObject.put("time",time);
            jsonObject.put("user",user.getName());
            jsonObject.put("code",code);
            PrintWriter writer=response.getWriter();
            writer.print(jsonObject);
            writer.flush();
            writer.close();
        }

    }
}
