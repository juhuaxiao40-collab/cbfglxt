<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<link rel="stylesheet" href="js/umeditor/themes/default/css/umeditor.css"/>
<script src="js/umeditor/umeditor.config.js"></script>
<script src="js/umeditor/umeditor.min.js"></script>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">

    <div >
        <div class="card">
            <div class="card-header">编辑 服务:</div>
            <div class="card-body">
       <form action="fuwuupdate.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->

 <input type="hidden" id="id" name="id" value="${mmm.id}" />
 <input type="hidden" id="zulinid" name="zulinid" value="${mmm.zulinid}" />
                    <div class="form-group" >
                          <label>服务编号</label>
                                                   <input type="text" class="form-control" placeholder="输入服务编号" style="width:300px;"    data-rule-required="true" data-msg-required="请填写服务编号" readonly="readonly"  id="fuwubianhao" name="fuwubianhao" value="${Info.html(mmm.fuwubianhao)}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>客户姓名</label>
                           ${mmm.kehuxingming}
 <input type="hidden" id="kehuxingming" name="kehuxingming" value="${Info.html(mmm.kehuxingming)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>联系方式</label>
                           ${mmm.lianxifangshi}
 <input type="hidden" id="lianxifangshi" name="lianxifangshi" value="${Info.html(mmm.lianxifangshi)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>服务类型<span style="color: red;">*</span></label>
                           <select class="form-control class_fuwuleixing" name="fuwuleixing" id="fuwuleixing" data-value="${Info.html(mmm.fuwuleixing)}"  data-rule-required="true" data-msg-required="请选择服务类型" style="width:250px;" >
<option value>请选择服务类型</option>
<option value="保洁服务">保洁服务</option>
<option value="维修报修">维修报修</option>
<option value=""></option>
</select>
<script>$(".class_fuwuleixing").val($(".class_fuwuleixing").attr("data-value"))</script>

                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>服务内容<span style="color: red;">*</span></label>
                           <textarea id="fuwuneirong" name="fuwuneirong" style="max-width: 750px;width:100%; height: 300px;">${Info.html(mmm.fuwuneirong)}</textarea>
<script>(function () {var um = UM.getEditor('fuwuneirong');})();</script>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>服务留言</label>
                           <textarea id="fuwuliuyan" name="fuwuliuyan" style="max-width: 750px;width:100%; height: 300px;">${Info.html(mmm.fuwuliuyan)}</textarea>
<script>(function () {var um = UM.getEditor('fuwuliuyan');})();</script>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>添加人</label>
                                                   <input type="text" class="form-control" placeholder="输入添加人" style="width:200px;"    readonly="readonly"  id="tianjiaren" name="tianjiaren" value="${Info.html(mmm.tianjiaren)}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>

 <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("referer")%>" />
 <input type="hidden" id="updtself" name="updtself" value="${updtself}" />
                    <div class="form-group" >
                          <label></label>
                           <button type="submit" class="btn btn-primary" name="Submit">确认修改</button>
<button type="reset" class="btn btn-default" name="Submit2">重置</button>

                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
</form>
<script>$(function () {$('#form1').validate();});</script>


            </div>
        </div>

        <!-- container定宽，并剧中结束 --></div>



</div>


<%@ include file="foot.jsp" %>