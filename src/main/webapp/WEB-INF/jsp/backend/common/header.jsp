<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>APP后台管理系统</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath }/statics/css/nprogress.css" rel="stylesheet">
  	<!-- iCheck -->
    <link href="${pageContext.request.contextPath }/statics/css/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="${pageContext.request.contextPath }/statics/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="${pageContext.request.contextPath }/statics/css/jqvmap.min.css" rel="stylesheet"/>
    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath }/statics/css/custom.min.css" rel="stylesheet">
    <!-- add localcss 2016-8-21 -->
    <link href='${pageContext.request.contextPath }/statics/localcss/applist.css' rel='stylesheet'>
  </head>
  <body class="nav-md footer_fixed">
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col menu_fixed">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="${pageContext.request.contextPath }/manager/backend/main" class="site_title"><i class="fa fa-paw"></i> <span>APP BMS</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
              <div class="profile_pic">
                <img src="${pageContext.request.contextPath }/statics/images/img.jpg" alt="..." class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>${userSession.userCode }</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>${userSession.userName }</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> APP管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="${pageContext.request.contextPath }/manager/backend/app/list">APP审核</a></li>
                      <li><a href="/user/info/adver">广告推广</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-edit"></i> 用户管理 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="/user/info/show">后台用户管理</a></li>
                      <li><a href="/user/info/devusercheck">开发者资质审核</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-bug"></i> 基础数据维护 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                        <li><a href="${pageContext.request.contextPath }/manager/backend/datadic/list">数据字典</a></li>
                      <li><a href="${pageContext.request.contextPath }/manager/backend/appcategory/list">APP分类管理</a></li>
                    </ul>
                  </li>
                </ul>
              </div>


            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen" id="fullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock" onClick="sAlert('当前屏幕已锁定');">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="${pageContext.request.contextPath }/manager/logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="${pageContext.request.contextPath }/statics/images/img.jpg" alt="">${userSession.userCode }
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="${pageContext.request.contextPath }/manager/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>

                <li role="presentation" class="dropdown">
                 
                  <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                    <li>
                      <a>
                        <span class="image"><img src="${pageContext.request.contextPath }/statics/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="${pageContext.request.contextPath }/statics/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="${pageContext.request.contextPath }/statics/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <a>
                        <span class="image"><img src="${pageContext.request.contextPath }/statics/images/img.jpg" alt="Profile Image" /></span>
                        <span>
                          <span>John Smith</span>
                          <span class="time">3 mins ago</span>
                        </span>
                        <span class="message">
                          Film festivals used to be do-or-die moments for movie makers. They were where...
                        </span>
                      </a>
                    </li>
                    <li>
                      <div class="text-center">
                        <a>
                          <strong>See All Alerts</strong>
                          <i class="fa fa-angle-right"></i>
                        </a>
                      </div>
                    </li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
       <!-- /top navigation -->
		<div class="right_col" role="main">
			<div class="">

              <script>
                document.getElementById("fullScreen").onclick=function(){
                  if(document.documentElement.RequestFullScreen){
                    document.documentElement.RequestFullScreen();
                  }
                  //兼容火狐
                  console.log(document.documentElement.mozRequestFullScreen)
                  if(document.documentElement.mozRequestFullScreen){
                    document.documentElement.mozRequestFullScreen();
                  }
                  //兼容谷歌等可以webkitRequestFullScreen也可以webkitRequestFullscreen
                  if(document.documentElement.webkitRequestFullScreen){
                    document.documentElement.webkitRequestFullScreen();
                  }
                  //兼容IE,只能写msRequestFullscreen
                  if(document.documentElement.msRequestFullscreen){
                    document.documentElement.msRequestFullscreen();
                  }
                }
                // document.getElementById("noFullScreen").onclick=function(){
                //   if(document.exitFullScreen){
                //     document.exitFullscreen()
                //   }
                  //兼容火狐
                //   console.log(document.mozExitFullScreen)
                //   if(document.mozCancelFullScreen){
                //     document.mozCancelFullScreen()
                //   }
                //   //兼容谷歌等
                //   if(document.webkitExitFullscreen){
                //     document.webkitExitFullscreen()
                //   }
                //   //兼容IE
                //   if(document.msExitFullscreen){
                //     document.msExitFullscreen()
                //   // }
                // }
              </script>

              <script language="javascript">
                function sAlert(str)
                {
                  var msgw,msgh,bordercolor;
                  msgw=400;//提示窗口的宽度
                  msgh=100;//提示窗口的高度
                  titleheight=25 //提示窗口标题高度
                  bordercolor="#336699";//提示窗口的边框颜色
                  titlecolor="#99CCFF";//提示窗口的标题颜色
                  var sWidth,sHeight;
                  sWidth=document.body.offsetWidth;//获取窗口宽度
                  sHeight=screen.height;//获取屏幕高度
                  var bgObj=document.createElement("div");//关键在这里，原理：在body中创建一个div，并将其宽度与高度设置为覆盖整个窗体，如此一来就无法对其它窗口时行操作
                  bgObj.setAttribute('id','bgDiv');
                  bgObj.style.position="absolute";
                  bgObj.style.top="0";
                  bgObj.style.background="#777";
                  bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
                  bgObj.style.opacity="0.6";
                  bgObj.style.left="0";
                  bgObj.style.width=sWidth + "px";
                  bgObj.style.height=sHeight + "px";
                  bgObj.style.zIndex = "10000";
                  document.body.appendChild(bgObj);//设置完此div后将其显示出来
                  var msgObj=document.createElement('div');//创建一个消息窗口
                  msgObj.setAttribute("id","msgDiv");
                  msgObj.setAttribute("align","center");
                  msgObj.style.background="white";
                  msgObj.style.border="1px solid " + bordercolor;
                  msgObj.style.position = "absolute";
                  msgObj.style.left = "50%";
                  msgObj.style.top = "50%";
                  msgObj.style.font="12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
                  msgObj.style.marginLeft = "-225px" ;
                  msgObj.style.marginTop = -75+document.documentElement.scrollTop+"px";
                  msgObj.style.width = msgw+"px";
                  msgObj.style.height = msgh+"px";
                  msgObj.style.textAlign = "center";
                  msgObj.style.lineHeight ="25px";
                  msgObj.style.zIndex = "10001";
                  var title=document.createElement("h4"); //创建一个标题，以备放置在消息层
                  title.setAttribute("id","msgTitle");
                  title.setAttribute("align","right");
                  title.style.margin="0";
                  title.style.padding="3px";
                  title.style.background=bordercolor;
                  title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
                  title.style.opacity="0.75";
                  title.style.border="1px solid " + bordercolor;
                  title.style.height="18px";
                  title.style.font="12px Verdana, Geneva, Arial, Helvetica, sans-serif";
                  title.style.color="white";
                  title.style.cursor="pointer";
                  title.innerHTML="解锁";
                  msgObj.innerHTML="<input type='password' id='lock' placeholder='请输入解锁密码' value=''>";
                  title.onclick=function()
                  {
                    // alert(document.getElementById("lock").value)
                    if (document.getElementById("lock").value != null && document.getElementById("lock").value != "") {
                      document.body.removeChild(bgObj);//移除覆盖整个窗口的div层
                      document.getElementById("msgDiv").removeChild(title);//移除标题
                      document.body.removeChild(msgObj);//移除消息层
                    }else{
                      alert("请输入密码")
                    }

                  }
                  document.body.appendChild(msgObj);
                  document.getElementById("msgDiv").appendChild(title);
                  var txt=document.createElement("p");
                  txt.style.margin="1em 0"
                  txt.setAttribute("id","msgTxt");
                  txt.innerHTML=str;
                  document.getElementById("msgDiv").appendChild(txt);
                }
              </script>