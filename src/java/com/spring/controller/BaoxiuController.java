package com.spring.controller;

import com.spring.dao.FangyuanxinxiMapper;
import com.spring.dao.ZulinMapper;
import com.spring.entity.Baoxiu;
import com.spring.entity.Fangyuanxinxi;
import com.spring.entity.Zulin;
import com.spring.service.BaoxiuService;
import com.spring.util.*;
import com.spring.util.QueryUtil.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BaoxiuController extends BaseController {
    @Autowired
    private BaoxiuService service;
    @Autowired
    private ZulinMapper zulinMapper;
    @Autowired
    private FangyuanxinxiMapper fangyuanxinxiMapper;

    @RequestMapping("/baoxiu_list")
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
        List<Baoxiu> list = service.selectPage(example, page, 12);
        setAttribute("list", list);
        setAttribute("orderby", order);
        setAttribute("sort", sort);
        setAttribute("where", where);
        return "baoxiu_list";
    }

    @RequestMapping("/baoxiu_list_kehu")
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
        List<Baoxiu> list = service.selectPage(example, page, 12);
        setAttribute("list", list);
        setAttribute("orderby", order);
        setAttribute("sort", sort);
        setAttribute("where", where);
        return "baoxiu_list";
    }

    public String getWhere() {
        String where = " ";

        if (!Request.get("baoxiuleixing").equals("")) {
            where += " AND baoxiuleixing ='" + Request.get("baoxiuleixing") + "'";
        }

        if (!Request.get("zhuangtai").equals("")) {
            where += " AND zhuangtai ='" + Request.get("zhuangtai") + "'";
        }

        return where;
    }

    @RequestMapping("/baoxiu_add")
    public String add() {
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        
        String kehu = session.getAttribute("username").toString();
        SelectExample example = new SelectExample();
        example.setWhere(" kehu = '" + kehu + "' AND zhuangtai = '已生效' ");
        List<Zulin> zulinList = zulinMapper.selectAll(example);
        setAttribute("zulinList", zulinList);
        
        return "baoxiu_add";
    }

    @RequestMapping("/baoxiu_updt")
    public String updt() {
        if (!checkLogin()) {
            return showError("请登录！", "./login.do");
        }
        int id = Request.getInt("id");
        Baoxiu mmm = service.find(id);
        setAttribute("mmm", mmm);
        return "baoxiu_updt";
    }

    @RequestMapping("/baoxiuinsert")
    public String insert() {
        Baoxiu post = new Baoxiu();
        String zulinbianhao = Request.get("zulinbianhao");
        post.setZulinbianhao(zulinbianhao);
        
        String fangyuanbianhao = Request.get("fangyuanbianhao");
        String fangyuanmingchen = Request.get("fangyuanmingchen");
        
        if (fangyuanbianhao == null || fangyuanbianhao.isEmpty()) {
            SelectExample zulinExample = new SelectExample();
            zulinExample.setWhere(" zulinbianhao = '" + zulinbianhao + "' ");
            List<Zulin> zulinList = zulinMapper.selectAll(zulinExample);
            if (!zulinList.isEmpty()) {
                fangyuanbianhao = zulinList.get(0).getFangyuanbianhao();
                post.setFangyuanbianhao(fangyuanbianhao);
            }
        } else {
            post.setFangyuanbianhao(fangyuanbianhao);
        }
        
        if (fangyuanmingchen == null || fangyuanmingchen.isEmpty()) {
            SelectExample fangyuanExample = new SelectExample();
            fangyuanExample.setWhere(" fangyuanbianhao = '" + fangyuanbianhao + "' ");
            List<Fangyuanxinxi> fangyuanList = fangyuanxinxiMapper.selectAll(fangyuanExample);
            if (!fangyuanList.isEmpty()) {
                post.setFangyuanmingchen(fangyuanList.get(0).getFangyuanmingchen());
            } else {
                post.setFangyuanmingchen("");
            }
        } else {
            post.setFangyuanmingchen(fangyuanmingchen);
        }
        
        post.setKehuxingming(Request.get("kehuxingming"));
        post.setLianxifangshi(Request.get("lianxifangshi"));
        post.setBaoxiuleixing(Request.get("baoxiuleixing"));
        post.setBaoxiuneirong(Request.get("baoxiuneirong"));
        post.setZhuangtai("待处理");
        post.setBeizhu(Request.get("beizhu"));
        post.setKehu(session.getAttribute("username").toString());
        service.insert(post);

        return showSuccess("提交成功", Request.get("referer").equals("") ? "./baoxiu_list_kehu.do" : Request.get("referer"));
    }

    @RequestMapping("/baoxiuupdate")
    public String update() {
        Baoxiu post = new Baoxiu();
        if (!Request.get("id").equals("")) post.setId(Request.getInt("id"));
        if (!Request.get("zhuangtai").equals("")) post.setZhuangtai(Request.get("zhuangtai"));
        if (!Request.get("beizhu").equals("")) post.setBeizhu(Request.get("beizhu"));

        service.update(post);

        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get("referer"));
    }

    @RequestMapping("/baoxiu_detail")
    public String detail() {
        int id = Request.getInt("id");
        Baoxiu map = service.find(id);
        setAttribute("map", map);
        return "baoxiu_detail";
    }

    @RequestMapping("/baoxiudelete")
    public String delete() {
        if (!checkLogin()) {
            return showError("请登录！", "./");
        }

        int id = Request.getInt("id");
        service.delete(id);

        return showSuccess("删除成功", request.getHeader("referer"));
    }
}