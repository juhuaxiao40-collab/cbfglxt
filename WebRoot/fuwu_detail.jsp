<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%@ include file="head.jsp" %>
    <div style="padding: 10px" class="admin-content">
         <div class="card panel-default">
                   <div class="card-header">服务 详情:</div>
                   <div class="card-body">
                       <div class="admin-detail clearfix">
                <div class="detail detail-text">
                    <div class="detail-title">id：</div>
                    <div class="detail-content">${map.id}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">服务编号：</div>
                    <div class="detail-content">${map.fuwubianhao}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">客户姓名：</div>
                    <div class="detail-content">${map.kehuxingming}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">联系方式：</div>
                    <div class="detail-content">${map.lianxifangshi}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">服务类型：</div>
                    <div class="detail-content">${map.fuwuleixing}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">服务状态：</div>
                    <div class="detail-content">${map.fuwuzhuangtai}</div>
                </div>
                <div class="detail detail-editor">
                    <div class="detail-title">服务内容：</div>
                    <div class="detail-content">${map.fuwuneirong}
</div>
                </div>
                <div class="detail detail-editor">
                    <div class="detail-title">服务留言：</div>
                    <div class="detail-content">${map.fuwuliuyan}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">添加人：</div>
                    <div class="detail-content">${map.tianjiaren}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">添加时间：</div>
                    <div class="detail-content">${Info.subStr(map.tianjiashijian,19,'')}
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