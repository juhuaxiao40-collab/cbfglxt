<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
            报修详情
            <a href="javascript:history.back()" class="btn btn-default pull-right">返回</a>
        </div>
        <div class="card-body">
            <table class="table table-bordered">
                <tr>
                    <th width="200">租赁编号</th>
                    <td>${map.zulinbianhao}</td>
                </tr>
                <tr>
                    <th>房源编号</th>
                    <td>${map.fangyuanbianhao}</td>
                </tr>
                <tr>
                    <th>客户姓名</th>
                    <td>${map.kehuxingming}</td>
                </tr>
                <tr>
                    <th>联系方式</th>
                    <td>${map.lianxifangshi}</td>
                </tr>
                <tr>
                    <th>报修类型</th>
                    <td>${map.baoxiuleixing}</td>
                </tr>
                <tr>
                    <th>报修内容</th>
                    <td>${map.baoxiuneirong}</td>
                </tr>
                <tr>
                    <th>状态</th>
                    <td>${map.zhuangtai}</td>
                </tr>
                <tr>
                    <th>备注</th>
                    <td>${map.beizhu}</td>
                </tr>
                <tr>
                    <th>提交时间</th>
                    <td>${map.tianjiashijian}</td>
                </tr>
            </table>
        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>