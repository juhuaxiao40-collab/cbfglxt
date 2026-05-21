package com.spring.controller;

import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;
import com.spring.adapter.UserDataAdapter;
import com.spring.factory.ServiceFactoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.util.QueryUtil.*;

import java.util.*;


/**
 * 用户模块控制器
 */
@Controller
public class YonghuController extends BaseController {
    @Autowired
    private YonghuMapper dao;
    @Autowired
    private YonghuService service;

    @Autowired
    private ServiceFactoryInterface serviceFactory;

    @Autowired
    private UserDataAdapter userDataAdapter;
    /**
     * 后台列表页
     */
    @RequestMapping("/yonghu_list")
    public String list() {
        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        String order = Request.get("order", "id"); // 获取浏览器上地址栏提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); //获取浏览器上地址栏提交的URL参数 sort  如果没有则设置为desc

        SelectExample example = new SelectExample(); //  创建搜索类对象
        String where = " 1=1 ";   // 定义默认SQL语句条件字符串
        where += getWhere();      // 通过getWhere方法中得到url参数提交的全部参数转为条件字符串，返回的是sql条件语句
        example.setWhere(where);   // 将条件写进上面定义好的example条件类中
        example.setOrder(order + " " + sort); // 设置排序方式
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));  // 获取提交的URL 当前页码 参数 page  如果没有则设置为1
        page = Math.max(1, page);  // 取两个数的最大值，预防页码没有提交page 小于1，至少从第一页开始
        List<Yonghu> list = service.selectPage(example, page, 12);   // 当前页的记录，设置每页默认12条记录
        setAttribute("list", list); // 将列表写给界面使用
        setAttribute("orderby", order);  // 把当前排序结果共享数据给前台
        setAttribute("sort", sort);      // 把当前排序结果共享数据给前台
        setAttribute("where", where);    // 把当前条件共享数据给前台
        return "yonghu_list";   // 使用视图文件：WebRoot\yonghu_list.jsp
    }

    /**
     * 获取前台搜索框提交的参数拼接where条件语句
     */
    public String getWhere() {
        String where = " ";
        if (!Request.get("cx").equals("")) {
            where += " AND cx ='" + Request.get("cx") + "'";
        }
        if (!Request.get("yonghuming").equals("")) {
            where += " AND yonghuming LIKE '%" + Request.get("yonghuming") + "%'";
        }
        if (!Request.get("xingming").equals("")) {
            where += " AND xingming LIKE '%" + Request.get("xingming") + "%'";
        }
        if (!Request.get("xingbie").equals("")) {
            where += " AND xingbie ='" + Request.get("xingbie") + "'";
        }
        return where;
    }

    /**
     * 后台添加页面入口
     */
    @RequestMapping("/yonghu_add")
    public String add() {        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        return "yonghu_add";
    }

    /**
     * 后台添加页面入口
     */
    @RequestMapping("/yonghu_updt")
    public String updt() {
        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Yonghu mmm = service.find(id);
        setAttribute("mmm", mmm);
        setAttribute("updtself", 0);
        return "yonghu_updt";
    }

    /**
     * 个人资料修改页面入口
     */
    @RequestMapping("/yonghu_updtself")
    public String updtself() {
        // 更新个人资料
        int id = (int) request.getSession().getAttribute("id");
        Yonghu mmm = service.find(id);
        setAttribute("mmm", mmm);
        setAttribute("updtself", 1);
        return "yonghu_updtself";
    }

    /**
     * 插入数据入口
     *
     * @return
     */
    @RequestMapping("/yonghuinsert")
    public String insert() {
        String tmp = "";


        Yonghu post = new Yonghu();  // 创建实体类对象
        // 将前台提交过来的数据依次set到实体类

        post.setCx(Request.get("cx"));
        post.setYonghuming(Request.get("yonghuming"));
        post.setMima(Request.get("mima"));
        post.setXingming(Request.get("xingming"));
        post.setXingbie(Request.get("xingbie"));
        post.setShoujihao(Request.get("shoujihao"));
        post.setYouxiang(Request.get("youxiang"));
        post.setTouxiang(Request.get("touxiang"));
        service.insert(post); // 交给服务层插入数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 修改数据入口
     */
    @RequestMapping("/yonghuupdate")
    public String update() {
        Yonghu post = new Yonghu();  // 新建实体类
        // 将前台提交过来的数据依次set到实体类
        if (!Request.get("id").equals("")) post.setId(Request.getInt("id"));
        if (!Request.get("cx").equals("")) post.setCx(Request.get("cx"));
        if (!Request.get("yonghuming").equals("")) post.setYonghuming(Request.get("yonghuming"));
        if (!Request.get("mima").equals("")) post.setMima(Request.get("mima"));
        if (!Request.get("xingming").equals("")) post.setXingming(Request.get("xingming"));
        if (!Request.get("xingbie").equals("")) post.setXingbie(Request.get("xingbie"));
        if (!Request.get("shoujihao").equals("")) post.setShoujihao(Request.get("shoujihao"));
        if (!Request.get("youxiang").equals("")) post.setYouxiang(Request.get("youxiang"));
        if (!Request.get("touxiang").equals("")) post.setTouxiang(Request.get("touxiang"));
        service.update(post); // 将数据交给服务层执行更新数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     * 后台详情页
     */
    @RequestMapping("/yonghu_detail")
    public String detail() {
        int id = Request.getInt("id");
        Yonghu map = service.find(id);  // url 参数中的id获取行数据
        setAttribute("map", map);  // 把数据共享给前台
        return "yonghu_detail";  // 详情页面：WebRoot\yonghu_detail.jsp
    }

    /**
     * 删除
     */
    @RequestMapping("/yonghudelete")
    public String delete() {
        // 前台的判断登录状态，如果未登录则跳转到首页
        if (!checkLogin()) {
            return showError("请登录！", "./");
        }
        int id = Request.getInt("id");  //获取要删除的id通过get url参数
        Yonghu map = service.find(id);
        service.delete(id);// 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }

}
