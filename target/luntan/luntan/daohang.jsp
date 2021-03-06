<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="main.hj.luntan.seriver.impl.LoginSeriverImpl" %>
<%@ page import="main.hj.luntan.entity.Bankuai" %>
<%@ page import="java.util.List" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/11/9
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel='stylesheet' id='main-css-css'  href='css/main5152.css?ver=1.0' type='text/css' media='all' />
</head>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        mydate = new Date();
        myhour = mydate.getHours();
        if (myhour < 6)
            $(".tag-line").text("凌晨好:");
        else if (myhour < 9)
            $(".tag-line").text("早上好:");
        else if (myhour < 12)
            $(".tag-line").text("上午好:");
        else if (myhour < 14)
            $(".tag-line").text("中午好:");
        else if (myhour < 17)
            $(".tag-line").text("下午好:");
        else if (myhour < 19)
            $(".tag-line").text("傍晚好:");
        else if (myhour < 22)
            $(".tag-line").text("晚上好:");
        else
            $(".tag-line").text("夜里好:");
    });

</script>
<body>
<div class="header-wrapper">
    <header>
        <div class="container">
            <div class="logo-container">
                <!-- Website Logo -->
                <a href="#"  title="Knowledge Base Theme">
                    <span class="tag-line"></span>
                    <span id="name">&nbsp;&nbsp;&nbsp;
                        <c:if test="${sessionScope.shoujihao.name==null}"><a href="index.jsp">登录/注册</a></c:if>
                        <c:if test="${sessionScope.shoujihao.name ne null}"><a href="yonghuzhongxin.jsp">${sessionScope.shoujihao.name}</a>
                        <span>&nbsp;&nbsp;&nbsp;<a href="/Zx" style="cursor: pointer">注销</a></span></c:if>
                    </span>
                </a>
            </div>
            <%--获取版块的内容--%>
            <%
                LoginSeriverImpl impl=new LoginSeriverImpl();
                List<Bankuai> BKlist=impl.findAllBK();
               /* request.setAttribute("BKname",BKlist);*/
            %>
            <!-- Start of Main Navigation -->
            <nav class="main-nav">
                <div class="menu-top-menu-container">
                    <ul id="menu-top-menu" class="clearfix">
                        <li><a href="articles-list.jsp">首页</a></li>
                        <%
                            for (int i = 0; i <BKlist.size() ; i++) {
                        %>
                        <li><a href="study.jsp?name=<%=BKlist.get(i).getId()%>"><%=BKlist.get(i).getName()%></a></li>
                        <%
                            }
                        %>
                        <%--<li><a href="happy.jsp">${BKname[0].name}</a></li>
                        <li><a href="game.jsp">${BKname[1].name}</a></li>
                        <li><a href="bagua.jsp">${BKname[2].name}</a></li>
                        <li><a href="study.jsp">${BKname[3].name}</a></li>--%>
                        <li><a href="/Login/fatie">我要发帖</a></li>
                    </ul>
                </div>
            </nav>
            <!-- End of Main Navigation -->
        </div>
    </header>
</div>
</body>

</html>
