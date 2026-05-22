<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
            房源列表
        </div>
        <div class="card-body">
            <div class="pa10 bg-warning">
                <form class="form-inline" id="formSearch" action="?">
                    <div class="form-group">
                        房源类型
                        <select class="form-control class_fangyuanleixing" name="fangyuanleixing" id="fangyuanleixing"
                                data-value="${param.fangyuanleixing !=null ? param.fangyuanleixing :''}"
                                style="width:250px;">
                            <option value>请选择类型</option>
                            <option value="住宅">住宅</option>
                            <option value="商铺">商铺</option>
                            <option value="写字楼">写字楼</option>
                        </select>
                        <script>$(".class_fangyuanleixing").val($(".class_fangyuanleixing").attr("data-value"))</script>
                    </div>

                    <div class="form-group">
                        <select class="form-control" name="order" id="orderby">
                            <option value="id">最新发布</option>
                            <option value="jichuzujin">租金排序</option>
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
                        <th>房源名称</th>
                        <th>类型</th>
                        <th>房型</th>
                        <th>面积</th>
                        <th>楼层</th>
                        <th>基础租金</th>
                        <th width="180" data-field="handler">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:set var="i" value="0"/><c:forEach items="${list}" var="map"><c:set var="i" value="${i+1}"/>
                        <tr id="${map.id}" pid="">
                            <td width="30" align="center"><label>${i}</label></td>
                            <td>${map.fangyuanmingchen}</td>
                            <td>${map.fangyuanleixing}</td>
                            <td>${map.fangxing}</td>
                            <td>${map.mianji} ㎡</td>
                            <td>${map.louceng}</td>
                            <td>${map.jichuzujin} 元/月</td>
                            <td align="center">
                                <a href="fangyuanxinxi_detail.do?id=${map.id}" class="btn btn-default">查看详情</a>
                                <a href="kanfang_add.do?fangyuanbianhao=${map.fangyuanbianhao}" class="btn btn-primary">申请看房</a>
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