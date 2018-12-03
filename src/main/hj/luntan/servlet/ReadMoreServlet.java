package main.hj.luntan.servlet;

import main.hj.luntan.entity.Tiezi;
import main.hj.luntan.seriver.impl.LoginSeriverImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReadMoreServlet",urlPatterns = "/readmore")
public class ReadMoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tzid=Integer.parseInt(request.getParameter("id"));
        LoginSeriverImpl impl=new LoginSeriverImpl();
        Tiezi tiezi=impl.findByTZid(tzid);
        request.getSession().setAttribute("tiezi",tiezi);
        response.sendRedirect("/luntan/single.jsp?");
    }
}