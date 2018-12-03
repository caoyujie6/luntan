<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/11/20
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="Header.jsp"%>
<html>
<head>
    <title>评论</title>
</head>

<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<script src="jquery-3.3.1.js"></script>
<script>
    $(document).ready(function () {
        $.getJSON("/cbk",aa)
        function aa(data) {
            var srt=data.list;
            $(srt).each(function () {
                $("#aa").append(" <option value=\""+this.id+"\">"+this.name+"</option>")
            })
        }
        // $("#cx").click(function () {
        //     var name=$("#gjz").val();
        //     var bkid=$("option").val();
        //     $.getJSON("/ss","name="+name+"&bkid="+bkid,bb);
        //     function bb(data) {
        //         alert(1)
        //     }
        // })
    })
</script>
<body>
<div class="main-wrap">
    <div class="search-content">
        <form action="#" method="post">
            <table class="search-tab">
                <tr>
                    <th width="120">选择分类:</th>
                    <td>
                        <select name="search-sort" id="aa">
                            <%--<option value="">版块1</option>--%>
                            <%--<option value="19">版块2</option>--%>
                            <%--<option value="20">版块3</option>--%>
                        </select>
                    </td>
                    <th width="70">关键字:</th>
                    <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="" type="text"></td>
                    <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                </tr>
            </table>
        </form>
    <div class="result-wrap">
        <div class="result-content">
            <table class="result-tab" width="100%">
                <tr>
                    <th>序号</th>
                    <th>评论内容</th>
                    <th>评论时间</th>
                    <th>评论人</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>
                        <input name="ids[]" value="59" type="hidden">
                        <input class="common-input sort-input" name="ord[]" value="0" type="text">
                    </td>
                    <td>评论内容</td>
                    <td>评论时间</td>
                    <td>评论人</td>
                    <td>
                        <a class="link-update" href="#">修改  &nbsp;&nbsp;&nbsp;&nbsp;</a>
                        <a class="link-del" href="#">删除</a>
                    </td>
                </tr>
            </table>
            <div class="list-page"> 2 条 1/1 页</div>
        </div>
    </div>
</div>
</body>
</html>
