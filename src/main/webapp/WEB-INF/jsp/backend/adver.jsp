<%--
  Created by IntelliJ IDEA.
  User: ZQL
  Date: 2019/2/1
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<style>
    .arrowLeft,.arrowRight{
        position: absolute;
        width: 30px;
        background:rgba(0,0,0,0.2);
        height: 50px;
        line-height: 50px;
        text-align: center;
        top:200px;
        z-index: 150;
        font-family: "微软雅黑";
        font-size: 28px;
        font-weight: bold;
        cursor: pointer;
        display: none;
    }
    .arrowLeft{left: 10px;}
    .arrowRight{right: 10px;}

    .adver{margin: 0 auto; width: 700px; overflow: hidden; height: 454px; position: relative; background: url("/statics/images/adver01.jpg");}


</style>
<center>
<div class="adver">
    <br><br><br><br><br><br>
    <ul>
        <%--<li><img src="/statics/images/adver01.jpg"></li>--%>
        <%--<li><img src="/statics/images/adver02.jpg"></li>--%>
        <%--<li>3</li>--%>
        <%--<li>4</li>--%>
        <%--<li>5</li>--%>
        <%--<li>6</li>--%>
    </ul>
    <div class="arrowLeft"><</div>
    <div class="arrowRight">></div>
</div>
</center>
<%@include file="common/footer.jsp"%>
<script src="/statics/localjs/jquery-1.12.4.js"></script>
<script src="/statics/localjs/carousel.js"></script>
<script>
    $("#back").on("click",function(){
        window.location.href = "show";
    });
</script>


