package com.spring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;
import com.spring.util.SelectExample;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("FangyuanxinxiService")
public class FangyuanxinxiServiceImpl implements FangyuanxinxiService {
    @Resource
    private FangyuanxinxiMapper dao;

    @Override
    public Integer count(SelectExample map) {
        return dao.count(map);
    }

    @Override
    public List<Fangyuanxinxi> selectAll(SelectExample example) {
        return dao.selectAll(example);
    }

    @Override
    public List<Fangyuanxinxi> selectPage(SelectExample example, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Fangyuanxinxi> list = dao.selectPage(example);
        PageInfo<Fangyuanxinxi> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    @Override
    public int delete(Object id) {
        Fangyuanxinxi fangyuanxinxi = new Fangyuanxinxi();
        fangyuanxinxi.setId(Integer.valueOf(String.valueOf(id)));
        return dao.delete(fangyuanxinxi);
    }

    @Override
    public Fangyuanxinxi find(Object id) {
        Fangyuanxinxi fangyuanxinxi = new Fangyuanxinxi();
        fangyuanxinxi.setId(Integer.valueOf(String.valueOf(id)));
        return dao.find(fangyuanxinxi);
    }

    @Override
    public int insert(Fangyuanxinxi pojo) {
        return dao.insert(pojo);
    }

    @Override
    public int update(Fangyuanxinxi pojo) {
        return dao.update(pojo);
    }


    }

