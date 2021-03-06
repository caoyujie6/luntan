package main.hj.luntan.servlet;

import main.hj.luntan.entity.Shouyanzheng;
import main.hj.luntan.entity.User;
import main.hj.luntan.seriver.impl.LoginSeriverImpl;
import main.hj.luntan.util.GetMessageCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "userServlet",urlPatterns = "/a")
public class userServlet extends HttpServlet {
    private static   HttpSession session=null;
    private String cuowu=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        session = request.getSession(true);
        String name=request.getParameter("name");
      if (name.equals("登陆")){
          this.login(request,response,session);
          if (request.getAttribute("yanzheng")!=null){
//              request.setAttribute("yanzheng","21321");
//              request.getRequestDispatcher("luntan/yanzhengma.jsp").forward(request,response);
              cuowu=java.net.URLEncoder.encode(cuowu, "utf-8");
              response.sendRedirect("luntan/yanzhengma.jsp?yanzheng="+cuowu);
          }else {
              response.sendRedirect("luntan/articles-list.jsp");
          }
      }else if (name.equals("获取验证码")){
          this.getYanzhen(request,response,session);
      }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    //登陆
    public void login(HttpServletRequest request, HttpServletResponse response , HttpSession session) throws ServletException, IOException {
        if (session.getAttribute("shoujihao")==null){
            request.setAttribute("yanzheng","请先获取验证码，谢谢");
            cuowu="请先获取验证码，谢谢";
            return;
//            request.getRequestDispatcher("luntan/yanzhengma.jsp").forward(request,response);
        }
        Shouyanzheng shouyanzheng=(Shouyanzheng)(session.getAttribute("shoujihao"));//通过session获得属性值强转为相对应的类
        System.out.println(((Shouyanzheng)(session.getAttribute("shoujihao"))).getKaishishijian());
        System.out.println(shouyanzheng.getKaishishijian());
        long jieshu=System.currentTimeMillis();
        if ((jieshu-shouyanzheng.getKaishishijian())>300000){//如果超过5分钟判定为验证码失效
            request.setAttribute("yanzheng","验证码超时，请重新获取");
            cuowu="验证码超市，请重新获取";
            return;
//            request.getRequestDispatcher("luntan/yanzhengma.jsp").forward(request,response);
        }
        String shou=request.getParameter("shoujihao");
        if ( !((shouyanzheng.getYanzhengma().equals(request.getParameter("yanzhengma")))&&shou.equals(shouyanzheng.getShoujihao()))){//如果输入得验证码和手机号不匹配则返回登陆注册页面并且提示相对应得信息
            request.setAttribute("yanzheng","验证码错误，请重新输入");
            cuowu="验证码错误，请重新输入";
            return;
//            request.getRequestDispatcher("luntan/yanzhengma.jsp").forward(request,response);
        }else {//如果输入得验证码匹配并且没有超时，则判断数据库中是否存在该用户，不存在添加该用户，存在返回当前用户信息
            LoginSeriverImpl loginSeriver=new LoginSeriverImpl();
            User user1=new User();
            user1.setShoujihao(shou);
            user1.setName(shou);
            List<User> list =loginSeriver.panduan(user1);
            User user=null;
            if (list.size()==0){
                int a=loginSeriver.tj(user1);
                if (a<1){
                    request.setAttribute("yanzheng","注册失败，看看网络是否给力");
                    cuowu="注册失败";
                    return;
//                    request.getRequestDispatcher("luntan/yanzhengma.jsp").forward(request,response);
                }
                user=user1;
            }else {
                user=list.get(0);
            }
            int id=loginSeriver.selectUser(user1.getName());
            user.setId(id);
            session.setAttribute("shoujihao",user);
        }
    }
    //获取验证码
    public void getYanzhen(HttpServletRequest request, HttpServletResponse response , HttpSession session) throws IOException {
        String jieshou=request.getParameter("shoujihao");//接收手机号
        String yanzhengma= GetMessageCode.getCode(jieshou);//给手机号发短信返回String类型得验证码
        long kaishi=System.currentTimeMillis();//获取当前毫秒数
        Shouyanzheng shouyanzheng=new Shouyanzheng(jieshou,kaishi,yanzhengma);//new一个对象
        session.setAttribute("shoujihao",shouyanzheng);//通过request获取Session给属性名，属性值
        response.setContentType("text/html;charset=utf-8");
        PrintWriter o=response.getWriter();
        o.print("发送成功，请在手机上查看！");
        o.flush();
        o.close();
    }

}
