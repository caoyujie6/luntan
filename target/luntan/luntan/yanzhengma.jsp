<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/11/12
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>手机登录</title>
</head>
<body>
<c:set var="shou" value=""/>
<c:if test="${sessionScope.shoujihao!=null}">
    <c:set var="shou" value="${sessionScope.shoujihao.shoujihao}"/>
</c:if>
<script src="jquery-3.3.1.js"></script>
<script type="text/javascript">
    var tel
    var time = 60
    var t1
    $(document).ready(function () {
      $("#ccc").click(function () {
          var shouji=document.getElementById("aa").value;
          $.ajax({
              "url":"/a",
              "type":"post",
              "data":"name=获取验证码&shoujihao="+shouji,
              "dataType":"text",
              "success":xx
          });
          function xx(data) {
              $("#ddd").html(data);
          }
      })
        clearInterval(t1);
        $('#ccc').on("click", function() {
            tel = $("#aa").val();
            var myreg = /^1(3[0-9]|5[189]|8[6789])[0-9]{8}$/
            if (!(/^1[34578]\d{9}$/.test(tel))) {
                alert("手机号不正确");
            } else {
                t1 = setInterval(function() {
                    time--
                    $("#ccc").val(time + "秒再获取")
                    $("#ccc").attr("disabled", "disabled")
                    if (time == 0) {
                        time = 60
                        $("#ccc").removeAttr("disabled")
                        $("#ccc").val("获取验证码")
                        clearInterval(t1)
                    }
                }, 1000);
            }
        })
    })
</script>
<form action="/a" method="post">
    <input type="text" id="aa" name="shoujihao" value="${shou}">请输入手机号
    <input id="ccc" type="button" name="yangzhengma"  value="获取验证码">
    <p id="ddd"></p>
    <input type="text" name="yanzhengma">请输入验证码
    <input type="hidden" name="name" value="登陆">
    <c:if test="${param.yanzheng!=null}">
        <span id="sss">
                ${param.yanzheng}
        </span>
    </c:if>
    <input type="submit" value="提交">
</form>
</body>
</html>