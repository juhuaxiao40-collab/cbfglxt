package com.spring.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.spring.dao.*;
import com.spring.entity.*;
import com.spring.service.*;
import com.spring.util.*;
import java.util.*;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("BaoxiuService")
public class BaoxiuServiceImpl implements BaoxiuService {
    @Resource
    private BaoxiuMapper dao;

    @Override
    public Integer count(SelectExample map) {
        return dao.count(map);
    }

    @Override
    public List<Baoxiu> selectAll(SelectExample example) {
        return dao.selectAll(example);
    }

    @Override
    public List<Baoxiu> selectPage(SelectExample example, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Baoxiu> list = dao.selectPage(example);
        PageInfo<Baoxiu> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    @Override
    public int delete(Object id) {
        Baoxiu baoxiu = new Baoxiu();
        baoxiu.setId(Integer.valueOf(String.valueOf(id)));
        return dao.delete(baoxiu);
    }

    @Override
    public Baoxiu find(Object id) {
        Baoxiu baoxiu = new Baoxiu();
        baoxiu.setId(Integer.valueOf(String.valueOf(id)));
        return dao.find(baoxiu);
    }

    @Override
    public int insert(Baoxiu pojo) {
        return dao.insert(pojo);
    }

    @Override
    public int update(Baoxiu pojo) {
        return dao.update(pojo);
    }
}