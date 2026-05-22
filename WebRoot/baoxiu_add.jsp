<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
            添加报修申请
        </div>
        <div class="card-body">
            <c:if test="${param.fangyuanmingchen != null && !param.fangyuanmingchen.isEmpty()}">
                <div class="alert alert-info">
                    <strong>报修房源信息</strong><br>
                    房源编号：${param.fangyuanbianhao}<br>
                    房源名称：${param.fangyuanmingchen}
                </div>
            </c:if>

            <form action="baoxiuinsert.do" method="post" id="form">
                <input type="hidden" name="fangyuanbianhao" value="${param.fangyuanbianhao}">
                <input type="hidden" name="fangyuanmingchen" value="${param.fangyuanmingchen}">

                <div class="form-group">
                    <label>选择租赁</label>
                    <select class="form-control" name="zulinbianhao" id="zulinbianhao">
                        <option value="">请选择租赁</option>
                        <c:forEach items="${zulinList}" var="item">
                            <option value="${item.zulinbianhao}" ${param.zulinid == item.id ? 'selected' : ''}>${item.fangyuanbianhao} - ${item.kehuxingming}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label>客户姓名</label>
                    <input type="text" class="form-control" name="kehuxingming" id="kehuxingming" value="${sessionScope.xingming}" placeholder="请输入客户姓名">
                </div>

                <div class="form-group">
                    <label>联系方式</label>
                    <input type="text" class="form-control" name="lianxifangshi" id="lianxifangshi" value="${sessionScope.shoujihao}" placeholder="请输入联系方式">
                </div>

                <div class="form-group">
                    <label>报修类型</label>
                    <select class="form-control" name="baoxiuleixing" id="baoxiuleixing">
                        <option value="">请选择报修类型</option>
                        <option value="水电维修">水电维修</option>
                        <option value="家电维修">家电维修</option>
                        <option value="房屋维修">房屋维修</option>
                        <option value="其他">其他</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>报修内容</label>
                    <textarea class="form-control" name="baoxiuneirong" id="baoxiuneirong" rows="3" placeholder="请输入报修内容"></textarea>
                </div>

                <div class="form-group">
                    <label>备注</label>
                    <textarea class="form-control" name="beizhu" id="beizhu" rows="3" placeholder="请输入备注信息"></textarea>
                </div>

                <button type="submit" class="btn btn-primary">提交报修</button>
                <a href="baoxiu_list_kehu.do" class="btn btn-default">返回列表</a>
            </form>
        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>

<script>
    $("#form").validate({
        rules: {
            zulinbianhao: {required: true},
            kehuxingming: {required: true},
            lianxifangshi: {required: true},
            baoxiuleixing: {required: true},
            baoxiuneirong: {required: true}
        },
        messages: {
            zulinbianhao: "请选择租赁",
            kehuxingming: "请输入客户姓名",
            lianxifangshi: "请输入联系方式",
            baoxiuneirong: "请输入报修内容"
        }
    });
</script>