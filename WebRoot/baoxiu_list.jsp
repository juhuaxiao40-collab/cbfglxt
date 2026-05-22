<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
            报修管理查询
            <c:if test="${sessionScope.cx == '用户'}">
                <a href="baoxiu_add.do" class="btn btn-default pull-right">添加报修</a>
            </c:if>
        </div>
        <div class="card-body">
            <div class="pa10 bg-warning">
                <form class="form-inline" id="formSearch" action="?">
                    <div class="form-group">
                        报修类型
                        <select class="form-control class_baoxiuleixing" name="baoxiuleixing" id="baoxiuleixing"
                                data-value="${param.baoxiuleixing !=null ? param.baoxiuleixing :''}"
                                style="width:250px;">
                            <option value>请选择报修类型</option>
                            <option value="水电维修">水电维修</option>
                            <option value="家电维修">家电维修</option>
                            <option value="房屋维修">房屋维修</option>
                            <option value="其他">其他</option>
                        </select>
                        <script>$(".class_baoxiuleixing").val($(".class_baoxiuleixing").attr("data-value"))</script>
                    </div>
                    <div class="form-group">
                        状态
                        <select class="form-control class_zhuangtai" name="zhuangtai" id="zhuangtai"
                                data-value="${param.zhuangtai !=null ? param.zhuangtai :''}"
                                style="width:250px;">
                            <option value>请选择状态</option>
                            <option value="待处理">待处理</option>
                            <option value="处理中">处理中</option>
                            <option value="已完成">已完成</option>
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
                        <th>租赁编号</th>
                        <th>房源编号</th>
                        <th>客户姓名</th>
                        <th>报修类型</th>
                        <th>状态</th>
                        <th width="220" data-field="handler">处理</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="i" value="0"/><c:forEach items="${list}" var="map"><c:set var="i" value="${i+1}"/>
                        <tr id="${map.id}" pid="">
                            <td width="30" align="center"><label>${i}</label></td>
                            <td>${map.zulinbianhao}</td>
                            <td>${map.fangyuanbianhao}</td>
                            <td>${map.kehuxingming}</td>
                            <td>${map.baoxiuleixing}</td>
                            <td>${map.zhuangtai}</td>
                            <td align="center">
                                <c:if test="${sessionScope.cx == '管理员'}">
                                    <c:choose>
                                        <c:when test="${map.zhuangtai == '待处理'}">
                                            <a href="baoxiuupdate.do?id=${map.id}&zhuangtai=处理中" class="btn btn-default">开始处理</a>
                                        </c:when>
                                        <c:when test="${map.zhuangtai == '处理中'}">
                                            <a href="baoxiuupdate.do?id=${map.id}&zhuangtai=已完成" class="btn btn-default">完成处理</a>
                                        </c:when>
                                    </c:choose>
                                </c:if>
                                <a href="baoxiu_detail.do?id=${map.id}" class="btn btn-default">详情</a>
                                <c:if test="${sessionScope.cx == '用户' && map.zhuangtai == '待处理'}">
                                    <a href="baoxiu_updt.do?id=${map.id}" class="btn btn-default">编辑</a>
                                    <a href="baoxiudelete.do?id=${map.id}" onclick="return confirm('确定要删除？')" class="btn btn-default">删除</a>
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