package main.hj.luntan.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns = "/Login/*")
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        boolean isAjax=ajaxDofilterSessionNull(request, (HttpServletResponse) resp);

            if (request.getSession().getAttribute("shoujihao")==null){
                HttpServletResponse response= (HttpServletResponse) resp;
                response.sendRedirect("../luntan/index.jsp");
            }else{
                chain.doFilter(req, resp);
            }


    }

    public void init(FilterConfig config) {

    }
    private static boolean ajaxDofilterSessionNull(HttpServletRequest request,HttpServletResponse response){
        boolean isAjax = false;
        if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equals("XMLHttpRequest")) {
            // ajax请求
            response.setHeader("sessionstatus", "timeout");
            isAjax = true;
        }
        return isAjax;
    }


}
