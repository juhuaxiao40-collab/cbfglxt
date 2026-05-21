<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>长包房管理系统后台管理系统</title>

	<link href="assets/fontAwesome/css/fontawesome-all.min.css" rel="stylesheet">
	<link href="assets/css/lib/themify-icons.css" rel="stylesheet">
	<link href="assets/css/lib/mmc-chat.css" rel="stylesheet"/>
	<link href="assets/css/lib/sidebar.css" rel="stylesheet">
	<link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
	<link href="assets/css/lib/nixon.css" rel="stylesheet">

	<link href="assets/css/style.css" rel="stylesheet">
<!-- /# content wrap -->
<script src="assets/js/lib/jquery.min.js"></script>
<!-- jquery vendor -->
<script src="assets/js/lib/jquery.nanoscroller.min.js"></script>
</head>
<body>

<style>
    body{
        overflow-y: hidden;

    }
</style>


<div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
    <div class="nano">
        <div class="nano-content">
			 
            <!-- 用户 -->
            
             <c:choose>
   <c:when test="${ '用户' == sessionScope.cx}"> 
                 <%@ include file="left_yonghu.jsp" %>
                </c:when> 
            </c:choose>
            
            <!-- 管理员 -->
            
             <c:choose>
   <c:when test="${ '管理员' == sessionScope.cx}"> 
                 <%@ include file="left_guanliyuan.jsp" %>
                </c:when> 
            </c:choose>
            
        </div>
    </div>
</div>
<!-- /# sidebar -->
<div class="header">
    <div class="pull-left">
         <div style="margin-top: 10px;padding-left:10px;float: left">
            <a href="#" style="font-size: 20px;color: #fff;">
               长包房管理系统
            </a>
        </div>
 <%--       <div class="hamburger sidebar-toggle">
            <span class="ti-menu"></span>
        </div>--%>



    </div>
    <div class="pull-right p-r-15">
        <ul>
           
           
            <li class="header-icon dib">


                  
                                 <c:choose>
   <c:when test="${ sessionScope.touxiang !='' && sessionScope.touxiang != null }"> 
                                    <img src="${sessionScope.touxiang=='' || sessionScope.touxiang==null ? '':sessionScope.touxiang }" class="avatar-img" alt="User Image">
                                 </c:when><c:otherwise> 
                                    <img class="avatar-img" src="assets/images/avatar/1.jpg" alt=""/>
                                    </c:otherwise> 
                            </c:choose>
                


                <span class="user-avatar">${sessionScope.username} <i class="ti-angle-down f-s-10"></i></span>

                <div class="drop-down dropdown-profile">
                    <div class="dropdown-content-heading">
                        <span class="text-left">权限</span>
                        <p class="trial-day">${sessionScope.cx}</p>
                    </div>
                    <div class="dropdown-content-body">
                        <ul>
                            <li><a href="./"><i class="ti-link"></i> <span>前台首页</span></a></li>
                            <li><a href="mod.do"><i class="ti-settings"></i> <span>修改密码</span></a></li>

                            <li><a href="logout.do" onclick="return confirm('确定退出系统？')"><i class="ti-power-off"></i> <span>退出登录</span></a></li>
                        </ul>
                    </div>
                </div>
            </li>
        </ul>
    </div>
</div>

<!-- END chat Sidebar-->
<div class="content-wrap">
    <div class="main">
            <div class="main-content">

                <iframe name="ymain" class="cke_wysiwyg_frame" src="sy.do" width="100%" height="100%" FrameBorder="0" id="ymain"></iframe>
				
            </div>
        
    </div>
</div>

<!-- nano scroller -->
<script src="assets/js/lib/sidebar.js"></script>
<!-- sidebar -->
<script src="assets/js/lib/bootstrap.min.js"></script>
<!-- bootstrap -->
<script src="assets/js/lib/mmc-common.js"></script>

<script src="assets/js/jianting.js"></script>

<!-- Datamap -->

<!-- // Datamap -->
<script src="assets/js/scripts.js"></script>
<!-- scripit init-->

</body>
</html>