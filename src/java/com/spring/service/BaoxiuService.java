package com.spring.service;

import com.spring.entity.Baoxiu;
import com.spring.util.SelectExample;

import java.util.List;

public interface BaoxiuService {
    Integer count(SelectExample map);
    List<Baoxiu> selectAll(SelectExample example);
    List<Baoxiu> selectPage(SelectExample example, int page, int pageSize);
    int delete(Object id);
    Baoxiu find(Object id);
    int insert(Baoxiu pojo);
    int update(Baoxiu pojo);
}