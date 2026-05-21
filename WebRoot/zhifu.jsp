<%@ page language="java" import="com.spring.util.QueryUtil.*" pageEncoding="utf-8" %>
 <%@page import="java.util.*" %>
 <%@page import="com.spring.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>My JSP 'adminyanzheng.jsp' starting page</title>
    </head>
    <body>
        <%
        String id, biao;
        boolean isShaxiang = false;
        if (request.getParameter("out_trade_no") != null) {
            String[] out_trade_no = request.getParameter("out_trade_no").split("\\-");
            id = out_trade_no[2];
            biao = out_trade_no[1];
            isShaxiang = true;
        } else {
            id = request.getParameter("id");
            biao = request.getParameter("biao");
        }
        Map order = Query.make(biao).find(id);
        
        String sql = "update " + biao + " set iszf='是' where id='" + id + "'";
       Query.execute(sql); if("zulin".equals(biao)) {
 Query.execute("update zulin set zhuangtai='已生效' where zulinbianhao='"+order.get("zulinbianhao")+"'");
 Query.execute("update fangyuanxinxi set fangyuanzhuangtai='已租' where fangyuanbianhao='"+order.get("fangyuanbianhao")+"'");
}        out.print("<script>alert('支付成功!!');opener.location.reload();window.close();</script>");
        %>

    </body>
</html>
