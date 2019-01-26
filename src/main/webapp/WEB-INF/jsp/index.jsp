<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>后台管理系统</title>

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
  </head>

  <body class="login">
  <br/><br/><br/><br/><br/>
    <div class="login_wrapper">
      <h1>APP信息管理平台</h1>
      <br><br/>
      <div style="margin-top: 10px; margin-left: -100px">
      <a href="manager/login" class="btn btn-link"><img style="width: 200px" alt="后台管理系统 入口" src="${pageContext.request.contextPath }/statics/images/manage.png"></a>
      <%--<a href="manager/login" class="btn btn-link">后台管理系统 入口</a>--%>
      </div>
      <div style="margin-top: -155px; margin-left: 160px">
      <a href="dev/login" class="btn btn-link"><img style="width: 200px"  alt="开发者平台 入口" src="${pageContext.request.contextPath }/statics/images/dev.png"></a>
      <%--<a href="dev/login" class="btn btn-link">开发者平台 入口</a>--%>
      </div>
      <p style="margin-left: 80px">没有账号？<a href="/register/">立即注册</a></p>
    </div>
  </body>
</html>