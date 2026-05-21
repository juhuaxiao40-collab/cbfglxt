<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<div style="padding: 10px" class="admin-content">

    <div >
        <div class="card">
            <div class="card-header">修改密码:</div>
            <div class="card-body">
       <script src="js/jquery.validate.js"></script>

            <form action="editPassword.do" method="post" name="form1" id="form1" style="width: 420px;margin:0 auto"><!-- form 标签开始 -->

                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-xs-12 col-md-3">原密码<span
                                style="color: red;">*</span></label>
                        <div class="col-xs-12 col-md-9">

                            <input type="text" style="width: 200px" class="form-control" autocomplete="off" placeholder="请输入原密码" name="oldPassword"/>

                        </div>

                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-xs-12 col-md-3">新密码<span
                                style="color: red;">*</span></label>
                        <div class="col-xs-12 col-md-9">

                            <input type="text" style="width: 200px" class="form-control" autocomplete="off" placeholder="请输入新密码" name="newPwd" id="newPwd"/>

                        </div>

                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <label style="text-align: right" class="col-xs-12 col-md-3">确认密码<span
                                style="color: red;">*</span></label>
                        <div class="col-xs-12 col-md-9">

                            <input type="text" style="width: 200px" class="form-control" autocomplete="off" placeholder="请输入确认密码" name="newPwd2" id="newPwd2" equalTo="#newPwd" data-msg-equalTo="两次密码不一致"/>

                        </div>

                    </div>
                </div>
                <div class="form-group" style="text-align: center">


                    <button type="submit" class="btn btn-primary" name="Submit">
                        提交
                    </button>
                    <button type="reset" class="btn btn-default" name="Submit2">
                        重置
                    </button>

                </div>

                <!--form标签结束--></form>
     



            </div>
        </div>

        <!-- container定宽，并剧中结束 --></div>



</div>


<%@ include file="foot.jsp" %>