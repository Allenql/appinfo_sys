<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>APP开发者平台</title>

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
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <form action="dologin" method="post">
                    <h1>APP开发者平台</h1>
                    <div>
                        <span style="color: lawngreen;">${msg}</span>
                        <input type="text" class="form-control" name="devCode" placeholder="请输入用户名" required=""/>
                    </div>
                    <div>
                        <input type="password" class="form-control" name="devPassword" placeholder="请输入密码" required=""/>
                    </div>
                    <span>${error }</span>
                    <div>
                        <button type="submit" class="btn btn-success">登 录</button>
                        <button type="reset" class="btn btn-default">重　填</button>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <div>
                            <p>©2019 All Rights Reserved. </p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>
</div>

<!-- 修改密码 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    密码重置
                </h4>
            </div>
            <form id="resetPwdForm" method="post">
                <div class="modal-body">
                    用户名：<input type="text" placeholder="请输入用户名以验证您的身份" name="devCode" id="code" required><br><br>
                    邮箱：<input type="email" placeholder="请输入邮箱以验证您的身份" name="devEmail" id="email" required><br><br>
                    密码：<input type="password" placeholder="请输入新密码" name="devPassword" required id="pwd1"><br><br>
                    确认密码：<input type="password" placeholder="请再次输入新密码" required id="pwd2">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <%--<button type="button" class="btn btn-primary">--%>
                    <%--提交--%>
                    <%--</button>--%>
                    <input type="button" id="submit" value="提交" class="btn btn-primary">
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(function () {
        if ($("#pwd1").val() != $("#pwd2").val()) {
            alert("两次密码输入不一致!");
            $("#pwd2").val("")
        } else {
            $("#submit").click(function () {
                if ($("#code").val() == null || $("#email").val() == "" || $("#pwd1").val() == "" || $("#pwd2").val() == "" || $("#code").val() == "") {
                    alert("请填写完整再提交");
                } else {
                    if ($("#pwd1").val() != $("#pwd2").val()) {
                        alert("两次密码输入不一致!");
                        $("#pwd2").val("")
                    } else {
                        $.ajax({
                            type: "POST",
                            url: "/dev/info/resetpwd",
                            data: $("#resetPwdForm").serialize(),
                            dataType: "json",
                            success: function (data) {
                                if (data.res == "success") {
                                    alert("密码重置成功!")
                                    location.href = "/dev/login";
                                } else {
                                    alert("密码重置失败!")
                                }
                            },
                            error: function () {
                                alert("error")
                            }
                        })
                    }
                }
            })
        }
    })
</script>
</body>
</html>