package com.spring.service;

import com.spring.util.SelectExample;
import com.spring.entity.*;
import java.util.*;
public interface FuwuService{
    // 查询总行数
    Integer count(SelectExample map);
    // 按分页查询数据
    List<Fuwu> selectPage(SelectExample example, int page, int pageSize);
    // 搜索全部数据
    List<Fuwu> selectAll(SelectExample example);
    // 按id删除一行数据
    int delete(Object id);
    // 查询一行数据
    Fuwu find(Object id);
    // 插入一行数据
    int insert(Fuwu pojo);
    // 更新一行数据
    int update(Fuwu pojo);
}
