package main.hj.luntan.servlet;

import com.alibaba.fastjson.JSONObject;
import main.hj.luntan.entity.Bankuai;
import main.hj.luntan.entity.Tiezi;
import main.hj.luntan.entity.User;
import main.hj.luntan.seriver.impl.LoginSeriverImpl;
import main.hj.luntan.util.BadWordUtil2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "FaBiaoServlet",urlPatterns = "/fb")
public class FaBiaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //获取url地址中的数据
            String title=request.getParameter("title");
            String bankuai=request.getParameter("bankuai");
            String wenzhang=request.getParameter("wenzhang");
            wenzhang=BadWordUtil2.replaceBadWord(wenzhang,1,"*");
            //得到当前用户的id
            User user= (User) request.getSession().getAttribute("shoujihao");
            int uid=user.getId();
         /*   System.out.println(uid);
            System.out.println(title+bankuai+wenzhang);*/
            LoginSeriverImpl impl=new LoginSeriverImpl();
            //查找版块名字位xx的版块信息（是为了得到版块id）
            Bankuai bankuai1=impl.selectBK(bankuai);
            int bkid=bankuai1.getId();
            //把帖子添加到数据库（发表帖子）
            Tiezi tiezi=new Tiezi();
            tiezi.setBKid(bkid);
            tiezi.setUserid(uid);
            tiezi.setHuifushu(0);
            tiezi.setBiaoti(title);
            tiezi.setFatieneirong(wenzhang);
            impl.insert(tiezi);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("tishi","发表成功");
            PrintWriter printWriter=response.getWriter();
            printWriter.print(jsonObject);
            printWriter.flush();
            printWriter.close();
    }
}
