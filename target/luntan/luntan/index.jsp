<!--
	Author: W3layouts

-->

<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>>
<html>
<head>
	<title>恒迹论坛登录和注册</title>
	<link rel="stylesheet" href="css/style.css">
	<link href="css/popup-box.css" rel="stylesheet" type="text/css" media="all" />
	<!--<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
-->
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Sign In And Sign Up Forms  Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

	</script><script src="js/jquery.min.js"></script>
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<script type="text/javascript" src="js/modernizr.custom.53451.js"></script>
	<script src="jquery.cookie.js"></script>
 <script>

						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});

                            $("#jiantou").click(function () {
                                history.back(-1);
                            });
                            $("#jiantou").hover(function () {
                                $("#jiantou").css("cursor", "pointer");
                                $("#jiantou").css("color", "blue")
                            },function () {
                                    $("#jiantou").css("color","#fff")
                            });
																						
						});

                        function getmima() {
                            var mima=document.getElementById("usermima").value;
                            var mima2=document.getElementById("usermima2").value;
                            if (mima2!=mima){
                                $("#div1").html("两次密码不一致，请重输");
							}else {
                                $("#div1").html("");
							}
                        }

                        function mima() {
                            var mima=document.getElementById("mima").value;
                            var mima2=document.getElementById("mima1").value;
                            if (mima2!=mima){
                                $("#div2").html("两次密码不一致，请重输");
                            }else {
                                $("#div2").html("");
							}
                        }3
                        function checksubmit() {
                            if (document.form1.password.value!=document.form1.password1.value||document.form1.Name.value==""){
                                return false;
							}else {
                                var name=document.getElementById("username").value;
                                var passeord=document.getElementById("usermima").value;
                                $.get("/o","Name="+name+"&password="+passeord,callBack);
                                function callBack(data) {
                                    if (data =="true"){
                                        $("#div").html("该用户名已被注册");
                                    }else {
                                        $("#div").html("");
                                    }
                                }
                                return true;
							}
                        }
                        function checksubmit1() {
							if (document.form2.password!=document.form2.password1||document.form2.Name==""){
							    return false;
							} else {
							    return true;
							}
                        }
                        $(document).ready(function () {
                            if ($.cookie("rmbUser") == "true") {
                                document.getElementById("brand1").check=true;
                                $("#deng").val($.cookie("username"));
                                $("#deng1").val($.cookie("password"));
							}
                        });
	 					/*function Userinfo() {
							if ($("#brand1").attr("checked") ){
                                var username=$("#deng").val();
                                var password=$("#deng1").val();
                                $.cookie("rmbUser","true",{expires:7});
                                $.cookie("deng",username,{expires:7});
                                $.cookie("deng1",password,{expires:7});
							} else {
                                $.cookie("rmbUser","false",{expires:-1});
                                $.cookie("deng",'',{expires:-1});
                                $.cookie("deng1",'',{expires:-1});
							}
                        }*/




                        <%
                        String name="";
                        String pwd="";
                            Cookie[] cookies=request.getCookies();
                            for(int i = 0; i <cookies.length ; i++) {
                              if ("name".equals(cookies[i].getName())){
                                  name=cookies[i].getValue();
                              }else if ("password".equals(cookies[i].getName())){
                                  pwd=cookies[i].getValue();
                                  out.print(pwd);
                              }
                            }
                        %>
</script>	
		
</head>
<body>
    <span style="margin-left: 100px;color: white ;font-size: 60px;position: fixed" id="jiantou"><img src="images/timg.jpg" width="150" height="150" onclick="history.back(-1)"></span>
	<h1><img src="images/LOGO(带字透明).png" width="500" height="170"></h1>
	<div class="w3layouts">
		<div class="signin-agile">
			<h2>登录</h2>
			<form  method="post" action="/denglu">
				<p><input type="text" name="name" class="name" placeholder="用户名" required="" id="deng" value=<%=name%>></p>
				<p><input type="password" name="password" class="password" placeholder="密码" required=""  id="deng1" value=<%=pwd%></p>
					<ul>
					<li>
                        <input type="checkbox" id="brand1"  value="y" name="name9">
						<label for="brand1" ><span></span>记住密码</label>
					</li>
				</ul>
				<a style="position: relative;   color:#cccccc;top: 66%" class="book popup-with-zoom-anim button-isi zoomIn animated"  href="#small-dialog2">忘记密码</a>
				<div class="clear"></div>
				<input type="submit" value="登录" onclick="Userinfo()">
			</form>
		</div>
		<div class="signup-agileinfo">
			<h3>注册</h3>
			<p>标志以星星为主题标识，由公司名称“恒迹科技”拓展而来。恒代表：恒星、永恒。迹代表： 痕迹、迹象、奇迹
				LOGO整体颜色为蓝色渐变、蓝色象征，未来、科技、理智、广阔寓意着科技来带腾飞，走向国际、走向未来。
				特殊的图形处理使整体logo看起来更具有国际化，也正符合公司的核心理念：为客户创造梦想、以及为客户带来高科技的体验。
			</p>
			<div class="more">
				<a class="book popup-with-zoom-anim button-isi zoomIn animated" data-wow-delay=".5s" href="#small-dialog">点击注册</a>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="footer-w3l">
	</div>
	<div class="pop-up">
	<div id="small-dialog" class="mfp-hide book-form">
		<h3>注册</h3>
			<form action="#" method="get" name="form1" onsubmit=" return checksubmit()">
				<p><span id="div" style="color: red"></span><input type="text" name="Name" placeholder="用户名由英文字母和数字组成的4-16位字符，以字母开头" required=""pattern="[a-zA-Z][a-zA-Z0-9]{3,15}" id="username" /></p>
				<input type="password" name="password" class="password" placeholder="密码：4-10位的字母和数字" required="" pattern="[a-zA-Z0-9]{4-10}" id="usermima"/>
				<p><input type="password" name="password1" class="password" placeholder="重复密码" required="" id="usermima2" onblur="getmima()"/><span id="div1" style="color: red"></span></p>
				<input type="submit" value="点击注册" name="submit">
			</form>
	</div>
    </div>
	<div class="pop-up">
		<div id="small-dialog2" class="mfp-hide book-form">
			<h3>忘记密码</h3>
			<form action="#" method="post" name="form2" onsubmit=" return checksubmit1()">
				<input type="text" name="Name" placeholder="请输入用户名" required=""/>
				<input type="password" name="Password" class="password" placeholder="密码：4-10位的字母和数字" required=""pattern="^[a-zA-Z0-9]{4-10}$" id="mima"/>
				<p><input type="password" name="Password1" class="password" placeholder="重复密码" required="" id="mima2" onblur="mima()"/><span id="div2 " style="color: red"></span></p>
				<input type="submit"  name="submit" value="确认修改">
			</form>
		</div>
	</div>
</body>
</html>