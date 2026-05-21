<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%@ include file="head.jsp" %>
    <div style="padding: 10px" class="admin-content">
         <div class="card panel-default">
                   <div class="card-header">房源信息 详情:</div>
                   <div class="card-body">
                       <div class="admin-detail clearfix">
                <div class="detail detail-text">
                    <div class="detail-title">id：</div>
                    <div class="detail-content">${map.id}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">房源编号：</div>
                    <div class="detail-content">${map.fangyuanbianhao}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">房源名称：</div>
                    <div class="detail-content">${map.fangyuanmingchen}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">房源类型：</div>
                    <div class="detail-content">${map.fangyuanleixing}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">房源状态：</div>
                    <div class="detail-content">${map.fangyuanzhuangtai}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">楼层：</div>
                    <div class="detail-content">${map.louceng}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">房型：</div>
                    <div class="detail-content">${map.fangxing}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">面积：</div>
                    <div class="detail-content">${map.mianji}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">基础租金：</div>
                    <div class="detail-content">${map.jichuzujin}
</div>
                </div>
                <div class="detail detail-editor">
                    <div class="detail-title">配套设施：</div>
                    <div class="detail-content">${map.peitaosheshi}
</div>
                </div>
                <div class="detail detail-editor">
                    <div class="detail-title">房源介绍：</div>
                    <div class="detail-content">${map.fangyuanjieshao}
</div>
                </div>
                       </div>

                       <div class="button-list">
                           <div class="">
                               <button onclick="history.go(-1);" class="btn btn-success">返回</button>
                               <button onclick="window.print()" class="btn btn-warning">打印本页</button>
                           </div>
                         </div>
                   </div>
         </div>
    </div>
<%@ include file="foot.jsp" %>