<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">
    <div class="card">
        <div class="card-header">
            修改报修申请
        </div>
        <div class="card-body">
            <form action="baoxiuupdate.do" method="post" id="form">
                <input type="hidden" name="id" value="${mmm.id}">
                
                <div class="form-group">
                    <label>客户姓名</label>
                    <input type="text" class="form-control" name="kehuxingming" id="kehuxingming" value="${mmm.kehuxingming}" placeholder="请输入客户姓名">
                </div>

                <div class="form-group">
                    <label>联系方式</label>
                    <input type="text" class="form-control" name="lianxifangshi" id="lianxifangshi" value="${mmm.lianxifangshi}" placeholder="请输入联系方式">
                </div>

                <div class="form-group">
                    <label>报修类型</label>
                    <select class="form-control" name="baoxiuleixing" id="baoxiuleixing">
                        <option value="">请选择报修类型</option>
                        <option value="水电维修" ${mmm.baoxiuleixing == '水电维修' ? 'selected' : ''}>水电维修</option>
                        <option value="家电维修" ${mmm.baoxiuleixing == '家电维修' ? 'selected' : ''}>家电维修</option>
                        <option value="房屋维修" ${mmm.baoxiuleixing == '房屋维修' ? 'selected' : ''}>房屋维修</option>
                        <option value="其他" ${mmm.baoxiuleixing == '其他' ? 'selected' : ''}>其他</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>报修内容</label>
                    <textarea class="form-control" name="baoxiuneirong" id="baoxiuneirong" rows="3" placeholder="请输入报修内容">${mmm.baoxiuneirong}</textarea>
                </div>

                <div class="form-group">
                    <label>备注</label>
                    <textarea class="form-control" name="beizhu" id="beizhu" rows="3" placeholder="请输入备注信息">${mmm.beizhu}</textarea>
                </div>

                <button type="submit" class="btn btn-primary">保存修改</button>
                <a href="baoxiu_list_kehu.do" class="btn btn-default">返回列表</a>
            </form>
        </div>
    </div>
</div>
<%@ include file="foot.jsp" %>

<script>
    $("#form").validate({
        rules: {
            kehuxingming: {required: true},
            lianxifangshi: {required: true},
            baoxiuneirong: {required: true}
        },
        messages: {
            kehuxingming: "请输入客户姓名",
            lianxifangshi: "请输入联系方式",
            baoxiuneirong: "请输入报修内容"
        }
    });
</script>