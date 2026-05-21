package com.spring.observer;

import com.spring.entity.Fangyuanxinxi;
import java.util.ArrayList;
import java.util.List;
// 具体观察者：管理员
public class AdminObserver implements HouseStatusObserver {
    private String adminName;

    public AdminObserver(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public void update(Fangyuanxinxi house) {
        System.out.println("通知管理员 " + adminName + "：房源 " + house.getFangyuanbianhao() +
                " 的状态已更新为 " + house.getFangyuanzhuangtai());

        // 通知...
    }
}