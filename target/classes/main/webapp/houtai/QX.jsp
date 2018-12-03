<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/11/20
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="Header.jsp"%>
<html>
<head>
    <title>权限版块</title>
</head>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<body>
<div>
    <form action="#" method="post">
        <table class="search-tab">
            <tr>
                <th width="70">关键字:</th>
                <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
            </tr>
        </table>
    </form>
</div>
<div class="main-wrap">
    <div class="result-wrap">
        <div class="result-content">
            <table class="result-tab" width="100%">
                <tr>
                    <th>序号</th>
                    <th>角色</th>
                    <th>用户账号</th>
                    <th>用户密码</th>
                    <th>用户发表帖子数</th>
                    <th>发布人</th>
                    <th>用户权限</th>
                    <th>状态</th>
                    <th>是否禁言</th>
                    <th>删除</th>
                </tr>
                <tr>
                    <td>
                        <input name="ids[]" value="59" type="hidden">
                        <input class="common-input sort-input" name="ord[]" value="0" type="text">
                    </td>
                    <td>角色</td>
                    <td>账号</td>
                    <td title="发哥经典"><a target="_blank" href="#" title="发哥经典">用户密码</a> …
                    </td>
                    <td>2</td>
                    <td>admin</td>
                    <td>权限</td>
                    <td>状态</td>
                    <td>
                        <input type="checkbox" name="choose">禁言
                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                        <input type="checkbox" name="choose">解除
                    </td>
                    <td><a href="">删除</a></td>
                </tr>
            </table>
            <div class="list-page"> 2 条 1/1 页</div>
        </div>
    </div>
</div>

</body>
</html>
