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
            <div class="card-header">服务添加:</div>
            <div class="card-body">
       <form action="fuwuinsert.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->

 <input type="hidden" id="zulinid" name="zulinid" value="${param.id !=null ? param.id :''}" />
                    <div class="form-group" >
                          <label>服务编号</label>
                                                   <input type="text" class="form-control" placeholder="输入服务编号" style="width:300px;"    readonly="readonly"  id="fuwubianhao" name="fuwubianhao" value="${Info.getID()}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>客户姓名</label>
                           ${readMap.kehuxingming}
 <input type="hidden" id="kehuxingming" name="kehuxingming" value="${Info.html(readMap.kehuxingming)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>联系方式</label>
                           ${readMap.lianxifangshi}
 <input type="hidden" id="lianxifangshi" name="lianxifangshi" value="${Info.html(readMap.lianxifangshi)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>服务类型<span style="color: red;">*</span></label>
                           <select class="form-control" name="fuwuleixing" id="fuwuleixing" data-value=""  data-rule-required="true" data-msg-required="请选择服务类型" style="width:250px;" >
<option value>请选择服务类型</option>
<option value="保洁服务">保洁服务</option>
<option value="维修报修">维修报修</option>
<option value=""></option>
</select>

                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
 <input type="hidden" id="fuwuzhuangtai" name="fuwuzhuangtai" value="处理中" />
                    <div class="form-group" >
                          <label>服务内容<span style="color: red;">*</span></label>
                           <textarea id="fuwuneirong" name="fuwuneirong" style="max-width: 750px;width:100%; height: 300px;"></textarea>
<script>(function () {var um = UM.getEditor('fuwuneirong');})();</script>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>添加人</label>
                                                   <input type="text" class="form-control" placeholder="输入添加人" style="width:200px;"    readonly="readonly"  id="tianjiaren" name="tianjiaren" value="${sessionScope.username !=null ? sessionScope.username :''}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>

 <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("referer")%>" />
                    <div class="form-group" >
                          <label></label>
                           <button type="submit" class="btn btn-primary" name="Submit">提交</button>
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