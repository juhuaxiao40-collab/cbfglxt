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

@Service("FuwuService")
public class FuwuServiceImpl implements FuwuService {
    @Resource
    private FuwuMapper dao;

    @Override
    public Integer count(SelectExample map) {
        return dao.count(map);
    }

    @Override
    public List<Fuwu> selectAll(SelectExample example) {
        return dao.selectAll(example);
    }

    @Override
    public List<Fuwu> selectPage(SelectExample example, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Fuwu> list = dao.selectPage(example);
        PageInfo<Fuwu> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    @Override
    public int delete(Object id) {
        Fuwu fuwu = new Fuwu();
        fuwu.setId(Integer.valueOf(String.valueOf(id)));
        return dao.delete(fuwu);
    }

    @Override
    public Fuwu find(Object id) {
        Fuwu fuwu = new Fuwu();
        fuwu.setId(Integer.valueOf(String.valueOf(id)));
        return dao.find(fuwu);
    }

    @Override
    public int insert(Fuwu pojo) {
        return dao.insert(pojo);
    }

    @Override
    public int update(Fuwu pojo) {
        return dao.update(pojo);
    }


    }

