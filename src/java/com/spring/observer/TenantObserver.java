package com.spring.observer;


import com.spring.entity.Fangyuanxinxi;
import java.util.ArrayList;
import java.util.List;



// 具体观察者：租户
public class TenantObserver implements HouseStatusObserver {
    private String tenantName;

    public TenantObserver(String tenantName) {
        this.tenantName = tenantName;
    }

    @Override
    public void update(Fangyuanxinxi house) {
        System.out.println("通知租户 " + tenantName + "：房源 " + house.getFangyuanbianhao() +
                " 的状态已更新为 " + house.getFangyuanzhuangtai());
        // 实际通知逻辑...

    }
}