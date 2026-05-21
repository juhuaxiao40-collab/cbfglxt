<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
         用户查询 
        </div>
        <div class="card-body">            <div class="pa10 bg-warning">
                <form class="form-inline" id="formSearch" action="?">                   <div class="form-group">
                      权限
<select class="form-control class_cx" name="cx" id="cx" data-value="${param.cx !=null ? param.cx :''}"  style="width:250px;" >
<option value>请选择权限</option>
<option value="用户">用户</option>
<option value="管理员">管理员</option>
</select>
<script>$(".class_cx").val($(".class_cx").attr("data-value"))</script>

</div>
                   <div class="form-group">
                      用户名
                        <input type="text" class="form-control" placeholder="输入用户名关键词" style="width:300px;"     id="yonghuming" name="yonghuming" value="${param.yonghuming !=null ? param.yonghuming :''}"/>
</div>
                   <div class="form-group">
                      姓名
                        <input type="text" class="form-control" placeholder="输入姓名关键词" style="width:300px;"     id="xingming" name="xingming" value="${param.xingming !=null ? param.xingming :''}"/>
</div>
                   <div class="form-group">
                      性别
<select class="form-control class_xingbie" name="xingbie" id="xingbie" data-value="${param.xingbie !=null ? param.xingbie :''}"  style="width:250px;" >
<option value>请选择性别</option>
<option value="男">男</option>
<option value="女">女</option>
</select>
<script>$(".class_xingbie").val($(".class_xingbie").attr("data-value"))</script>

</div>

<button type="submit" class="btn btn-default">搜索</button>
                    <!--form标签结束-->
                </form>
            </div>            <div class="list-table">
                <table width="100%" border="1" class="table">
                    <thead>
                        <tr align="center">
                            <th width="60" data-field="item">#</th>
                            <th >权限</th>
                            <th >用户名</th>
                            <th >姓名</th>
                            <th >性别</th>
                            <th >头像</th>

                            <th width="220" data-field="handler">处理</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:set var="i" value="0"/><c:forEach items="${list}" var="map"><c:set var="i" value="${i+1}"/>
                    <tr id="${map.id}" pid="">
                        <td width="30" align="center"><label>${i}</label></td>
                            <td>${map.cx}</td>
                            <td>${map.yonghuming}
</td>
                            <td>${map.xingming}
</td>
                            <td>${map.xingbie}</td>
                            <td> <c:choose><c:when test="${'' == map.touxiang }">-</c:when><c:otherwise><img width="100" src="${map.touxiang}"/></c:otherwise></c:choose></td>

                        <td align="center">
<a href="yonghu_detail.do?id=${map.id}" class="btn btn-default" >详情</a>
<a href="yonghu_updt.do?id=${map.id}" class="btn btn-default" >编辑</a>
<a href="yonghudelete.do?id=${map.id}" onclick="return confirm('确定要删除？')" class="btn btn-default" >删除</a>
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