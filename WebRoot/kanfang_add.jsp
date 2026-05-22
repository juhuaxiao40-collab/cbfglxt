<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
            添加看房申请
        </div>
        <div class="card-body">
            <form action="kanfanginsert.do" method="post" id="form">
                <div class="form-group">
                    <label>选择房源</label>
                    <select class="form-control" name="fangyuanbianhao" id="fangyuanbianhao">
                        <option value="">请选择房源</option>
                        <c:forEach items="${fangyuanList}" var="item">
                            <option value="${item.fangyuanbianhao}" ${param.fangyuanbianhao == item.fangyuanbianhao ? 'selected' : ''}>${item.fangyuanmingchen} - ${item.fangxing} - ${item.mianji}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label>客户姓名</label>
                    <input type="text" class="form-control" name="kehuxingming" id="kehuxingming" placeholder="请输入客户姓名">
                </div>

                <div class="form-group">
                    <label>联系方式</label>
                    <input type="text" class="form-control" name="lianxifangshi" id="lianxifangshi" placeholder="请输入联系方式">
                </div>

                <div class="form-group">
                    <label>看房时间</label>
                    <input type="text" class="form-control Wdate" name="kanfangshijian" id="kanfangshijian" onclick="WdatePicker()" placeholder="请选择看房时间">
                </div>

                <div class="form-group">
                    <label>备注</label>
                    <textarea class="form-control" name="beizhu" id="beizhu" rows="3" placeholder="请输入备注信息"></textarea>
                </div>

                <button type="submit" class="btn btn-primary">提交申请</button>
                <a href="kanfang_list_kehu.do" class="btn btn-default">返回列表</a>
            </form>
        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>

<script>
    $("#form").validate({
        rules: {
            fangyuanbianhao: {required: true},
            kehuxingming: {required: true},
            lianxifangshi: {required: true},
            kanfangshijian: {required: true}
        },
        messages: {
            fangyuanbianhao: "请选择房源",
            kehuxingming: "请输入客户姓名",
            lianxifangshi: "请输入联系方式",
            kanfangshijian: "请选择看房时间"
        }
    });
</script>