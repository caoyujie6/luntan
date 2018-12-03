package main.hj.luntan.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import main.hj.luntan.entity.Tiezi;
import main.hj.luntan.entity.User;
import main.hj.luntan.seriver.impl.HuifuTieZiSeriverImpl;
import main.hj.luntan.seriver.impl.LoginSeriverImpl;
import main.hj.luntan.seriver.impl.TieziSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShanchuPLServlet",urlPatterns = "/scc")
public class ShanchuPLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String tzid=request.getParameter("tzid");
        String huifuid=request.getParameter("huifuid");
        LoginSeriverImpl loginSeriver=new LoginSeriverImpl();
        Tiezi tiezi=loginSeriver.findByTZid(Integer.parseInt(tzid));
        JSONObject jsonObject=new JSONObject();
        String xianshi=null;
        if (request.getSession().getAttribute("shoujihao")==null){
            xianshi="请先登陆";
            jsonObject.put("name",xianshi);
        }else {
            if (tiezi.getUserid()==((User)request.getSession().getAttribute("shoujihao")).getId()||Integer.parseInt(id)==((User)request.getSession().getAttribute("shoujihao")).getId()){
                HuifuTieZiSeriverImpl huifuTieZiSeriver=new HuifuTieZiSeriverImpl();
                int i=huifuTieZiSeriver.shnchu(huifuid);
                if (i<1){
                    xianshi="删除失败，服务器正在打盹！";
                    jsonObject.put("name",xianshi);
                }else {
                    xianshi="删除成功";
                    jsonObject.put("name",xianshi);
                }
            }else {
                xianshi="没有权限删除";
                jsonObject.put("name",xianshi);
            }
        }
        PrintWriter printWriter=response.getWriter();
        printWriter.print(jsonObject);
        printWriter.flush();
        printWriter.close();
    }
}
