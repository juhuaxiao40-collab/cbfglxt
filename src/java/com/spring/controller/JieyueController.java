package com.spring.controller;

import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.util.QueryUtil.*;

import java.util.*;

import com.spring.entity.Zulin;
import com.spring.service.ZulinService;

/**
 * 解约模块控制器
 */
@Controller
public class JieyueController extends BaseController {
    @Autowired
    private JieyueMapper dao;
    @Autowired
    private JieyueService service;

    @Autowired
    private ZulinService serviceRead;

    /**
     * 后台列表页
     *
     */
    @RequestMapping("/jieyue_list")
    public String list() {
        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if(!checkLogin()){
            return showError("请登录！" ,"./login.do");
        }
        String order = Request.get("order" , "id"); // 获取浏览器上地址栏提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); //获取浏览器上地址栏提交的URL参数 sort  如果没有则设置为desc

        SelectExample example = new SelectExample(); //  创建搜索类对象
        String where = " 1=1 ";   // 定义默认SQL语句条件字符串
        where += getWhere();      // 通过getWhere方法中得到url参数提交的全部参数转为条件字符串，返回的是sql条件语句
        example.setWhere(where);   // 将条件写进上面定义好的example条件类中
        example.setOrder(order + " " + sort); // 设置排序方式
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));  // 获取提交的URL 当前页码 参数 page  如果没有则设置为1
        page = Math.max(1, page);  // 取两个数的最大值，预防页码没有提交page 小于1，至少从第一页开始
        List<Jieyue> list = service.selectPage(example, page, 12);   // 当前页的记录，设置每页默认12条记录
        setAttribute("list", list); // 将列表写给界面使用
        setAttribute("orderby", order);  // 把当前排序结果共享数据给前台
        setAttribute("sort", sort);      // 把当前排序结果共享数据给前台
        setAttribute("where", where);    // 把当前条件共享数据给前台
        return "jieyue_list";   // 使用视图文件：WebRoot\jieyue_list.jsp
    }

    /**
     * 后台列表页
     *
     */
    @RequestMapping("/jieyue_list_jieyueren")
    public String listjieyueren() {
        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if(!checkLogin()){
            return showError("请登录！" ,"./login.do");
        }
        String order = Request.get("order" , "id"); // 获取浏览器上地址栏提交的URL参数 order  如果没有则设置为id
        String sort  = Request.get("sort" , "desc"); //获取浏览器上地址栏提交的URL参数 sort  如果没有则设置为desc

        SelectExample example = new SelectExample(); //  创建搜索类对象
        // 定义默认条件SQL语句字符串，条件为：解约人=当前登录用户
        String where = " jieyueren='"+session.getAttribute("username")+"' ";
        where += getWhere();      // 通过getWhere方法中得到url参数提交的全部参数转为条件字符串，返回的是sql条件语句
        example.setWhere(where);   // 将条件写进上面定义好的example条件类中
        example.setOrder(order + " " + sort); // 设置排序方式
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));  // 获取提交的URL 当前页码 参数 page  如果没有则设置为1
        page = Math.max(1, page);  // 取两个数的最大值，预防页码没有提交page 小于1，至少从第一页开始
        List<Jieyue> list = service.selectPage(example, page, 12);   // 当前页的记录，设置每页默认12条记录
        setAttribute("list", list); // 将列表写给界面使用
        setAttribute("orderby", order);  // 把当前排序结果共享数据给前台
        setAttribute("sort", sort);      // 把当前排序结果共享数据给前台
        setAttribute("where", where);    // 把当前条件共享数据给前台
        return "jieyue_list_jieyueren";   // 使用视图文件：WebRoot\jieyue_list_jieyueren.jsp
    }

    /**
     *  获取前台搜索框提交的参数拼接where条件语句
     */
    public String getWhere(){
        String where = " ";
        // 判断URL 参数zulinid是否大于0
        if( Request.getInt("zulinid") > 0 ) {
            // 大于0 则写入条件
            where += " AND zulinid='"+Request.getInt("zulinid")+"' ";
        }
if (!Request.get("jieyueren").equals("")) {where += " AND jieyueren LIKE '%" + Request.get("jieyueren") + "%'"; }      return where;
    }

    /**
     *  后台添加页面入口
     */
    @RequestMapping("/jieyue_add")
    public String add() {        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if(!checkLogin()){
            return showError("请登录！" ,"./login.do");
        }
        int id = Request.getInt("id");  // 根据id 获取 租赁模块中的数据
        Zulin readMap = serviceRead.find(id);
        // 将数据行写入给前台jsp页面
        setAttribute("readMap" , readMap);
     return "jieyue_add";   }

    /**
     *  后台添加页面入口
     */
    @RequestMapping("/jieyue_updt")
    public String updt() {
        // 后台的登录状态判断，如果未登录则跳转到登录的页面
        if(!checkLogin()){
            return showError("请登录！" ,"./login.do");
        }
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Jieyue mmm = service.find(id);
        setAttribute("mmm", mmm);
        setAttribute("updtself", 0);
        return "jieyue_updt";
    }

    /**
     * 插入数据入口
     *
     * @return
     */
    @RequestMapping("/jieyueinsert")
    public String insert() {
        String tmp="";
        Jieyue post = new Jieyue();  // 创建实体类对象
        // 将前台提交过来的数据依次set到实体类
        post.setZulinid(Request.getInt("zulinid"));
        post.setZulinbianhao(Request.get("zulinbianhao"));
        post.setKehuxingming(Request.get("kehuxingming"));
        post.setLianxifangshi(Request.get("lianxifangshi"));
        post.setFangyuanbianhao(Request.get("fangyuanbianhao"));
        post.setYuanyin(DownloadRemoteImage.run(Request.get("yuanyin")));
        post.setJieyueren(Request.get("jieyueren"));
        post.setJieyueshijian(Info.getDateStr());
        service.insert(post); // 交给服务层插入数据
        int charuid = post.getId().intValue();
        Query.execute("update zulin set zhuangtai='已解约' where zulinbianhao='"+Request.get("zulinbianhao")+"'");
        Query.execute("update fangyuanxinxi set fangyuanzhuangtai='空闲' where fangyuanbianhao='"+Request.get("fangyuanbianhao")+"'");

        return showSuccess("保存成功" , Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }
    /**
     * 修改数据入口
     */
    @RequestMapping("/jieyueupdate")
    public String update() {
        Jieyue post = new Jieyue();  // 新建实体类
        // 将前台提交过来的数据依次set到实体类
 if(!Request.get("id").equals(""))         post.setId(Request.getInt("id"));
 if(!Request.get("zulinid").equals(""))         post.setZulinid(Request.getInt("zulinid"));
 if(!Request.get("zulinbianhao").equals(""))         post.setZulinbianhao(Request.get("zulinbianhao"));
 if(!Request.get("kehuxingming").equals(""))         post.setKehuxingming(Request.get("kehuxingming"));
 if(!Request.get("lianxifangshi").equals(""))         post.setLianxifangshi(Request.get("lianxifangshi"));
 if(!Request.get("fangyuanbianhao").equals(""))         post.setFangyuanbianhao(Request.get("fangyuanbianhao"));
 if(!Request.get("yuanyin").equals(""))         post.setYuanyin(DownloadRemoteImage.run(Request.get("yuanyin")));
 if(!Request.get("jieyueren").equals(""))         post.setJieyueren(Request.get("jieyueren"));
 if(!Request.get("jieyueshijian").equals(""))         post.setJieyueshijian(Info.getDateStr());
        service.update(post); // 将数据交给服务层执行更新数据
        int charuid = post.getId().intValue();

        return showSuccess("保存成功" ,  Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }
    /**
     * 后台详情页
     */
   @RequestMapping("/jieyue_detail")
    public String detail(){
        int id = Request.getInt("id");
        Jieyue map = service.find(id);  // url 参数中的id获取行数据
        setAttribute("map" , map);  // 把数据共享给前台
        return "jieyue_detail";  // 详情页面：WebRoot\jieyue_detail.jsp
    }

    /**
     * 删除
     */
   @RequestMapping("/jieyuedelete")
    public String delete(){
        // 前台的判断登录状态，如果未登录则跳转到首页
        if(!checkLogin()){
            return showError("请登录！" ,"./");
        }
        int id = Request.getInt("id");  //获取要删除的id通过get url参数
        Jieyue map =  service.find(id);        service.delete(id);// 根据id 删除某行数据
        return showSuccess("删除成功",request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }

}
