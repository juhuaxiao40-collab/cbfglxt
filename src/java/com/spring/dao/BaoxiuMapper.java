package com.spring.dao;

import com.spring.entity.Baoxiu;
import com.spring.util.SelectExample;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaoxiuMapper {
    Integer count(SelectExample map);
    List<Baoxiu> selectAll(SelectExample example);
    List<Baoxiu> selectPage(SelectExample example);
    int delete(Baoxiu pojo);
    Baoxiu find(Baoxiu pojo);
    int insert(Baoxiu pojo);
    int update(Baoxiu pojo);
}