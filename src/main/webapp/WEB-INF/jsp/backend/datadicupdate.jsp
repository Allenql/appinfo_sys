<%--
  Created by IntelliJ IDEA.
  User: ZQL
  Date: 2019/1/30
  Time: 16:01
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
                <h2>修改数据字典信息 <i class="fa fa-user"></i><small>${userSession.userName}</small></h2>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">
                <div class="clearfix"></div>
                <form class="form-horizontal form-label-left" action="doupdate" method="post">
                    <div class="item form-group">
                        <li>
                            <div class="form-group">
                                <label class="control-label col-md-3 col-sm-3 col-xs-12">类型名称 <span class="required">*</span>
                                </label>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input value="${id}" name="id" type="hidden">
                                    <select name="typeName" class="form-control">
                                        <%--<c:if test="${allTypeName != null }">--%>
                                            <%--<option value="">--请选择--</option>--%>
                                            <c:forEach var="type" items="${allTypeName}">
                                                <option <c:if test="${type == typeName }">selected="selected"</c:if>
                                                        value="${type}">${type}</option>
                                            </c:forEach>
                                        <%--</c:if>--%>
                                    </select>
                                </div>
                            </div>
                        </li>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">类型值 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="valueName" class="form-control col-md-7 col-xs-12"
                                   data-validate-length-range="20" data-validate-words="1" name="valueName"   required="required"
                                   placeholder="请输入类型值" type="text" value="${valueName}">
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
        window.location.href = "list";
    });
</script>