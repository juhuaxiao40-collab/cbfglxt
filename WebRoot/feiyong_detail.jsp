<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><%@ include file="head.jsp" %>
    <div style="padding: 10px" class="admin-content">
         <div class="card panel-default">
                   <div class="card-header">费用 详情:</div>
                   <div class="card-body">
                       <div class="admin-detail clearfix">
                <div class="detail detail-text">
                    <div class="detail-title">id：</div>
                    <div class="detail-content">${map.id}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">房源类型：</div>
                    <div class="detail-content">${map.fangyuanleixing}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">费用编号：</div>
                    <div class="detail-content">${map.feiyongbianhao}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">客户姓名：</div>
                    <div class="detail-content">${map.kehuxingming}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">客户：</div>
                    <div class="detail-content">${map.kehu}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">支付状态：</div>
                    <div class="detail-content">${map.iszf}
<c:choose><c:when test="${'否' == map.iszf }">
<a href="zhifu/index.jsp?id=${map.id}&biao=feiyong&ordersn=${map.feiyongbianhao}&zongji=${map.feiyongjine}">去支付</a>
</c:when></c:choose>
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">费用类型：</div>
                    <div class="detail-content">${map.feiyongleixing}</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">费用金额：</div>
                    <div class="detail-content">${map.feiyongjine}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">起始日期：</div>
                    <div class="detail-content">${map.qishiriqi}
</div>
                </div>
                <div class="detail detail-text">
                    <div class="detail-title">截止日期：</div>
                    <div class="detail-content">${map.jiezhiriqi}
</div>
                </div>
                <div class="detail detail-editor">
                    <div class="detail-title">备注：</div>
                    <div class="detail-content">${map.beizhu}
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