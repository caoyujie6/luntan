<%@ page import="main.hj.luntan.seriver.impl.LoginSeriverImpl" %>
<%@ page import="main.hj.luntan.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 嘟嘟
  Date: 2018/11/15
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>sd</title>
</head>
<script src="jquery-3.3.1.js"></script>
<script>
    $(document).ready(function () {
        $("#div1").hide();
            $("#a").click(function () {
                $("#div1").toggle();
                $.getJSON("/neirongServlet","name=14",xx);
                function xx(data) {
                    $("#div1").children().filter("p").remove();
                    var srt=data.name;
                    // var o=event('('+srt+')');
                    //alert(srt)
                    $(srt).each(function () {
                        $("#div1").append("<p>"+"帖子标题："+this.biaoti+"</p>");
                        $("#div1").append("<p>"+"发帖时间："+this.time+"</p>");
                        $("#div1").append("<p>"+"帖子内容："+this.fatieneirong+"</p>");
                    })
                }
            })
        });


  <%
    LoginSeriverImpl loginSeriver=new LoginSeriverImpl();
    User user=(User) request.getSession().getAttribute("shoujihao");
    int a=user.getId();

     int ww=loginSeriver.fatieren(a);

         int ss=user.getId();
         int ss1=loginSeriver.pinglun(ss);

         int ee=user.getId();
         int ee1=loginSeriver.list2(ee);

     %>

    </script>
<body>
<img src="images/2.png" style="float: left;position: absolute">
<div style="margin-left: 30px; float: left; position: relative;color: greenyellow">
    <h2>个人中心</h2>
    <form action=# method="post">
        用户名<p id="sss"><c:out value="${sessionScope.shoujihao.name}" default="这家伙很懒，没留下任何信息"/></p>
        <p>我的帖子<input type="button" value="&GT;" id="a" style="border-radius: 50%;border-style: none" ></p>
        <p>发布帖子数:<%=ww%></p>
        <p>评论数:<%=ss1%></p>
        <p>点赞数:<%=ee1%></p>
        <p>修改密码<input type="button" value=">"/></p>
    </form>

</div>

<div id="div1" style=" width: 500px; float: left; position: relative ; margin-top: 100px; margin-left: 200px;color: greenyellow" ></div>
</body>
</html>
