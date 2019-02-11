<%--
  Created by IntelliJ IDEA.
  User: ZQL
  Date: 2019/2/1
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    个人账户信息维护 <i class="fa fa-user"></i><small>${devUserSession.devName}
                    - 您可以对您的信息进行修改等管理操作。^_^</small>
                </h2>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_content">
                <p class="text-muted font-13 m-b-30"></p>
                <div id="datatable-responsive_wrapper"
                     class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                    <div class="row">
                        <div class="col-sm-12">
                            <a onclick="display()" class="btn btn-success btn-sm">修改密码</a>
                            <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed"
                                   cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
                                <thead>
                                <tr role="row">
                                    <th class="sorting_asc" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="First name: activate to sort column descending"
                                        aria-sort="ascending">开发者帐号</th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        开发者名称</th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        开发者电子邮箱</th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        aria-label="Last name: activate to sort column ascending">
                                        开发者简介</th>
                                    <th class="sorting" tabindex="0"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        style="width: 124px;"
                                        aria-label="Last name: activate to sort column ascending">
                                        操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <tr role="row" class="odd">
                                        <td tabindex="0" class="sorting_1">${devUserSession.devCode}</td>
                                        <td>${devUserSession.devName }</td>
                                        <td>${devUserSession.devEmail }</td>
                                        <td>${devUserSession.devInfo }</td>
                                        <td>
                                            <div class="btn-group">
                                                <button type="button" class="btn btn-danger">点击操作</button>
                                                <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                                    <span class="caret"></span>
                                                    <span class="sr-only">Toggle Dropdown</span>
                                                </button>
                                                <ul class="dropdown-menu" role="menu">
                                                    <li><a  class="viewApp" href="/dev/info/update"  data-toggle="tooltip" data-placement="top" title="" data-original-title="修改个人信息">修改</a></li>
                                                </ul>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div id="show" style="display: none">
                <div class="x_content">
                    <div class="clearfix"></div>
                    <form class="form-horizontal form-label-left" action="/dev/info/updatepwd" method="post" onsubmit="return checkPwd()">
                        <input type="hidden" value="${devUserSession.id}" id="id" name="id">
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">原密码 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="devPassword" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" name="devPassword"   required="required"
                                       placeholder="请输入原密码" type="password"><span id="msg"></span>
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">新密码 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="newDevPassword" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" name="newDevPassword"   required="required"
                                       placeholder="请输入新密码" type="password">
                            </div>
                        </div>
                        <div class="item form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12">确认密码 <span class="required">*</span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                                <input id="newDevPassword2" class="form-control col-md-7 col-xs-12"
                                       data-validate-length-range="20" data-validate-words="1" name="newDevPassword2"   required="required"
                                       placeholder="请再次输入新密码" type="password">
                            </div>
                        </div>
                        <div class="ln_solid"></div>
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-3">
                                <button id="send" type="submit" class="btn btn-success">提交</button>
                                <button type="button" class="btn btn-primary" id="back" onclick="redisplay()">返回</button>
                                <br/><br/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
<%@include file="common/footer.jsp"%>
<script>
    function checkPwd() {
        var newDevPassword = document.getElementById("newDevPassword").value;
        var newDevPassword2 = document.getElementById("newDevPassword2").value;
        if(newDevPassword == newDevPassword2){
            alert("修改成功，请重写登录")
            return true;
        }
        alert("两次密码输入不一致")
        return false;
    }

    function display() {
        document.getElementById("devPassword").value="";
        document.getElementById("newDevPassword").value="";
        document.getElementById("newDevPassword2").value="";
        // document.getElementById("mmm").innerHTML;
        document.getElementById("show").style.display = "block";
    }

    function redisplay() {
        document.getElementById("show").style.display = "none";
    }

    $(document).ready(function () {
        // alert("0000")
        $("#devPassword").blur(function () {
            // alert("1111")
            $.ajax({
                url:"/dev/info/checkpwd",
                data:{id:$("#id").val(),devPassword:$("#devPassword").val()},
                datatype:"html",
                success:function (data) {
                    // alert(data)
                    $("#msg").html(data)
                    if(data == "<span id='mmm' style='color:red'>旧密码错误<span>"){
                        $("#devPassword").val("")
                    }
                },
                error:function () {
                    alert("error")
                }
            })
        })
    })
</script>