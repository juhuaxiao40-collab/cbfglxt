package com.spring.factory;


import com.spring.service.*;
import com.spring.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactoryImpl implements ServiceFactoryInterface {

    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private FangyuanxinxiService fangyuanxinxiService;

    @Autowired
    private ZulinService zulinService;

    @Autowired
    private FeiyongService feiyongService;

    @Autowired
    private FuwuService fuwuService;

    @Autowired
    private JieyueService jieyueService;

    @Override
    public YonghuService createYonghuService() {
        return yonghuService;
    }

    @Override
    public FangyuanxinxiService createFangyuanxinxiService() {
        return fangyuanxinxiService;
    }

    @Override
    public ZulinService createZulinService() {
        return zulinService;
    }

    @Override
    public FeiyongService createFeiyongService() {
        return feiyongService;
    }

    @Override
    public FuwuService createFuwuService() {
        return fuwuService;
    }

    @Override
    public JieyueService createJieyueService() {
        return jieyueService;
    }
}