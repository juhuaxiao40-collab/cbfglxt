<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
         解约查询 
        </div>
        <div class="card-body">            <div class="pa10 bg-warning">
                <form class="form-inline" id="formSearch" action="?">                   <div class="form-group">
                      解约人
                        <input type="text" class="form-control" placeholder="输入解约人关键词" style="width:300px;"     id="jieyueren" name="jieyueren" value="${param.jieyueren !=null ? param.jieyueren :''}"/>
</div>

<button type="submit" class="btn btn-default">搜索</button>
                    <!--form标签结束-->
                </form>
            </div>            <div class="list-table">
                <table width="100%" border="1" class="table">
                    <thead>
                        <tr align="center">
                            <th width="60" data-field="item">#</th>
                            <th >租赁编号</th>
                            <th >客户姓名</th>
                            <th >房源编号</th>
                            <th >解约人</th>
                            <th >解约时间</th>

                            <th width="220" data-field="handler">处理</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:set var="i" value="0"/><c:forEach items="${list}" var="map"><c:set var="i" value="${i+1}"/>
                    <tr id="${map.id}" pid="">
                        <td width="30" align="center"><label>${i}</label></td>
                            <td>${map.zulinbianhao}
</td>
                            <td>${map.kehuxingming}
</td>
                            <td>${map.fangyuanbianhao}
</td>
                            <td>${map.jieyueren}
</td>
                            <td>${Info.subStr(map.jieyueshijian,19,'')}
</td>

                        <td align="center">
<a href="jieyue_detail.do?id=${map.id}" class="btn btn-default" >详情</a>
<a href="jieyue_updt.do?id=${map.id}" class="btn btn-default" >编辑</a>
<a href="jieyuedelete.do?id=${map.id}" onclick="return confirm('确定要删除？')" class="btn btn-default" >删除</a>
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