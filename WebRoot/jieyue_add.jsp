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
            <div class="card-header">解约添加:</div>
            <div class="card-body">
       <form action="jieyueinsert.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->

 <input type="hidden" id="zulinid" name="zulinid" value="${param.id !=null ? param.id :''}" />
                    <div class="form-group" >
                          <label>租赁编号</label>
                           ${readMap.zulinbianhao}
 <input type="hidden" id="zulinbianhao" name="zulinbianhao" value="${Info.html(readMap.zulinbianhao)}" />
                        
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
                          <label>房源编号</label>
                           ${readMap.fangyuanbianhao}
 <input type="hidden" id="fangyuanbianhao" name="fangyuanbianhao" value="${Info.html(readMap.fangyuanbianhao)}" />
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>原因</label>
                           <textarea id="yuanyin" name="yuanyin" style="max-width: 750px;width:100%; height: 300px;"></textarea>
<script>(function () {var um = UM.getEditor('yuanyin');})();</script>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>解约人</label>
                                                   <input type="text" class="form-control" placeholder="输入解约人" style="width:200px;"    readonly="readonly"  id="jieyueren" name="jieyueren" value="${sessionScope.username !=null ? sessionScope.username :''}"/>
                        
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