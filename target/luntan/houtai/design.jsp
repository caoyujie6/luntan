<%@ include file="Header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
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
    function aaa() {
        var name=$("#gjz").val();
        var bkid=$("#aa option:selected").val();
        var csym=$("#csym").val();
        $.getJSON("/ss","name="+name+"&bkid="+bkid+"&csym="+csym,bb);
        function bb(data) {
            $("#bg tr").children().filter("td").remove();
            var srt=data.list;
            var n=data.n;
            $("#bg").append("<div id='"+n+"'></div>")
            $(srt).each(function () {
                $("#"+n).prepend("<tr id='"+this.id+"'></tr>")
                $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.id+"</td>")
                $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.biaoti+"</td>")
                $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.fatiezhe+"</td>")
                $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.shijian+"</td>")
                $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.dianzan+"</td>")
                $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.pinglun+"</td>")
                $("#"+this.id).append("<td ><input type='button' value='删除' onclick='vvv("+this.id+")'></td>")
                // $("#"+this.id).append("<td onclick=''><input type='button' value='修改' onclick=''></td>")
            })
        }
    }
    function bbb() {
        var name=$("#aaa option:selected").val();
        $.getJSON("/jz","name="+name,cc);
        function cc(data) {
            var a=data.list;
            var n=data.n;
            $("#bg").append("<div id='"+n+"'></div>")
            $(a).each(function () {
                    $("#"+n).prepend("<tr id='"+this.id+"'></tr>")
                    $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.id+"</td>")
                    $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.biaoti+"</td>")
                    $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.fatiezhe+"</td>")
                    $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.shijian+"</td>")
                    $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.dianzan+"</td>")
                    $("#"+this.id).append("<td onclick='tzid("+this.id+")'>"+this.pinglun+"</td>")
                    $("#"+this.id).append("<td><input type='button' value='删除' onclick='vvv("+this.id+")'></td>")
                    // $("#"+this.id).append("<td onclick=''><input type='button' value='修改' onclick=''></td>")
            })
        }
    }
    function vvv(id) {
        if(confirm("确定删除吗")){
            $.getJSON("/sct","id="+id,hui);
            function hui(data) {
                alert(data.chu);
            }
        }
    }
    function tzid(data) {
        window.location.replace("/readmore?id="+data);
    }
</script>
<body>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">作品管理</span></div>
        </div>
        <div class="search-wrap">
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
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="" id="gjz" type="text"></td>
                            <th width="70">初始页面</th>
                            <td><input height="20" width="20" type="text" value="1" id="csym"></td>
                            <td><input id="cx" class="btn btn-primary btn2" name="sub" value="查询" type="button" onclick="aaa()"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="insert.jsp"><i class="icon-font"></i>新增作品</a>
                    </div>
                </div>
                <div class="result-content">
                    <table id="bg" class="result-tab" width="100%">
                        <tr>
                            <%--<th>排序</th>--%>
                            <th>ID</th>
                            <th>标题</th>
                            <%--<th>点击</th>--%>
                            <th>发布人</th>
                            <th>更新时间</th>
                            <th>点赞数</th>
                            <th>评论数</th>
                            <th>删除</th>
                            <%--<th>修改</th>--%>
                        </tr>
                    </table>
                    <input type="button" value="加载更多" onclick="bbb()"/>
                    <th width="120">加载选择：</th>
                    <select id="aaa">
                        <option value="1">页面递增</option>
                        <option value="2">页面初始</option>
                    </select>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>