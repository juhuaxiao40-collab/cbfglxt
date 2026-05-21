package com.spring.observer;


import com.spring.entity.Fangyuanxinxi;
import java.util.ArrayList;
import java.util.List;

// 观察者接口
public interface HouseStatusObserver {
    void update(Fangyuanxinxi house);
}