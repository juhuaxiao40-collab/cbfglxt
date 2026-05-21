<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="head.jsp" %>
<script src="js/jquery.validate.js"></script>


<div style="padding: 10px" class="admin-content">

    <div >
        <div class="card">
            <div class="card-header">编辑 租赁:</div>
            <div class="card-body">
       <form action="zulinupdate.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->

 <input type="hidden" id="id" name="id" value="${mmm.id}" />
 <input type="hidden" id="fangyuanxinxiid" name="fangyuanxinxiid" value="${mmm.fangyuanxinxiid}" />
                    <div class="form-group" >
                          <label>房源编号</label>
                           ${mmm.fangyuanbianhao}
 <input type="hidden" id="fangyuanbianhao" name="fangyuanbianhao" value="${Info.html(mmm.fangyuanbianhao)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>房源类型</label>
                           ${mmm.fangyuanleixing} <input type="hidden" id="fangyuanleixing" name="fangyuanleixing" value="${Info.html(mmm.fangyuanleixing)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>基础租金</label>
                           ${mmm.jichuzujin}
 <input type="hidden" id="jichuzujin" name="jichuzujin" value="${Info.html(mmm.jichuzujin)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>租赁编号</label>
                                                   <input type="text" class="form-control" placeholder="输入租赁编号" style="width:300px;"    data-rule-required="true" data-msg-required="请填写租赁编号" readonly="readonly"  id="zulinbianhao" name="zulinbianhao" value="${Info.html(mmm.zulinbianhao)}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>客户姓名<span style="color: red;">*</span></label>
                                                   <input type="text" class="form-control" placeholder="输入客户姓名" style="width:300px;"    data-rule-required="true" data-msg-required="请填写客户姓名"  id="kehuxingming" name="kehuxingming" value="${Info.html(mmm.kehuxingming)}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>联系方式<span style="color: red;">*</span></label>
                                                   <input type="text" class="form-control" placeholder="输入联系方式" style="width:300px;"    data-rule-required="true" data-msg-required="请填写联系方式" phone="true" data-msg-phone="请输入正确手机号码"  id="lianxifangshi" name="lianxifangshi" value="${Info.html(mmm.lianxifangshi)}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>客户</label>
                                                   <input type="text" class="form-control" placeholder="输入客户" style="width:200px;"    readonly="readonly"  id="kehu" name="kehu" value="${Info.html(mmm.kehu)}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>备注</label>
                           <textarea style="width:90%;height:150px;max-width:90%;min-height:120px" class="form-control" palaceholder="输入备注"  id="beizhu"   name="beizhu"   >${Info.html(mmm.beizhu)}</textarea>
                        
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