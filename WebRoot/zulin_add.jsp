<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">

    <div>
        <div class="card">
            <div class="card-header">租赁添加:</div>
            <div class="card-body">
                <form action="zuling.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->

                    <input type="hidden" id="fangyuanxinxiid" name="fangyuanxinxiid"
                           value="${param.id !=null ? param.id :''}"/>
                    <div class="form-group">
                        <label>房源编号</label>
                        ${readMap.fangyuanbianhao}
                        <input type="hidden" id="fangyuanbianhao" name="fangyuanbianhao"
                               value="${Info.html(readMap.fangyuanbianhao)}"/>

                        <small class="form-text text-muted"></small>

                    </div>
                    <div class="form-group">
                        <label>房源类型</label>
                        ${readMap.fangyuanleixing} <input type="hidden" id="fangyuanleixing" name="fangyuanleixing"
                                                          value="${Info.html(readMap.fangyuanleixing)}"/>

                        <small class="form-text text-muted"></small>

                    </div>
                    <div class="form-group">
                        <label>基础租金</label>
                        ${readMap.jichuzujin}
                        <input type="hidden" id="jichuzujin" name="jichuzujin"
                               value="${Info.html(readMap.jichuzujin)}"/>

                        <small class="form-text text-muted"></small>

                    </div>

                    <%--下拉框选择一个用户--%>
                    <div class="form-group">
                        <label>客户</label>
                        <select class="form-control" name="userid" id="userid">
                            <option value="">请选择客户</option>

                            <c:forEach items="${userList}" var="map">
                                <option value="${map.id}">${map.xingming}：${map.yonghuming}</option>
                            </c:forEach>
                        </select>



                    </div>


                    <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("referer")%>"/>
                    <div class="form-group">
                        <label></label>
                        <button type="submit" class="btn btn-primary" name="Submit">提交</button>
                        <button type="reset" class="btn btn-default" name="Submit2">重置</button>


                        <small class="form-text text-muted"></small>

                    </div>
                </form>
                <script>$(function () {
                    $('#form1').validate();
                });</script>


            </div>
        </div>

        <!-- container定宽，并剧中结束 --></div>


</div>


<%@ include file="foot.jsp" %>