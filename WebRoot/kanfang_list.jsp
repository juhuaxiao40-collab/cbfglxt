<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
            看房申请查询
            <c:if test="${sessionScope.cx == '用户'}">
                <a href="kanfang_add.do" class="btn btn-default pull-right">添加看房申请</a>
            </c:if>
        </div>
        <div class="card-body">
            <div class="pa10 bg-warning">
                <form class="form-inline" id="formSearch" action="?">
                    <div class="form-group">
                        状态
                        <select class="form-control class_zhuangtai" name="zhuangtai" id="zhuangtai"
                                data-value="${param.zhuangtai !=null ? param.zhuangtai :''}"
                                style="width:250px;">
                            <option value>请选择状态</option>
                            <option value="待审核">待审核</option>
                            <option value="已通过">已通过</option>
                            <option value="已拒绝">已拒绝</option>
                        </select>
                        <script>$(".class_zhuangtai").val($(".class_zhuangtai").attr("data-value"))</script>
                    </div>

                    <div class="form-group">
                        <select class="form-control" name="order" id="orderby">
                            <option value="id">最新添加</option>
                        </select>
                        <select class="form-control" name="sort" id="sort">
                            <option value="desc">倒序</option>
                            <option value="asc">升序</option>
                        </select>
                    </div>
                    <script>$("#orderby").val("${orderby}");
                    $("#sort").val("${sort}");</script>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div>
            <div class="list-table">
                <table width="100%" border="1" class="table">
                    <thead>
                    <tr align="center">
                        <th width="60" data-field="item">#</th>
                        <th>房源编号</th>
                        <th>房源名称</th>
                        <th>客户姓名</th>
                        <th>联系方式</th>
                        <th>看房时间</th>
                        <th>状态</th>
                        <th width="220" data-field="handler">处理</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="i" value="0"/><c:forEach items="${list}" var="map"><c:set var="i" value="${i+1}"/>
                        <tr id="${map.id}" pid="">
                            <td width="30" align="center"><label>${i}</label></td>
                            <td>${map.fangyuanbianhao}</td>
                            <td>${map.fangyuanmingchen}</td>
                            <td>${map.kehuxingming}</td>
                            <td>${map.lianxifangshi}</td>
                            <td>${map.kanfangshijian}</td>
                            <td>${map.zhuangtai}</td>
                            <td align="center">
                                <c:if test="${sessionScope.cx == '管理员'}">
                                    <c:choose>
                                        <c:when test="${map.zhuangtai == '待审核'}">
                                            <a href="kanfangupdate.do?id=${map.id}&zhuangtai=已通过" class="btn btn-default">通过</a>
                                            <a href="kanfangupdate.do?id=${map.id}&zhuangtai=已拒绝" class="btn btn-default">拒绝</a>
                                        </c:when>
                                    </c:choose>
                                </c:if>
                                <a href="kanfang_detail.do?id=${map.id}" class="btn btn-default">详情</a>
                                <c:if test="${sessionScope.cx == '用户' && map.zhuangtai == '待审核'}">
                                    <a href="kanfang_updt.do?id=${map.id}" class="btn btn-default">编辑</a>
                                    <a href="kanfangdelete.do?id=${map.id}" onclick="return confirm('确定要删除？')" class="btn btn-default">删除</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <%@ include file="/page.jsp" %>
        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>