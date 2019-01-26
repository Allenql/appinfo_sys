<%--
  Created by IntelliJ IDEA.
  User: ZQL
  Date: 2019/1/25
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath }/statics/css/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="https://colorlib.com/polygon/gentelella/css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath }/statics/css/custom.min.css" rel="stylesheet">

    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="login">
    <br><br>
<h1 class="page-title" style="text-align: center">用户注册</h1>
<div class="page-header" style="font-size: 18px;margin-left: 660px">请选择您的身份:
    <select id="sele" style="font-size: 15px">
        <option selected>请选择</option>
        <option id="backend" value="backend">后台管理员</option>
        <option id="dev" value="dev">APP开发者</option>
    </select>
    </div>

    <%--用于展示相应的注册页面--%>
<div id="show">

</div>

<div style="display: none" id="dev_div">
    <form>
    用户名:<input type="text" value=""><br>
    密码:<input type="password" value=""><br>
    ...
        <input type="submit" value="立即注册">
    </form>
    <p>已有账号?<a href="#">立即登录</a></p>
</div>

    <div style="display: none" id="back_div">
        <form>
            用户名:<input type="text" value=""><br>
            密码:<input type="password" value=""><br>
            授权用户名:<input type="text" value=""><br>
            授权用户密码:<input type="password" value=""><br>
            ...
            <input type="submit" value="立即注册">
        </form>
        <p>已有账号?<a href="#">立即登录</a></p>
    </div>
</body>
</html>
<script>
$(document).ready(function () {
    $("#sele").change(function () {
       var val = $("#sele").val()
        // alert(val)
        if (val=="backend"){
            $("#dev_div").css('display','none')
            $("#back_div").css('display','block')
        }
        if (val=="dev"){
            $("#back_div").css('display','none')
            $("#dev_div").css('display','block')
        }
        if (val=="请选择"){
            $("#back_div").css('display','none')
            $("#dev_div").css('display','none')
        }
    })
})

</script>