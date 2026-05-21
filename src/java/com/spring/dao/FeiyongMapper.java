package com.spring.dao;

import com.spring.entity.*;
import com.spring.util.SelectExample;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public interface FeiyongMapper{
    Integer count(SelectExample map);
    // 查询全部数据
    List<Feiyong> selectAll(SelectExample example);
    // 按分页查询数据
    List<Feiyong> selectPage(SelectExample example);
    // 删除数据
    int delete(Feiyong pojo);
    // 查询一行数据
    Feiyong find(Feiyong pojo);
    // 插入数据
    int insert(Feiyong pojo);
    // 更新数据
    int update(Feiyong pojo);
}
