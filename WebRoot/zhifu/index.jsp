<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/12/30
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ssm" uri="http://ssm" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网上支付 安全快速！</title>
    <style>
        body {
            background: #fff6f0;
            margin: 0 0;
        }

        .header {
            height: 80px;
            width: 100%;
            background: #fff;
        }

        .container {
            width: 800px;
            height: 100%;
            margin: 0 auto;

        }

        .leftbox {
            font-size: 20px;
            height: 100%;
            width: 50%;
            line-height: 80px;

        }

        .rightbox {
            font-size: 12px;
            height: 100%;
            width: 50%;
            line-height: 80px;
            text-align: right;
        }

        .zhuti {
            background: #fff;
            height: 400px;
            margin: 0 auto;
            margin-top: 35px;
            font-size: 12px;

        }

        .zhifubox {
            border-top-style: solid;
            border-top-width: 1px;
            border-top-color: #ececec;
            padding-top: 15px;

        }

        .fax {
            display: flex;
        }

        .neirong {
            margin: 50px;
            padding-top: 45px;
        }

        .row {
            margin-bottom: 15px;
        }
        .zfleixing{
            padding: 15px;
            border: 1px solid #ececec;
            margin-right: 5px;

        }
        .butzhif{
            width: 150px;
            height: 45px;
            margin: 0 auto;
            background: #0e9aef;
            color: #fff;
            font-size: 15px;
            text-align: center;
            line-height: 45px;
        }
    </style>
</head>
<body>

<div class="header">
    <div class="container fax">
        <div class="leftbox">订单模拟支付</div>
        <div class="rightbox">
            账号：${sessionScope.username}
        </div>
    </div>
</div>
<div class="container zhuti ">
    <div class="neirong">

        <div class="row"><span>订单编号：</span><span><%=request.getParameter("ordersn")%></span></div>
        <div class="row"><span>支付金额：</span><span><%=request.getParameter("zongji")%></span></div>
        <div class="zhifubox fax row">


            <div class="zfleixing"><input type="radio" name="pay_bank" value="zhifubao" checked>支付宝</div>
            <div class="zfleixing"><input type="radio" name="pay_bank" value="weixin">微信</div>
            <div class="zfleixing"><input type="radio" name="pay_bank" value="yunshanfu">云闪付</div>
            <div class="zfleixing"><input type="radio" name="pay_bank" value="jianshe">中国建设</div>
            <div class="zfleixing"><input type="radio" name="pay_bank" value="nongye">中国农业</div>


        </div>
        <div class="anniu ">
            <div  class="butzhif"  onClick="javascript:location.href='../zhifu.jsp?id=<%=request.getParameter("id")%>&biao=<%=request.getParameter("biao")%>&referer='+encodeURIComponent(document.referrer);">立即支付</div>
        </div>

    </div>
</div>

</body>
</html>
