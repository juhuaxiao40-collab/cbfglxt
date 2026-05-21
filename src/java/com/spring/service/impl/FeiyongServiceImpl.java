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

@Service("FeiyongService")
public class FeiyongServiceImpl implements FeiyongService {
    @Resource
    private FeiyongMapper dao;

    @Override
    public Integer count(SelectExample map) {
        return dao.count(map);
    }

    @Override
    public List<Feiyong> selectAll(SelectExample example) {
        return dao.selectAll(example);
    }

    @Override
    public List<Feiyong> selectPage(SelectExample example, int page, int pageSize) {
        PageHelper.startPage(page, pageSize, true);
        List<Feiyong> list = dao.selectPage(example);
        PageInfo<Feiyong> pageInfo = new PageInfo(list);
        PageInfoUtil pageInfoUtil = new PageInfoUtil(page);
        pageInfoUtil.setPageInfo(Request.getRequest(), pageInfo.getTotal(), pageSize);
        return list;
    }

    @Override
    public int delete(Object id) {
        Feiyong feiyong = new Feiyong();
        feiyong.setId(Integer.valueOf(String.valueOf(id)));
        return dao.delete(feiyong);
    }

    @Override
    public Feiyong find(Object id) {
        Feiyong feiyong = new Feiyong();
        feiyong.setId(Integer.valueOf(String.valueOf(id)));
        return dao.find(feiyong);
    }

    @Override
    public int insert(Feiyong pojo) {
        return dao.insert(pojo);
    }

    @Override
    public int update(Feiyong pojo) {
        return dao.update(pojo);
    }


    }

