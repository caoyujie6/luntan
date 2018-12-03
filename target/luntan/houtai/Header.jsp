<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/11/20
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<body>

<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.html">首页</a></li>
                <li><a href="#" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">管理员</a></li>
                <li><a href="#">修改密码</a></li>
                <li><a href="#">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <ul class="sub-menu">
                        <li><a href="User.jsp"><i class="icon-font">&#xe003;</i>用户管理</a></li>
                        <li><a href="design.jsp"><i class="icon-font">&#xe008;</i>帖子管理</a></li>
                        <li><a href="BK.jsp"><i class="icon-font">&#xe006;</i>版块管理</a></li>
                        <li><a href="PL.jsp"><i class="icon-font">&#xe012;</i>评论管理</a></li>
                        <li><a href="design.jsp"><i class="icon-font">&#xe033;</i>广告管理</a></li>
                        <li><a href="QX.jsp"><i class="icon-font">&#xe017;</i>权限管理</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>
