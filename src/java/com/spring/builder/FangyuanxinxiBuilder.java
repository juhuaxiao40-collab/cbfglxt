package com.spring.builder;

import com.spring.entity.Fangyuanxinxi;

public class FangyuanxinxiBuilder {
    private Fangyuanxinxi fangyuanxinxi;
    
    public FangyuanxinxiBuilder() {
        this.fangyuanxinxi = new Fangyuanxinxi();
    }
    
    public FangyuanxinxiBuilder setFangyuanbianhao(String fangyuanbianhao) {
        fangyuanxinxi.setFangyuanbianhao(fangyuanbianhao);
        return this;
    }
    
    public FangyuanxinxiBuilder setFangyuanmingchen(String fangyuanmingchen) {
        fangyuanxinxi.setFangyuanmingchen(fangyuanmingchen);
        return this;
    }
    
    public FangyuanxinxiBuilder setFangyuanleixing(String fangyuanleixing) {
        fangyuanxinxi.setFangyuanleixing(fangyuanleixing);
        return this;
    }
    
    public FangyuanxinxiBuilder setFangyuanzhuangtai(String fangyuanzhuangtai) {
        fangyuanxinxi.setFangyuanzhuangtai(fangyuanzhuangtai);
        return this;
    }
    
    public FangyuanxinxiBuilder setLouceng(String louceng) {
        fangyuanxinxi.setLouceng(louceng);
        return this;
    }
    
    public FangyuanxinxiBuilder setFangxing(String fangxing) {
        fangyuanxinxi.setFangxing(fangxing);
        return this;
    }
    
    public FangyuanxinxiBuilder setMianji(String mianji) {
        fangyuanxinxi.setMianji(mianji);
        return this;
    }
    
    public FangyuanxinxiBuilder setJichuzujin(String jichuzujin) {
        fangyuanxinxi.setJichuzujin(jichuzujin);
        return this;
    }
    
    public FangyuanxinxiBuilder setPeitaosheshi(String peitaosheshi) {
        fangyuanxinxi.setPeitaosheshi(peitaosheshi);
        return this;
    }
    
    public FangyuanxinxiBuilder setFangyuanjieshao(String fangyuanjieshao) {
        fangyuanxinxi.setFangyuanjieshao(fangyuanjieshao);
        return this;
    }
    
    public Fangyuanxinxi build() {
        return fangyuanxinxi;
    }
}