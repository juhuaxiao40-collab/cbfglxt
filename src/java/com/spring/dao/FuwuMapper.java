package com.spring.dao;

import com.spring.entity.*;
import com.spring.util.SelectExample;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public interface FuwuMapper{
    Integer count(SelectExample map);
    // 查询全部数据
    List<Fuwu> selectAll(SelectExample example);
    // 按分页查询数据
    List<Fuwu> selectPage(SelectExample example);
    // 删除数据
    int delete(Fuwu pojo);
    // 查询一行数据
    Fuwu find(Fuwu pojo);
    // 插入数据
    int insert(Fuwu pojo);
    // 更新数据
    int update(Fuwu pojo);
}
