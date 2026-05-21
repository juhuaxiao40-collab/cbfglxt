package com.spring.service;

import com.spring.util.SelectExample;
import com.spring.entity.*;
import java.util.*;
public interface JieyueService{
    // 查询总行数
    Integer count(SelectExample map);
    // 按分页查询数据
    List<Jieyue> selectPage(SelectExample example, int page, int pageSize);
    // 搜索全部数据
    List<Jieyue> selectAll(SelectExample example);
    // 按id删除一行数据
    int delete(Object id);
    // 查询一行数据
    Jieyue find(Object id);
    // 插入一行数据
    int insert(Jieyue pojo);
    // 更新一行数据
    int update(Jieyue pojo);
}
