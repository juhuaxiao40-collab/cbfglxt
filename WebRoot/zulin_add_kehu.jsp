<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
            租赁申请
        </div>
        <div class="card-body">
            <div class="alert alert-info">
                <strong>房源信息</strong><br>
                房源名称：${fangyuan.fangyuanmingchen}<br>
                房源类型：${fangyuan.fangyuanleixing}<br>
                房型：${fangyuan.fangxing}<br>
                面积：${fangyuan.mianji} ㎡<br>
                楼层：${fangyuan.louceng}<br>
                基础租金：${fangyuan.jichuzujin} 元/月
            </div>

            <form action="zulin_insert_kehu.do" method="post" id="form">
                <input type="hidden" name="fangyuanxinxiid" value="${fangyuan.id}">
                <input type="hidden" name="fangyuanbianhao" value="${fangyuan.fangyuanbianhao}">
                <input type="hidden" name="fangyuanleixing" value="${fangyuan.fangyuanleixing}">
                <input type="hidden" name="jichuzujin" value="${fangyuan.jichuzujin}">

                <div class="form-group">
                    <label>客户姓名</label>
                    <input type="text" class="form-control" name="kehuxingming" id="kehuxingming" value="${sessionScope.xingming}" placeholder="请输入客户姓名" required>
                </div>

                <div class="form-group">
                    <label>联系方式</label>
                    <input type="text" class="form-control" name="lianxifangshi" id="lianxifangshi" value="${sessionScope.shoujihao}" placeholder="请输入联系方式" required>
                </div>

                <div class="form-group">
                    <label>备注</label>
                    <textarea class="form-control" name="beizhu" id="beizhu" rows="3" placeholder="请输入备注信息（如入住时间要求等）"></textarea>
                </div>

                <div class="alert alert-warning">
                    <strong>温馨提示：</strong><br>
                    1. 提交申请后请等待管理员审核<br>
                    2. 审核通过后请及时支付租金<br>
                    3. 支付成功后租赁正式生效
                </div>

                <button type="submit" class="btn btn-primary">提交租赁申请</button>
                <a href="fangyuanxinxi_list_kehu.do" class="btn btn-default">返回房源列表</a>
            </form>
        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>

<script>
    $("#form").validate({
        rules: {
            kehuxingming: {required: true},
            lianxifangshi: {required: true}
        },
        messages: {
            kehuxingming: "请输入客户姓名",
            lianxifangshi: "请输入联系方式"
        }
    });
</script>