package com.spring.dao;

import com.spring.entity.*;
import com.spring.util.SelectExample;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public interface ZulinMapper{
    Integer count(SelectExample map);
    // 查询全部数据
    List<Zulin> selectAll(SelectExample example);
    // 按分页查询数据
    List<Zulin> selectPage(SelectExample example);
    // 删除数据
    int delete(Zulin pojo);
    // 查询一行数据
    Zulin find(Zulin pojo);
    // 插入数据
    int insert(Zulin pojo);
    // 更新数据
    int update(Zulin pojo);
}
