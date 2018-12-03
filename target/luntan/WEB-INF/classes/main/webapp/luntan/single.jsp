<%@ page import="main.hj.luntan.seriver.impl.LoginSeriverImpl" %>
<%@ page import="main.hj.luntan.entity.Bankuai" %>
<%@ page import="java.util.List" %>
<%@ page import="main.hj.luntan.entity.HuiFuLianBiao" %>
<%@ page import="main.hj.luntan.entity.User" %>
<%@ page import="main.hj.luntan.entity.Tiezi" %>
<%@ page isELIgnored="false" %>
<%@ include file="daohang.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!doctype html>
        <html>
           <body>
                <!-- META TAGS -->
                <meta charset="UTF-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Knowledge Base Theme</title>
                <link rel="shortcut icon" href="images/favicon.png" />
                <!-- Style Sheet-->
                <link rel="stylesheet" href="style.css"/>
                <link rel='stylesheet' id='bootstrap-css-css'  href='css/bootstrap5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='responsive-css-css'  href='css/responsive5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='pretty-photo-css-css'  href='js/prettyphoto/prettyPhotoaeb9.css?ver=3.1.4' type='text/css' media='all' />
                <link rel='stylesheet' id='main-css-css'  href='css/main5152.css?ver=1.0' type='text/css' media='all' />
                <link rel='stylesheet' id='custom-css-css'  href='css/custom5152.html?ver=1.0' type='text/css' media='all' />

                <!-- End of Search Wrapper -->

                <!-- Start of Page Container -->
                <div class="page-container">
                        <div class="container">
                                <div class="row">
                                         <%
                                           Tiezi tiezi= (Tiezi) session.getAttribute("tiezi");
                                           request.setAttribute("Tiezi",tiezi);
                                         %>
                                         <%
                                             LoginSeriverImpl loginSeriver=new LoginSeriverImpl();
                                             int a=loginSeriver.list1(tiezi.getTieziid());
                                         %>
                                    <input type="hidden" id="aa" value="${Tiezi.tieziid}">
                                        <!-- start of page content -->
                                        <div class="span8 page-content">

                                                <article class=" type-post format-standard hentry clearfix">

                                                        <h1 class="post-title"><a href="#">${Tiezi.biaoti}</a></h1>

                                                        <div class="post-meta clearfix">
                                                                <span class="date">${Tiezi.time}</span>

                                                                <span class="category"><a href="#" title="View all posts in Server &amp; Database"><%=loginSeriver.select(tiezi.getBKid()).getName()%></a></span>
                                                                <span class="comments"><a href="#" title="Comment on Integrating WordPress with Your Website"><%=loginSeriver.selectHfTznum(tiezi.getTieziid())%> 评论</a></span>
                                                        </div><!-- end of post meta -->
                                                        <p>${Tiezi.fatieneirong}</p>
                                                </article>

                                                <div class="like-btn">

                                                        <form id="like-it-form" action="#" method="post">
                                                                <span  id="${Tiezi.tieziid}" class="like-it "onclick="x(${Tiezi.tieziid})"><%=a%></span>
                                                                <input type="hidden" name="post_id" value="99">
                                                                <input type="hidden" name="action" value="like_it">
                                                        </form>

                                                </div>
                                                <%--返回列表--%>
                                                <div style="width: 150px; height: 60px; background-color: #2c493c; margin: auto;text-align: center">
                                                            <a onclick="self.location=document.referrer" style="color: white; font-size:20px; margin-top: 30px; line-height: 30px;cursor:pointer ">返回列表</a>
                                                </div>
                                                 <%--评论--%>
                                                <section id="comments">

                                                        <h3 id="comments-title">(3) 评论</h3>
                                                        <input type="button" value="加载更多" onclick="asd()" id="pl">
                                                        <input type="button" value="刷新/显示评论" onclick="asdd()" id="pl1">
                                                        <ol class="commentlist" id="eee" style="border:1px yellowgreen dashed">

                                                        </ol>

                                                        <div id="respond">

                                                                <h3>发表评论</h3>

                                                                <div class="cancel-comment-reply">
                                                                        <a rel="nofollow" id="cancel-comment-reply-link" href="#" style="display:none;">Click here to cancel reply.</a>
                                                                </div>


                                                                <form method="post" id="commentform">
                                                                        <div>
                                                                                <label for="comment">评论</label>
                                                                                <textarea class="span8" name="comment" id="comment" cols="58" rows="10"></textarea>
                                                                        </div>
                                                                        <div>
                                                                                <input class="btn" name="submit" type="button" id="submit"  value="提交评论" onclick="getcomment()">
                                                                        </div>
                                                                </form>

                                                        </div>

                                                </section><!-- end of comments -->

                                        </div>

                                        <!-- end of page content -->

                                        <!-- start of sidebar -->
                                        <aside class="span4 page-sidebar">

                                                <section class="widget">
                                                        <div class="support-widget">
                                                                <h3 class="title">管理员</h3>
                                                                <p class="intro">练习电话：1111111</p>
                                                        </div>
                                                </section>


                                                <section class="widget">
                                                        <h3 class="title">精选文章</h3>
                                                        <ul class="articles">
                                                                <li class="article-entry standard">
                                                                        <h4><a href="single.jsp">第一个精选文章</a></h4>
                                                                        <span class="article-meta">2015年5月&nbsp;&nbsp;<a href="#" title="View all posts in 关键词">关键词</a></span>
                                                                        <span class="like-count">66</span>
                                                                </li>
                                                                <li class="article-entry standard">
                                                                        <h4><a href="single.jsp">第二个精选文章</a></h4>
                                                                        <span class="article-meta">2015年5月&nbsp;&nbsp;<a href="#" title="View all posts in 关键词">关键词</a></span>
                                                                        <span class="like-count">15</span>
                                                                </li>
                                                                <li class="article-entry video">
                                                                        <h4><a href="single.jsp">第三个精选文章</a></h4>
                                                                        <span class="article-meta">2015年5月&nbsp;&nbsp; <a href="#" title="View all posts in 关键词">关键词</a></span>
                                                                        <span class="like-count">8</span>
                                                                </li>
                                                                <li class="article-entry image">
                                                                        <h4><a href="single.jsp">第四个精选文章</a></h4>
                                                                        <span class="article-meta">2015年5月&nbsp;&nbsp;<a href="#" title="View all posts in 关键词">关键词</a></span>
                                                                        <span class="like-count">6</span>
                                                                </li>
                                                        </ul>
                                                </section>
                                        </aside>
                                        <!-- end of sidebar -->
                                </div>
                        </div>
                </div>
                <!-- End of Page Container -->

                <!-- Start of Footer -->
                <footer id="footer-wrapper">
                        <div id="footer" class="container">
                                <div class="row">

                                </div>
                        </div>

                </footer>
                <!-- End of Footer -->

                <a href="#top" id="scroll-top"></a>
                <script type='text/javascript' src='js/jquery-1.8.3.min.js'></script>
                <script type='text/javascript' src='js/jquery.easing.1.34e44.js?ver=1.3'></script>
                <script type='text/javascript' src='js/prettyphoto/jquery.prettyPhotoaeb9.js?ver=3.1.4'></script>
                <script type='text/javascript' src='js/jquery.liveSearchd5f7.js?ver=2.0'></script>
                <script type='text/javascript' src='js/jflickrfeed.js'></script>
                <script type='text/javascript' src='js/jquery.formd471.js?ver=3.18'></script>
                <script type='text/javascript' src='js/jquery.validate.minfc6b.js?ver=1.10.0'></script>
                <script type='text/javascript' src='js/custom5152.js?ver=1.0'></script>

        </body>
           <script src="jquery-3.3.1.js"></script>
           <script type="text/javascript">
                   function  asd() {
                       var name=$("#aa").val()
                       $.getJSON("/gg","name="+name,ddd);
                       function ddd(data) {
                           var a=data.name;
                           if (a=="1"){
                               alert("请先点击刷新/显示评论按钮");
                           } else {
                               $("#eee").append("<p class='"+data.n+"'></p>");
                               $(a).each(function () {
                                   $("."+data.n).prepend("<p>"+"回复内容："+this.huifuneirong+"<span>"+"回复时间："+this.time+"</span>"+"<span>"+"回复人："+this.huifuze+"</span>"+"</p>");
                               })
                           }

                       }
                   }
                   function  asdd() {
                       $("#eee").children().filter("p").remove();
                       var name=$("#aa").val()
                       $.getJSON("/ggg","name="+name,ddd);
                       function ddd(data) {
                           var a=data.name;
                           $("#eee").append("<p class='"+data.n+"'></p>");
                           $(a).each(function () {
                               $("."+data.n).prepend("<p>"+"回复内容："+this.huifuneirong+"<span>"+"回复时间："+this.time+"</span>"+"<span>"+"回复人："+this.huifuze+"</span>"+"</p>");
                           })
                       }
                   }
                   function getcomment() {
                       var comment=document.getElementById("comment").value;
                       if (comment==""){
                       } else {
                           $.getJSON("/huifutie","comment="+comment+"&id=${Tiezi.tieziid}" ,getname)
                           function getname(data) {
                               if (data.code=="0"){
                                   var a=confirm("此操作需要登录")
                                   if (a){
                                       window.location.replace("/luntan/index.jsp");
                                   }
                               } else {
                                   $("#comment").val("");
                                   $("#eee").prepend("<p>"+"回复内容："+data.neirong+"<span>"+"回复时间"+data.time+"</span><span>"+"回复人："+data.user+"</span></p>")
                               }
                           }
                       }

                   }

                   function x(id) {
                       $.getJSON("/k","id="+id,callBack);
                       function callBack(data) {
                           if (data.code=="0"){
                               var aa=confirm("此操作需要登陆");
                               if (aa){
                                   window.location.replace("/luntan/index.jsp");
                               } else {
                                   window.location.replace("/luntan/articles-list.jsp");
                               }
                           }else {
                               if (data.flaa==true){
                                   alert("点赞成功")
                               } else {
                                   alert("取消点赞成功")
                               }
                           }
                           $(".like-it").text(data.ss);
                          /* var str="#"+data.aa;
                           $(str).text(data.ss)*/
                           /* background: url("../images/like.png") no-repeat 4px -24px;
                            color: #395996;
                            cursor: pointer;*/
                       }
                   }


           </script>
</html>