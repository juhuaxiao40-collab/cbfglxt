<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%@ include file="head.jsp" %>
    <div style="padding: 10px" class="admin-content">
         <div class="card panel-default">
                   <div class="card-header">用户 详情:</div>
                   <div class="card-body">
                       <div class="admin-detail clearfix">
                <div class="detail detail-text">
                    <div class="detail-title">id：</div>
                    <div class="detail-content">${map.id}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">权限：</div>
                    <div class="detail-content">${map.cx}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">用户名：</div>
                    <div class="detail-content">${map.yonghuming}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">密码：</div>
                    <div class="detail-content">${map.mima}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">姓名：</div>
                    <div class="detail-content">${map.xingming}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">性别：</div>
                    <div class="detail-content">${map.xingbie}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">手机号：</div>
                    <div class="detail-content">${map.shoujihao}
</div>
                </div>

                           <div class="detail detail-text">
                               <div class="detail-title">邮箱：</div>
                               <div class="detail-content">${map.youxiang}
                               </div>
                           </div>
                <div class="detail detail-images">
                    <div class="detail-title">头像：</div>
                    <div class="detail-content"> <c:choose><c:when test="${'' == map.touxiang }">-</c:when><c:otherwise><img width="100" src="${map.touxiang}"/></c:otherwise></c:choose></div>
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