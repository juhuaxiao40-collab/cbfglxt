package com.spring.dao;

import com.spring.entity.Kanfang;
import com.spring.util.SelectExample;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface KanfangMapper {
    Integer count(SelectExample map);
    List<Kanfang> selectAll(SelectExample example);
    List<Kanfang> selectPage(SelectExample example);
    int delete(Kanfang pojo);
    Kanfang find(Kanfang pojo);
    int insert(Kanfang pojo);
    int update(Kanfang pojo);
}