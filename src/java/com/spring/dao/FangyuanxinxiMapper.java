package com.spring.dao;

import com.spring.entity.*;
import com.spring.util.SelectExample;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public interface FangyuanxinxiMapper{
    Integer count(SelectExample map);
    // 查询全部数据
    List<Fangyuanxinxi> selectAll(SelectExample example);
    // 按分页查询数据
    List<Fangyuanxinxi> selectPage(SelectExample example);
    // 删除数据
    int delete(Fangyuanxinxi pojo);
    // 查询一行数据
    Fangyuanxinxi find(Fangyuanxinxi pojo);
    // 插入数据
    int insert(Fangyuanxinxi pojo);
    // 更新数据
    int update(Fangyuanxinxi pojo);
}
