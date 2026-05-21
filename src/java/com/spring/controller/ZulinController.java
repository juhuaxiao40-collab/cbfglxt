package com.spring.controller;

import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.facade.BusinessFacade;
import com.spring.service.*;
import com.spring.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.util.QueryUtil.*;

import java.util.*;

import com.spring.entity.Fangyuanxinxi;
import com.spring.service.FangyuanxinxiService;

/**
 * 租赁模块控制器
 */
@Controller
public class ZulinController extends BaseController {
    @Autowired
    private ZulinMapper dao;
    @Autowired
    private ZulinService service;

    @Autowired
    private FangyuanxinxiService serviceRead;

    @Autowired
    private BusinessFacade businessFacade;

    @Autowired
    private YonghuService yonghuService;
    /**
     * 后台列表页
     */
    @RequestMapping("/zulin_list")
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
        List<Zulin> list = service.selectPage(example, page, 12);   // 当前页的记录，设置每页默认12条记录
        setAttribute("list", list); // 将列表写给界面使用
        setAttribute("orderby", order);  // 把当前排序结果共享数据给前台
        setAttribute("sort", sort);      // 把当前排序结果共享数据给前台
        setAttribute("where", where);    // 把当前条件共享数据给前台
        return "zulin_list";   // 使用视图文件：WebRoot\zulin_list.jsp
    }

    /**
     * 后台列表页
     */
    @RequestMapping("/zulin_list_kehu")
    public String listkehu() {
        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        String order = Request.get("order", "id"); // 获取浏览器上地址栏提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); //获取浏览器上地址栏提交的URL参数 sort  如果没有则设置为desc

        SelectExample example = new SelectExample(); //  创建搜索类对象
        // 定义默认条件SQL语句字符串，条件为：客户=当前登录用户
        String where = " kehu='" + session.getAttribute("username") + "' ";
        where += getWhere();      // 通过getWhere方法中得到url参数提交的全部参数转为条件字符串，返回的是sql条件语句
        example.setWhere(where);   // 将条件写进上面定义好的example条件类中
        example.setOrder(order + " " + sort); // 设置排序方式
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));  // 获取提交的URL 当前页码 参数 page  如果没有则设置为1
        page = Math.max(1, page);  // 取两个数的最大值，预防页码没有提交page 小于1，至少从第一页开始
        List<Zulin> list = service.selectPage(example, page, 12);   // 当前页的记录，设置每页默认12条记录
        setAttribute("list", list); // 将列表写给界面使用
        setAttribute("orderby", order);  // 把当前排序结果共享数据给前台
        setAttribute("sort", sort);      // 把当前排序结果共享数据给前台
        setAttribute("where", where);    // 把当前条件共享数据给前台
        return "zulin_list_kehu";   // 使用视图文件：WebRoot\zulin_list_kehu.jsp
    }

    /**
     * 获取前台搜索框提交的参数拼接where条件语句
     */
    public String getWhere() {
        String where = " ";
        // 判断URL 参数fangyuanxinxiid是否大于0
        if (Request.getInt("fangyuanxinxiid") > 0) {
            // 大于0 则写入条件
            where += " AND fangyuanxinxiid='" + Request.getInt("fangyuanxinxiid") + "' ";
        }
        if (!Request.get("fangyuanleixing").equals("")) {
            where += " AND fangyuanleixing ='" + Request.get("fangyuanleixing") + "'";
        }
        if (!Request.get("iszf").equals("")) {
            where += " AND iszf ='" + Request.get("iszf") + "'";
        }
        if (!Request.get("zhuangtai").equals("")) {
            where += " AND zhuangtai ='" + Request.get("zhuangtai") + "'";
        }
        if (!Request.get("kehu").equals("")) {
            where += " AND kehu LIKE '%" + Request.get("kehu") + "%'";
        }
        return where;
    }

    /**
     * 后台添加页面入口
     */
    @RequestMapping("/zulin_add")
    public String add() {        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        int id = Request.getInt("id");  // 根据id 获取 房源信息模块中的数据
        Fangyuanxinxi readMap = serviceRead.find(id);
        // 将数据行写入给前台jsp页面
        setAttribute("readMap", readMap);

        SelectExample example = new SelectExample(); //  创建搜索类对象
        example.setWhere("cx='用户'");
        List<Yonghu> userList = yonghuService.selectAll(example);
        setAttribute("userList", userList);
        return "zulin_add";
    }

    /*
    * 租赁接口
    * */

    @RequestMapping("/zuling")
    public String zuling() {
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        // 从请求中获取和房源ID
        Integer userId = Integer.parseInt(Request.get("userid"));
        Integer houseId = Integer.parseInt(Request.get("fangyuanxinxiid"));

        if (houseId == null) {
            return showError("请选择房源！", request.getHeader("referer"));
        }

        // 使用业务门面的命令模式处理租房操作
        boolean result = businessFacade.rentHouse(userId, houseId);
        if (result) {
            return showSuccess("添加租赁成功！", request.getHeader("referer"));
        } else {
            return showError("添加租赁失败！", request.getHeader("referer"));
        }
    }

    /**
     * 后台添加页面入口
     */
    @RequestMapping("/zulin_updt")
    public String updt() {
        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Zulin mmm = service.find(id);
        setAttribute("mmm", mmm);
        setAttribute("updtself", 0);
        return "zulin_updt";
    }

    /**
     * 插入数据入口
     *
     * @return
     */
    @RequestMapping("/zulininsert")
    public String insert() {
        String tmp = "";
        Zulin post = new Zulin();  // 创建实体类对象
        // 将前台提交过来的数据依次set到实体类
        post.setFangyuanxinxiid(Request.getInt("fangyuanxinxiid"));
        post.setFangyuanbianhao(Request.get("fangyuanbianhao"));
        post.setFangyuanleixing(Request.get("fangyuanleixing"));
        post.setJichuzujin(Request.get("jichuzujin"));
        post.setIszf(Request.get("iszf"));
        post.setZulinbianhao(Request.get("zulinbianhao"));
        post.setKehuxingming(Request.get("kehuxingming"));
        post.setLianxifangshi(Request.get("lianxifangshi"));
        post.setZhuangtai(Request.get("zhuangtai"));
        post.setKehu(Request.get("kehu"));
        post.setBeizhu(Request.get("beizhu"));
        post.setZulinriqi(Info.getDateStr());
        service.insert(post); // 交给服务层插入数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    /**
     * 修改数据入口
     */
    @RequestMapping("/zulinupdate")
    public String update() {
        Zulin post = new Zulin();  // 新建实体类
        // 将前台提交过来的数据依次set到实体类
        if (!Request.get("id").equals("")) post.setId(Request.getInt("id"));
        if (!Request.get("fangyuanxinxiid").equals("")) post.setFangyuanxinxiid(Request.getInt("fangyuanxinxiid"));
        if (!Request.get("fangyuanbianhao").equals("")) post.setFangyuanbianhao(Request.get("fangyuanbianhao"));
        if (!Request.get("fangyuanleixing").equals("")) post.setFangyuanleixing(Request.get("fangyuanleixing"));
        if (!Request.get("jichuzujin").equals("")) post.setJichuzujin(Request.get("jichuzujin"));
        if (!Request.get("iszf").equals("")) post.setIszf(Request.get("iszf"));
        if (!Request.get("zulinbianhao").equals("")) post.setZulinbianhao(Request.get("zulinbianhao"));
        if (!Request.get("kehuxingming").equals("")) post.setKehuxingming(Request.get("kehuxingming"));
        if (!Request.get("lianxifangshi").equals("")) post.setLianxifangshi(Request.get("lianxifangshi"));
        if (!Request.get("zhuangtai").equals("")) post.setZhuangtai(Request.get("zhuangtai"));
        if (!Request.get("kehu").equals("")) post.setKehu(Request.get("kehu"));
        if (!Request.get("beizhu").equals("")) post.setBeizhu(Request.get("beizhu"));
        if (!Request.get("zulinriqi").equals("")) post.setZulinriqi(Info.getDateStr());
        service.update(post); // 将数据交给服务层执行更新数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     * 后台详情页
     */
    @RequestMapping("/zulin_detail")
    public String detail() {
        int id = Request.getInt("id");
        Zulin map = service.find(id);  // url 参数中的id获取行数据
        setAttribute("map", map);  // 把数据共享给前台
        return "zulin_detail";  // 详情页面：WebRoot\zulin_detail.jsp
    }

    /**
     * 删除
     */
    @RequestMapping("/zulindelete")
    public String delete() {
        // 前台的判断登录状态，如果未登录则跳转到首页
        if (!checkLogin()) {
            return showError("请登录！", "./");
        }
        int id = Request.getInt("id");  //获取要删除的id通过get url参数
        Zulin map = service.find(id);
        service.delete(id);// 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }

}
