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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.observer.HouseSubject;
@Service("ZulinService")
public class ZulinServiceImpl implements ZulinService {
    @Resource
    private ZulinMapper dao;

    @Override
    public Integer count(SelectExample map) {
        return dao.count(map);
    }

    @Override
    public List<Zulin> selectAll(SelectExample example) {
        return dao.selectAll(example);
    }
    @Autowired
    private HouseSubject houseSubject;


    @Override
    public List<Zulin> selectPage(SelectExample example, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Zulin> list = dao.selectPage(example);
        PageInfo<Zulin> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    @Override
    public int delete(Object id) {
        Zulin zulin = new Zulin();
        zulin.setId(Integer.valueOf(String.valueOf(id)));
        return dao.delete(zulin);
    }

    @Override
    public Zulin find(Object id) {
        Zulin zulin = new Zulin();
        zulin.setId(Integer.valueOf(String.valueOf(id)));
        return dao.find(zulin);
    }

    @Override
    public int insert(Zulin pojo) {
        int result=dao.insert(pojo);


        return result;
    }

    @Override
    public int update(Zulin pojo) {
        return dao.update(pojo);
    }


    }

