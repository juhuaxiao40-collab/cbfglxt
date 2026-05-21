<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<link rel="stylesheet" href="js/layer/theme/default/layer.css"/>
<script src="js/layer/layer.js"></script>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">

    <div>
        <div class="card">
            <div class="card-header">用户添加:</div>
            <div class="card-body">
                <form action="yonghuinsert.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->

                    <div class="form-group">
                        <label>权限<span style="color: red;">*</span></label>
                        <select class="form-control class_cx" name="cx" id="cx" data-value="用户"
                                data-rule-required="true" data-msg-required="请选择权限" style="width:250px;">
                            <option value>请选择权限</option>
                            <option value="用户">用户</option>
                            <option value="管理员">管理员</option>
                        </select>
                        <script>$(".class_cx").val($(".class_cx").attr("data-value"))</script>


                        <small class="form-text text-muted"></small>

                    </div>
                    <div class="form-group">
                        <label>用户名<span style="color: red;">*</span></label>
                        <input type="text" class="form-control" placeholder="输入用户名" style="width:300px;"
                               data-rule-required="true" data-msg-required="请填写用户名"
                               remote="checkno.do?checktype=insert&table=yonghu&col=yonghuming"
                               data-msg-remote="内容重复了" id="yonghuming" name="yonghuming" value=""/>

                        <small class="form-text text-muted"></small>

                    </div>
                    <div class="form-group">
                        <label>密码<span style="color: red;">*</span></label>
                        <input type="password" class="form-control" placeholder="输入密码" style="width:180px;"
                               data-rule-required="true" data-msg-required="请填写密码" id="mima" name="mima" value=""/>

                        <small class="form-text text-muted"></small>

                    </div>
                    <div class="form-group">
                        <label>姓名<span style="color: red;">*</span></label>
                        <input type="text" class="form-control" placeholder="输入姓名" style="width:300px;"
                               data-rule-required="true" data-msg-required="请填写姓名" id="xingming" name="xingming"
                               value=""/>

                        <small class="form-text text-muted"></small>

                    </div>
                    <div class="form-group">
                        <label>性别<span style="color: red;">*</span></label>
                        <select class="form-control class_xingbie" name="xingbie" id="xingbie" data-value="男"
                                data-rule-required="true" data-msg-required="请选择性别" style="width:250px;">
                            <option value>请选择性别</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                        <script>$(".class_xingbie").val($(".class_xingbie").attr("data-value"))</script>


                        <small class="form-text text-muted"></small>

                    </div>
                    <div class="form-group">
                        <label>手机号<span style="color: red;">*</span></label>
                        <input type="text" class="form-control" placeholder="输入手机号" style="width:300px;"
                               data-rule-required="true" data-msg-required="请填写手机号" phone="true"
                               data-msg-phone="请输入正确手机号码" id="shoujihao" name="shoujihao" value=""/>

                        <small class="form-text text-muted"></small>

                    </div>
                    <div class="form-group">
                        <label>邮箱<span style="color: red;">*</span></label>
                        <input type="text" class="form-control" placeholder="输入邮箱" style="width:300px;"
                               data-rule-required="true" data-msg-required="请填写邮箱" email="true"
                               data-msg-email="请输入正确邮箱" id="email" name="email" value=""/>

                        <small class="form-text text-muted"></small>

                    </div>


                    <div class="form-group">
                        <label>头像</label>
                        <div class="input-group" style="width:250px">
                            <input type="text" class="form-control" id="touxiang" name="touxiang" value=""/>
                            <span class="input-group-btn">
                                        <button type="button" class="btn btn-default"
                                                onclick="layer.open({type:2,title:'上传图片',fixed:true,shadeClose:true,shade:0.5,area:['320px','150px'],
                                                content:'upload.html?result=touxiang'})">上传图片
                                        </button>
                                    </span>
                        </div>

                        <small class="form-text text-muted"></small>

                    </div>

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