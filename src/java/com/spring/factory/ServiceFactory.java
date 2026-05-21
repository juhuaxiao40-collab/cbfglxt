package com.spring.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 服务工厂类 用于创建服务实例 实现了服务工厂接口 提供了获取服务工厂实现类实例的方法

@Component
public class ServiceFactory {
    // 自动注入服务工厂实现类
    @Autowired
    private ServiceFactoryImpl factoryImpl;
        // 返回服务工厂实现类实例
    public ServiceFactoryInterface getFactory() {
        return factoryImpl;
    }
}
