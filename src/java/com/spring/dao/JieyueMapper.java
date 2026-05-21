package com.spring.dao;

import com.spring.entity.*;
import com.spring.util.SelectExample;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public interface JieyueMapper{
    Integer count(SelectExample map);
    // 查询全部数据
    List<Jieyue> selectAll(SelectExample example);
    // 按分页查询数据
    List<Jieyue> selectPage(SelectExample example);
    // 删除数据
    int delete(Jieyue pojo);
    // 查询一行数据
    Jieyue find(Jieyue pojo);
    // 插入数据
    int insert(Jieyue pojo);
    // 更新数据
    int update(Jieyue pojo);
}
