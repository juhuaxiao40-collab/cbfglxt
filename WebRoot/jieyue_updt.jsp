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
            <div class="card-header">编辑 解约:</div>
            <div class="card-body">
       <form action="jieyueupdate.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->

 <input type="hidden" id="id" name="id" value="${mmm.id}" />
 <input type="hidden" id="zulinid" name="zulinid" value="${mmm.zulinid}" />
                    <div class="form-group" >
                          <label>租赁编号</label>
                           ${mmm.zulinbianhao}
 <input type="hidden" id="zulinbianhao" name="zulinbianhao" value="${Info.html(mmm.zulinbianhao)}" />
                        
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
                          <label>房源编号</label>
                           ${mmm.fangyuanbianhao}
 <input type="hidden" id="fangyuanbianhao" name="fangyuanbianhao" value="${Info.html(mmm.fangyuanbianhao)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>原因</label>
                           <textarea id="yuanyin" name="yuanyin" style="max-width: 750px;width:100%; height: 300px;">${Info.html(mmm.yuanyin)}</textarea>
<script>(function () {var um = UM.getEditor('yuanyin');})();</script>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>解约人</label>
                                                   <input type="text" class="form-control" placeholder="输入解约人" style="width:200px;"    readonly="readonly"  id="jieyueren" name="jieyueren" value="${Info.html(mmm.jieyueren)}"/>
                        
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