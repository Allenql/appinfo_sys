<%--
  Created by IntelliJ IDEA.
  User: ZQL
  Date: 2019/2/1
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../backend/common/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>
                    开发者资质审核 <i class="fa fa-user"></i><small>${userSession.userName}
                    - 您可以对开发者的信息进行审核等管理操作。^_^</small>
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
                            <a onclick="" class="btn btn-success btn-sm">请对以下开发者信息进行审核</a>
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
                                    <th class="sorting" tabindex="0" colspan="2"
                                        aria-controls="datatable-responsive" rowspan="1" colspan="1"
                                        style="width: 124px;"
                                        aria-label="Last name: activate to sort column ascending">
                                        操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${devUserList == '[]'}">
                                    <tr role="row" class="odd">
                                        <td colspan="6" style="font-size: 24px"><center>暂时没有需要审核的开发者信息哦</center></td>
                                    </tr>
                                </c:if>
                                <c:forEach var="devUser" items="${devUserList}">
                                    <tr role="row" class="odd">
                                        <td tabindex="0" class="sorting_1">${devUser.devCode}</td>
                                        <td>${devUser.devName }</td>
                                        <td>${devUser.devEmail }</td>
                                        <td>${devUser.devInfo }</td>
                                        <td>
                                            <a class="btn btn-success" href="/dev/info/doupdateinte?id=${devUser.id}&intelligence=2">审核通过</a>
                                        </td>
                                        <td>
                                            <a class="btn btn-success" href="/dev/info/doupdateinte?id=${devUser.id}&intelligence=3">审核不通过</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../developer/common/footer.jsp"%>