package com.spring.service;

import com.spring.entity.Kanfang;
import com.spring.util.SelectExample;

import java.util.List;

public interface KanfangService {
    Integer count(SelectExample map);
    List<Kanfang> selectAll(SelectExample example);
    List<Kanfang> selectPage(SelectExample example, int page, int pageSize);
    int delete(Object id);
    Kanfang find(Object id);
    int insert(Kanfang pojo);
    int update(Kanfang pojo);
}