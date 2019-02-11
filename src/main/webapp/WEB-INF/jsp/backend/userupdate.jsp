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
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>修改用户信息 <i class="fa fa-user"></i><small>${userSession.userName}</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <div class="clearfix"></div>
                <form class="form-horizontal form-label-left" action="doupdate" method="post">
                    <input type="hidden" value="${userSession.id}" name="id">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">用户编码 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="userCode" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" name="userCode"   required="required"
                                   placeholder="请输入用户编码" type="text" value="${userSession.userCode}">
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">用户名称 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="userName" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" name="userName"   required="required"
                                   placeholder="请输入用户名称" type="text" value="${userSession.userName}">
                        </div>
                    </div>

                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                            <button id="send" type="submit" class="btn btn-success">保存</button>
                            <button type="button" class="btn btn-primary" id="back">返回</button>
                            <br/><br/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="common/footer.jsp"%>
<script>
    $("#back").on("click",function(){
        window.location.href = "show";
    });
</script>