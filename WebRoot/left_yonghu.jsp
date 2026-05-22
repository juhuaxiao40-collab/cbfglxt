<%@ page language="java" import="com.spring.util.*,java.util.*,com.spring.util.QueryUtil.*" pageEncoding="UTF-8" %>
 <%@ taglib prefix="ssm" uri="http://ssm" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

            <ul>
                <li><a href="sy.do" target="ymain"><i class="ti-layout-grid2-alt"></i> 后台首页</a></li>
                
                <li>
                    <a class="sidebar-sub-toggle"><i class="ti-layout"></i> 个人中心 <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                    <ul>
						
                        <li><a target="ymain" href="yonghu_updtself.do">修改个人资料</a></li>
						
                        <li><a target="ymain" href="mod.do">修改密码</a></li>
						 
                    </ul>
                </li>
				
                <li>
                    <a class="sidebar-sub-toggle"><i class="ti-layout"></i> 租赁管理 <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                    <ul>
						
                        <li><a target="ymain" href="zulin_list_kehu.do">租赁查询</a></li>
						 
                    </ul>
                </li>
				
                <li>
                    <a class="sidebar-sub-toggle"><i class="ti-layout"></i> 费用管理 <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                    <ul>
						
                        <li><a target="ymain" href="feiyong_list_kehu.do">费用查询</a></li>
						 
                    </ul>
                </li>
				
                <li>
                    <a class="sidebar-sub-toggle"><i class="ti-layout"></i> 看房申请 <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                    <ul>
						
                        <li><a target="ymain" href="fangyuanxinxi_list_kehu.do">房源列表</a></li>
						 
                        <li><a target="ymain" href="kanfang_list_kehu.do">我的看房申请</a></li>
						 
                    </ul>
                </li>
				
                <li>
                    <a class="sidebar-sub-toggle"><i class="ti-layout"></i> 报修管理 <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                    <ul>
						
                        <li><a target="ymain" href="baoxiu_list_kehu.do">我的报修</a></li>
						 
                    </ul>
                </li>
				
                <li><a href="logout.do" onclick="return confirm('确定退出系统？')"><i class="ti-close"></i> 退出登录</a></li>
            </ul>