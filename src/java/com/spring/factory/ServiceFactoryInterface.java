package com.spring.factory;


import com.spring.service.*;


// 抽象服务工厂接口
public interface ServiceFactoryInterface {
    YonghuService createYonghuService();
    FangyuanxinxiService createFangyuanxinxiService();
    ZulinService createZulinService();
    FeiyongService createFeiyongService();
    FuwuService createFuwuService();
    JieyueService createJieyueService();
}
