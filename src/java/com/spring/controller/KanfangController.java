package com.spring.controller;

import com.spring.dao.FangyuanxinxiMapper;
import com.spring.entity.Fangyuanxinxi;
import com.spring.entity.Kanfang;
import com.spring.service.KanfangService;
import com.spring.util.*;
import com.spring.util.QueryUtil.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class KanfangController extends BaseController {
    @Autowired
    private KanfangService service;
    @Autowired
    private FangyuanxinxiMapper fangyuanxinxiMapper;

    @RequestMapping("/kanfang_list")
    public String list() {
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        String order = Request.get("order", "id");
        String sort = Request.get("sort", "desc");

        SelectExample example = new SelectExample();
        String where = " 1=1 ";
        where += getWhere();
        example.setWhere(where);
        example.setOrder(order + " " + sort);

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1, page);
        List<Kanfang> list = service.selectPage(example, page, 12);
        setAttribute("list", list);
        setAttribute("orderby", order);
        setAttribute("sort", sort);
        setAttribute("where", where);
        return "kanfang_list";
    }

    @RequestMapping("/kanfang_list_kehu")
    public String listKehu() {
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        String kehu = session.getAttribute("username").toString();
        
        String order = Request.get("order", "id");
        String sort = Request.get("sort", "desc");

        SelectExample example = new SelectExample();
        String where = " kehu = '" + kehu + "' ";
        where += getWhere();
        example.setWhere(where);
        example.setOrder(order + " " + sort);

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1, page);
        List<Kanfang> list = service.selectPage(example, page, 12);
        setAttribute("list", list);
        setAttribute("orderby", order);
        setAttribute("sort", sort);
        setAttribute("where", where);
        return "kanfang_list";
    }

    public String getWhere() {
        String where = " ";

        if (!Request.get("zhuangtai").equals("")) {
            where += " AND zhuangtai ='" + Request.get("zhuangtai") + "'";
        }

        return where;
    }

    @RequestMapping("/kanfang_add")
    public String add() {
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        
        SelectExample example = new SelectExample();
        example.setWhere(" fangyuanzhuangtai = '空闲' ");
        List<Fangyuanxinxi> fangyuanList = fangyuanxinxiMapper.selectAll(example);
        setAttribute("fangyuanList", fangyuanList);
        
        return "kanfang_add";
    }

    @RequestMapping("/kanfang_updt")
    public String updt() {
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        int id = Request.getInt("id");
        Kanfang mmm = service.find(id);
        setAttribute("mmm", mmm);
        return "kanfang_updt";
    }

    @RequestMapping("/kanfanginsert")
    public String insert() {
        Kanfang post = new Kanfang();
        String fangyuanbianhao = Request.get("fangyuanbianhao");
        post.setFangyuanbianhao(fangyuanbianhao);
        
        SelectExample example = new SelectExample();
        example.setWhere(" fangyuanbianhao = '" + fangyuanbianhao + "' ");
        List<Fangyuanxinxi> fangyuanList = fangyuanxinxiMapper.selectAll(example);
        if (!fangyuanList.isEmpty()) {
            post.setFangyuanmingchen(fangyuanList.get(0).getFangyuanmingchen());
        } else {
            post.setFangyuanmingchen("");
        }
        
        post.setKehuxingming(Request.get("kehuxingming"));
        post.setLianxifangshi(Request.get("lianxifangshi"));
        post.setKanfangshijian(Request.get("kanfangshijian"));
        post.setZhuangtai("待审核");
        post.setBeizhu(Request.get("beizhu"));
        post.setKehu(session.getAttribute("username").toString());
        service.insert(post);

        return showSuccess("提交成功", Request.get("referer").equals("") ? "./kanfang_list_kehu.do" : Request.get("referer"));
    }

    @RequestMapping("/kanfangupdate")
    public String update() {
        Kanfang post = new Kanfang();
        if (!Request.get("id").equals("")) post.setId(Request.getInt("id"));
        if (!Request.get("zhuangtai").equals("")) post.setZhuangtai(Request.get("zhuangtai"));
        if (!Request.get("beizhu").equals("")) post.setBeizhu(Request.get("beizhu"));

        service.update(post);

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    @RequestMapping("/kanfang_detail")
    public String detail() {
        int id = Request.getInt("id");
        Kanfang map = service.find(id);
        setAttribute("map", map);
        return "kanfang_detail";
    }

    @RequestMapping("/kanfangdelete")
    public String delete() {
        if (!checkLogin()) {
            return showError("请登录！", "./");
        }

        int id = Request.getInt("id");
        service.delete(id);

        return showSuccess("删除成功", request.getHeader("referer"));
    }
}