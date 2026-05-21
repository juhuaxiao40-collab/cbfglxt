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

@Service("JieyueService")
public class JieyueServiceImpl implements JieyueService {
    @Resource
    private JieyueMapper dao;

    @Override
    public Integer count(SelectExample map) {
        return dao.count(map);
    }

    @Override
    public List<Jieyue> selectAll(SelectExample example) {
        return dao.selectAll(example);
    }

    @Override
    public List<Jieyue> selectPage(SelectExample example, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Jieyue> list = dao.selectPage(example);
        PageInfo<Jieyue> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    @Override
    public int delete(Object id) {
        Jieyue jieyue = new Jieyue();
        jieyue.setId(Integer.valueOf(String.valueOf(id)));
        return dao.delete(jieyue);
    }

    @Override
    public Jieyue find(Object id) {
        Jieyue jieyue = new Jieyue();
        jieyue.setId(Integer.valueOf(String.valueOf(id)));
        return dao.find(jieyue);
    }

    @Override
    public int insert(Jieyue pojo) {
        return dao.insert(pojo);
    }

    @Override
    public int update(Jieyue pojo) {
        return dao.update(pojo);
    }


    }

