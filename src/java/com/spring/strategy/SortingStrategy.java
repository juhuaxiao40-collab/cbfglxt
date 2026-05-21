package com.spring.strategy;
import com.spring.entity.Fangyuanxinxi;
import java.util.Comparator;
import java.util.List;

public interface SortingStrategy {
    List<Fangyuanxinxi> sort(List<Fangyuanxinxi> fangyuanxinxiList);
}