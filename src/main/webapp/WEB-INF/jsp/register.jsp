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
    <script src="/statics/js/jquery.min.js"></script>
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

<div style="display: none" id="dev_div" class="login_wrapper">
    <form method="post" action="/dev/register/doadd" onsubmit="return checkUser()">
        <div>
            <input type="text" class="form-control" id="devCode" name="devCode" placeholder="请输入用户名" required=""/><span
                id="msg"></span>
        </div>
        <br>
        <div>
            <input type="text" class="form-control" name="devName" placeholder="请输入姓名" required=""/>
        </div>
        <br>
        <div>
            <input type="password" class="form-control" pattern="[A-Za-z0-9\w]{4,16}" title="密码必须是4-16位，不能包含特殊字符"
                   name="devPassword" placeholder="请输入密码" required=""/>
        </div>
        <br>
        <div>
            <input type="email" class="form-control" name="devEmail" placeholder="请输入邮箱" required=""/>
        </div>
        <br>
        <div>
            <input type="text" class="form-control" name="devInfo" placeholder="请输入简介"/>
        </div>
        <br>
        <input class="btn btn-success" type="submit" value="立即注册">
    </form>
    <p>已有账号?<a href="/dev/login">立即登录</a></p>
</div>

<div style="display: none" class="login_wrapper" id="back_div">
    <form onsubmit="return checkUserCodeAndPwd()" method="post" action="/user/register/doadd">
        <div>
            <input type="text" class="form-control" id="userCode" name="userCode" placeholder="请输入用户名" required=""/><span
                id="msg1"></span>
        </div>
        <br>
        <div>
            <input type="password" class="form-control" name="userPassword" placeholder="请输入密码" required=""/>
        </div>
        <br>
        <div>
            <input type="text" class="form-control" name="userName" placeholder="请输入姓名" required=""/>
        </div>
        <br>
        <div>
            <input type="text" class="form-control" id="userCode1" name="userCode1" placeholder="请输入授权用户名" required=""/>
        </div>
        <br>
        <div>
            <input type="password" class="form-control" id="userPassword1" name="userPassword1" placeholder="请输入授权用户密码" required=""/>
        </div>
        <br>
        <input type="submit" class="btn btn-success" value="立即注册">
    </form>
    <p>已有账号?<a href="/manager/login">立即登录</a></p>
</div>
</body>
</html>
<script>
    function checkUser() {
        if ($("#msg").text() == '该用户名已存在！') {
            alert("用户名已存在，请勿重复添加！")
            $("#devCode").val("")
            $("#msg").html("")
            return false;
        }
        return true;
    }

    function checkUser1() {
        if ($("#msg1").text() == '该用户名已存在！') {
            alert("用户名已存在，请勿重复添加！")
            $("#userCode").val("")
            $("#msg1").html("")
            return false;
        }
        return true;
    }

    function checkUserCodeAndPwd(){
        var usercode = $("#userCode1").val()
        var userpwd = $("#userPassword1").val()
        if(usercode != 'admin' || userpwd != '123456'){
            alert("授权用户名或密码错误！")
            $("#userCode1").val("")
            $("#userPassword1").val("")
            return false
        }
        return checkUser1();
        // return true
    }

    $(document).ready(function () {
        //验证用户名是否存在   开发者
        $("#devCode").blur(function () {
            // alert("test")
            $.ajax({
                url: '/dev/register/check',
                data: $("#devCode"),
                dataType: "text",
                success: function (data) {
                    // alert(data)
                    $("#msg").html(data)
                },
                error: function (data) {
                    alert("error")
                }
            })
        })
        //验证用户名是否重复   管理员
        $("#userCode").blur(function () {
            // alert("test")
            $.ajax({
                url: '/user/register/check',
                data: $("#userCode"),
                dataType: "text",
                success: function (data) {
                    // alert(data)
                    $("#msg1").html(data)
                },
                error: function (data) {
                    alert("error")
                }
            })
        })

        $("#sele").change(function () {
            var val = $("#sele").val()
            // alert(val)
            if (val == "backend") {
                $("#dev_div").css('display', 'none')
                $("#back_div").css('display', 'block')
            }
            if (val == "dev") {
                $("#back_div").css('display', 'none')
                $("#dev_div").css('display', 'block')
            }
            if (val == "请选择") {
                $("#back_div").css('display', 'none')
                $("#dev_div").css('display', 'none')
            }
        })
    })

</script>