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
            <div class="card-header">房源信息添加:</div>
            <div class="card-body">
       <form action="fangyuanxinxiinsert.do" method="post" name="form1" id="form1"><!-- form 标签开始 -->

                    <div class="form-group" >
                          <label>房源编号</label>
                                                   <input type="text" class="form-control" placeholder="输入房源编号" style="width:300px;"    readonly="readonly"  id="fangyuanbianhao" name="fangyuanbianhao" value="${Info.getID()}"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>房源名称<span style="color: red;">*</span></label>
                                                   <input type="text" class="form-control" placeholder="输入房源名称" style="width:600px;"    data-rule-required="true" data-msg-required="请填写房源名称"  id="fangyuanmingchen" name="fangyuanmingchen" value=""/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>房源类型<span style="color: red;">*</span></label>
                           <select class="form-control" name="fangyuanleixing" id="fangyuanleixing" data-value=""  data-rule-required="true" data-msg-required="请选择房源类型" style="width:250px;" >
<option value>请选择房源类型</option>
<option value="长包房">长包房</option>
<option value="短期房">短期房</option>
</select>

                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
 <input type="hidden" id="fangyuanzhuangtai" name="fangyuanzhuangtai" value="空闲" />
                    <div class="form-group" >
                          <label>楼层<span style="color: red;">*</span></label>
                                                   <input type="text" class="form-control" placeholder="输入楼层" style="width:300px;"    data-rule-required="true" data-msg-required="请填写楼层"  id="louceng" name="louceng" value=""/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>房型<span style="color: red;">*</span></label>
                                                   <input type="text" class="form-control" placeholder="输入房型" style="width:600px;"    data-rule-required="true" data-msg-required="请填写房型"  id="fangxing" name="fangxing" value=""/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>面积</label>
                                                   <input type="text" class="form-control" placeholder="输入面积" style="width:300px;"     id="mianji" name="mianji" value=""/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>基础租金<span style="color: red;">*</span></label>
                                                   <input type="number" class="form-control" placeholder="输入基础租金" style="width:180px;"    step="0.01" data-rule-required="true" data-msg-required="请填写基础租金" number="true" data-msg-number="输入一个有效数字"  id="jichuzujin" name="jichuzujin" value="0"/>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>配套设施</label>
                           <textarea style="width:90%;height:150px;max-width:90%;min-height:120px" class="form-control" palaceholder="输入配套设施"  id="peitaosheshi"   name="peitaosheshi"   ></textarea>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>
                    <div class="form-group" >
                          <label>房源介绍<span style="color: red;">*</span></label>
                           <textarea id="fangyuanjieshao" name="fangyuanjieshao" style="max-width: 750px;width:100%; height: 300px;"></textarea>
<script>(function () {var um = UM.getEditor('fangyuanjieshao');})();</script>
                        
                          <small class="form-text text-muted"></small>
                                                
                    </div>

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