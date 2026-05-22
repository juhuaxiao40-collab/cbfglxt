package com.spring.controller;

import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.spring.strategy.AreaSortingStrategy;
import com.spring.factory.ServiceFactoryInterface;
import com.spring.util.QueryUtil.*;

import java.util.*;


/**
 * 房源信息模块控制器
 */
@Controller
public class FangyuanxinxiController extends BaseController {
    @Autowired
    private FangyuanxinxiMapper dao;
    @Autowired
    private FangyuanxinxiService service;

    // 在类中注入抽象工厂和排序策略
    @Autowired
    private ServiceFactoryInterface serviceFactory;


    @Autowired
    private AreaSortingStrategy areaSortingStrategy;
    /**
     * 后台列表页
     */
    @RequestMapping("/fangyuanxinxi_list")
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
        List<Fangyuanxinxi> list = service.selectPage(example, page, 12);   // 当前页的记录，设置每页默认12条记录
        setAttribute("list", list); // 将列表写给界面使用
        setAttribute("orderby", order);  // 把当前排序结果共享数据给前台
        setAttribute("sort", sort);      // 把当前排序结果共享数据给前台
        setAttribute("where", where);    // 把当前条件共享数据给前台
        return "fangyuanxinxi_list";   // 使用视图文件：WebRoot\fangyuanxinxi_list.jsp
    }

    // 添加按面积排序的方法
    @RequestMapping("/fangyuanxinxi_list_by_area")
    public String fangyuanxinxi_list_by_area() throws Exception {
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }

        SelectExample example = new SelectExample(); //  创建搜索类对象
        String where = " 1=1 ";
        where += getWhere();
        example.setWhere(where);

        // 使用抽象工厂获取服务
        List<Fangyuanxinxi> fangyuanxinxiList = serviceFactory.createFangyuanxinxiService().selectAll(example);
        // 使用面积排序策略
        setAttribute("list", areaSortingStrategy.sort(fangyuanxinxiList));

        return "fangyuanxinxi_list";
    }

    /**
     * 获取前台搜索框提交的参数拼接where条件语句
     */
    public String getWhere() {
        String where = " ";

        if (!Request.get("fangyuanleixing").equals("")) {
            where += " AND fangyuanleixing ='" + Request.get("fangyuanleixing") + "'";
        }

        if (!Request.get("fangyuanzhuangtai").equals("")) {
            where += " AND fangyuanzhuangtai ='" + Request.get("fangyuanzhuangtai") + "'";
        }

        return where;
    }

    /**
     * 后台添加页面入口
     */
    @RequestMapping("/fangyuanxinxi_add")
    public String add() {        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        return "fangyuanxinxi_add";
    }


    /**
     * 后台添加页面入口
     */
    @RequestMapping("/fangyuanxinxi_updt")
    public String updt() {
        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Fangyuanxinxi mmm = service.find(id);
        setAttribute("mmm", mmm);
        setAttribute("updtself", 0);
        return "fangyuanxinxi_updt";
    }


    /**
     * 插入数据入口
     *
     * @return
     */
    @RequestMapping("/fangyuanxinxiinsert")
    public String insert() {
        String tmp = "";
        Fangyuanxinxi post = new Fangyuanxinxi();  // 创建实体类对象
        // 将前台提交过来的数据依次set到实体类
        post.setFangyuanbianhao(Request.get("fangyuanbianhao"));
        post.setFangyuanmingchen(Request.get("fangyuanmingchen"));
        post.setFangyuanleixing(Request.get("fangyuanleixing"));
        post.setFangyuanzhuangtai(Request.get("fangyuanzhuangtai"));
        post.setLouceng(Request.get("louceng"));
        post.setFangxing(Request.get("fangxing"));
        post.setMianji(Request.get("mianji"));
        post.setJichuzujin(Request.get("jichuzujin"));
        post.setPeitaosheshi(Request.get("peitaosheshi"));
        post.setFangyuanjieshao(DownloadRemoteImage.run(Request.get("fangyuanjieshao")));
        service.insert(post); // 交给服务层插入数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }



    /**
     * 修改数据入口
     */
    @RequestMapping("/fangyuanxinxiupdate")
    public String update() {

        Fangyuanxinxi post = new Fangyuanxinxi();  // 新建实体类
        // 将前台提交过来的数据依次set到实体类
        if (!Request.get("id").equals("")) post.setId(Request.getInt("id"));
        if (!Request.get("fangyuanbianhao").equals("")) post.setFangyuanbianhao(Request.get("fangyuanbianhao"));
        if (!Request.get("fangyuanmingchen").equals("")) post.setFangyuanmingchen(Request.get("fangyuanmingchen"));
        if (!Request.get("fangyuanleixing").equals("")) post.setFangyuanleixing(Request.get("fangyuanleixing"));
        if (!Request.get("fangyuanzhuangtai").equals("")) post.setFangyuanzhuangtai(Request.get("fangyuanzhuangtai"));
        if (!Request.get("louceng").equals("")) post.setLouceng(Request.get("louceng"));
        if (!Request.get("fangxing").equals("")) post.setFangxing(Request.get("fangxing"));
        if (!Request.get("mianji").equals("")) post.setMianji(Request.get("mianji"));
        if (!Request.get("jichuzujin").equals("")) post.setJichuzujin(Request.get("jichuzujin"));
        if (!Request.get("peitaosheshi").equals("")) post.setPeitaosheshi(Request.get("peitaosheshi"));
        if (!Request.get("fangyuanjieshao").equals("")) post.setFangyuanjieshao(DownloadRemoteImage.run(Request.get("fangyuanjieshao")));


        service.update(post); // 将数据交给服务层执行更新数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     * 后台详情页
     */
    @RequestMapping("/fangyuanxinxi_detail")
    public String detail() {
        int id = Request.getInt("id");

        Fangyuanxinxi map = service.find(id);  // url 参数中的id获取行数据

        setAttribute("map", map);  // 把数据共享给前台
        return "fangyuanxinxi_detail";  // 详情页面：WebRoot\fangyuanxinxi_detail.jsp
    }

    /**
     * 删除
     */
    @RequestMapping("/fangyuanxinxidelete")
    public String delete() {
        // 前台的判断登录状态，如果未登录则跳转到首页
        if (!checkLogin()) {
            return showError("请登录！", "./");
        }

        int id = Request.getInt("id");  //获取要删除的id通过get url参数

        Fangyuanxinxi map = service.find(id);

        service.delete(id);// 根据id 删除某行数据

        return showSuccess("删除成功", request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }

    /**
     * 用户端房源列表页
     */
    @RequestMapping("/fangyuanxinxi_list_kehu")
    public String listKehu() {
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        String order = Request.get("order", "id");
        String sort = Request.get("sort", "desc");

        SelectExample example = new SelectExample();
        String where = " fangyuanzhuangtai = '空闲' ";
        where += getWhere();
        example.setWhere(where);
        example.setOrder(order + " " + sort);

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1, page);
        List<Fangyuanxinxi> list = service.selectPage(example, page, 12);
        setAttribute("list", list);
        setAttribute("orderby", order);
        setAttribute("sort", sort);
        setAttribute("where", where);
        return "fangyuanxinxi_list_kehu";
    }

}
