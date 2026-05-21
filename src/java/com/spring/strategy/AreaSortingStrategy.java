package com.spring.strategy;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import com.spring.entity.Fangyuanxinxi;

@Component
public class AreaSortingStrategy implements SortingStrategy {
    @Override
    public List<Fangyuanxinxi> sort(List<Fangyuanxinxi> fangyuanxinxiList) {
        List<Fangyuanxinxi> sortedList = new ArrayList<>(fangyuanxinxiList);

        // 使用匿名内部类实现比较器，避免方法引用类型问题
        Collections.sort(sortedList, new Comparator<Fangyuanxinxi>() {
            @Override
            public int compare(Fangyuanxinxi o1, Fangyuanxinxi o2) {
                //转换类型为double
                double area1 = Double.parseDouble(o1.getMianji());
                double area2 = Double.parseDouble(o2.getMianji());
                return Double.compare(area1, area2);
            }
        });

        return sortedList;
    }
}