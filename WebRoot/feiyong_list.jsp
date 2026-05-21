<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
         费用查询 
        </div>
        <div class="card-body">            <div class="pa10 bg-warning">
                <form class="form-inline" id="formSearch" action="?">                   <div class="form-group">
                      房源类型
<select class="form-control class_fangyuanleixing" name="fangyuanleixing" id="fangyuanleixing" data-value="${param.fangyuanleixing !=null ? param.fangyuanleixing :''}"  style="width:250px;" >
<option value>请选择房源类型</option>
<option value="长包房">长包房</option>
<option value="短期房">短期房</option>
</select>
<script>$(".class_fangyuanleixing").val($(".class_fangyuanleixing").attr("data-value"))</script>

</div>
                   <div class="form-group">
                      客户
                        <input type="text" class="form-control" placeholder="输入客户关键词" style="width:300px;"     id="kehu" name="kehu" value="${param.kehu !=null ? param.kehu :''}"/>
</div>
                   <div class="form-group">
                      支付状态
<select class="form-control class_iszf" name="iszf" id="iszf" data-value="${param.iszf !=null ? param.iszf :''}"  style="width:250px;" >
<option value>请选择支付状态</option>
<option value="是">是</option>
<option value="否">否</option>
</select>
<script>$(".class_iszf").val($(".class_iszf").attr("data-value"))</script>

</div>
                   <div class="form-group">
                      费用类型
<select class="form-control class_feiyongleixing" name="feiyongleixing" id="feiyongleixing" data-value="${param.feiyongleixing !=null ? param.feiyongleixing :''}"  style="width:250px;" >
<option value>请选择费用类型</option>
<option value="押金">押金</option>
<option value="租金">租金</option>
<option value="水电费">水电费</option>
<option value="服务费">服务费</option>
</select>
<script>$(".class_feiyongleixing").val($(".class_feiyongleixing").attr("data-value"))</script>

</div>

<div class="form-group">
<select class="form-control" name="order" id="orderby">
<option value="id">最新添加</option>
<option value="feiyongjine">按费用金额</option>

</select>
<select class="form-control" name="sort" id="sort"><option value="desc">倒序</option><option value="asc">升序</option></select>
</div>
<script>$("#orderby").val("${orderby}");$("#sort").val("${sort}");</script>
<button type="submit" class="btn btn-default">搜索</button>
                    <!--form标签结束-->
                </form>
            </div>            <div class="list-table">
                <table width="100%" border="1" class="table">
                    <thead>
                        <tr align="center">
                            <th width="60" data-field="item">#</th>
                            <th >房源类型</th>
                            <th >费用编号</th>
                            <th >客户姓名</th>
                            <th >客户</th>
                            <th >支付状态</th>
                            <th >费用类型</th>
                            <th >费用金额</th>
                            <th >起始日期</th>
                            <th >截止日期</th>
                            <th >添加时间</th>

                            <th width="220" data-field="handler">处理</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:set var="i" value="0"/><c:forEach items="${list}" var="map"><c:set var="i" value="${i+1}"/>
                    <tr id="${map.id}" pid="">
                        <td width="30" align="center"><label>${i}</label></td>
                            <td>${map.fangyuanleixing}</td>
                            <td>${map.feiyongbianhao}
</td>
                            <td>${map.kehuxingming}
</td>
                            <td>${map.kehu}
</td>
                            <td>${map.iszf}
<c:choose><c:when test="${'否' == map.iszf }">
<a href="zhifu/index.jsp?id=${map.id}&biao=feiyong&ordersn=${map.feiyongbianhao}&zongji=${map.feiyongjine}">去支付</a>
</c:when></c:choose>
</td>
                            <td>${map.feiyongleixing}</td>
                            <td>${map.feiyongjine}
</td>
                            <td>${map.qishiriqi}
</td>
                            <td>${map.jiezhiriqi}
</td>
                            <td>${Info.subStr(map.tianjiashijian,19,'')}
</td>

                        <td align="center">
<a href="feiyong_detail.do?id=${map.id}" class="btn btn-default" >详情</a>
<a href="feiyong_updt.do?id=${map.id}" class="btn btn-default" >编辑</a>
<a href="feiyongdelete.do?id=${map.id}" onclick="return confirm('确定要删除？')" class="btn btn-default" >删除</a>
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