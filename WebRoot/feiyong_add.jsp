<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<script src="js/datepicker/WdatePicker.js"></script>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">

    <div >
        <div class="card">
            <div class="card-header">费用添加:</div>
            <div class="card-body">
       <form action="feiyonginsert.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->

 <input type="hidden" id="zulinid" name="zulinid" value="${param.id !=null ? param.id :''}" />
                    <div class="form-group" >
                          <label>房源类型</label>
                           ${readMap.fangyuanleixing} <input type="hidden" id="fangyuanleixing" name="fangyuanleixing" value="${Info.html(readMap.fangyuanleixing)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>费用编号</label>
                                                   <input type="text" class="form-control" placeholder="输入费用编号" style="width:300px;"    readonly="readonly"  id="feiyongbianhao" name="feiyongbianhao" value="${Info.getID()}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>客户姓名</label>
                           ${readMap.kehuxingming}
 <input type="hidden" id="kehuxingming" name="kehuxingming" value="${Info.html(readMap.kehuxingming)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>客户</label>
                           ${readMap.kehu}
 <input type="hidden" id="kehu" name="kehu" value="${Info.html(readMap.kehu)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
 <input type="hidden" id="iszf" name="iszf" value="否" />
                    <div class="form-group" >
                          <label>费用类型<span style="color: red;">*</span></label>
                           <select class="form-control" name="feiyongleixing" id="feiyongleixing" data-value=""  data-rule-required="true" data-msg-required="请选择费用类型" style="width:250px;" >
<option value>请选择费用类型</option>
<option value="押金">押金</option>
<option value="租金">租金</option>
<option value="水电费">水电费</option>
<option value="服务费">服务费</option>
</select>

                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>费用金额<span style="color: red;">*</span></label>
                                                   <input type="number" class="form-control" placeholder="输入费用金额" style="width:180px;"    step="0.01" data-rule-required="true" data-msg-required="请填写费用金额" number="true" data-msg-number="输入一个有效数字"  id="feiyongjine" name="feiyongjine" value="0"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>起始日期</label>
                                                   <input type="text" class="form-control" placeholder="输入起始日期" style="width:240px;"    onfocus="WdatePicker({dareFmt:'yyyy-MM-dd',lang:'zh-cn'})"  id="qishiriqi" name="qishiriqi" value="${Info.date("yyyy-MM-dd")}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>截止日期</label>
                                                   <input type="text" class="form-control" placeholder="输入截止日期" style="width:240px;"    onfocus="WdatePicker({dareFmt:'yyyy-MM-dd',lang:'zh-cn'})"  id="jiezhiriqi" name="jiezhiriqi" value="${Info.date("yyyy-MM-dd")}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>备注</label>
                           <textarea style="width:90%;height:150px;max-width:90%;min-height:120px" class="form-control" palaceholder="输入备注"  id="beizhu"   name="beizhu"   ></textarea>
                        
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