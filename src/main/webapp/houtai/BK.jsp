<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/11/20
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="Header.jsp"%>
<html>
<head>
    <title>版块管理</title>
</head>
<body>
<div class="main-wrap">
    <div class="result-wrap">
        <div class="result-content">
            <table class="result-tab" width="100%">
                <tr>
                    <th>序号</th>
                    <th>版块名字</th>
                    <th>版块操作</th>
                </tr>
                <tr>
                    <td>
                        <input name="ids[]" value="59" type="hidden">
                        <input class="common-input sort-input" name="ord[]" value="0" type="text">
                    </td>
                    <td>版块名字</td>
                    <td>
                        <a href="">添加&nbsp;&nbsp;&nbsp;&nbsp;</a>
                        <a href="">修改</a>
                    </td>
                </tr>
            </table>
            <div class="list-page"> 2 条 1/1 页</div>
        </div>
    </div>
</div>
</body>
</html>
