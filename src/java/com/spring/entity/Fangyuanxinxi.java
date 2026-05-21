package com.spring.entity;

import java.io.*;

// Fangyuanxinxi.java 添加原型模式
public class Fangyuanxinxi implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String fangyuanbianhao;
    private String fangyuanmingchen;
    private String fangyuanleixing;
    private String fangyuanzhuangtai;
    private String louceng;
    private String fangxing;
    private String mianji;
    private String jichuzujin;
    private String peitaosheshi;
    private String fangyuanjieshao;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFangyuanbianhao() { return fangyuanbianhao; }
    public void setFangyuanbianhao(String fangyuanbianhao) { this.fangyuanbianhao = fangyuanbianhao == null ? "" : fangyuanbianhao; }
    public String getFangyuanmingchen() { return fangyuanmingchen; }
    public void setFangyuanmingchen(String fangyuanmingchen) { this.fangyuanmingchen = fangyuanmingchen == null ? "" : fangyuanmingchen; }
    public String getFangyuanleixing() { return fangyuanleixing; }
    public void setFangyuanleixing(String fangyuanleixing) { this.fangyuanleixing = fangyuanleixing == null ? "" : fangyuanleixing; }
    public String getFangyuanzhuangtai() { return fangyuanzhuangtai; }
    public void setFangyuanzhuangtai(String fangyuanzhuangtai) { this.fangyuanzhuangtai = fangyuanzhuangtai == null ? "" : fangyuanzhuangtai; }
    public String getLouceng() { return louceng; }
    public void setLouceng(String louceng) { this.louceng = louceng == null ? "" : louceng; }
    public String getFangxing() { return fangxing; }
    public void setFangxing(String fangxing) { this.fangxing = fangxing == null ? "" : fangxing; }
    public String getMianji() { return mianji; }
    public void setMianji(String mianji) { this.mianji = mianji == null ? "" : mianji; }
    public String getJichuzujin() { return jichuzujin; }
    public void setJichuzujin(String jichuzujin) { this.jichuzujin = jichuzujin == null || jichuzujin=="" ? "0.00" : jichuzujin; }
    public String getPeitaosheshi() { return peitaosheshi; }
    public void setPeitaosheshi(String peitaosheshi) { this.peitaosheshi = peitaosheshi == null ? "" : peitaosheshi; }
    public String getFangyuanjieshao() { return fangyuanjieshao; }
    public void setFangyuanjieshao(String fangyuanjieshao) { this.fangyuanjieshao = fangyuanjieshao == null ? "" : fangyuanjieshao; }

    @Override
    public Fangyuanxinxi clone() {
        try {
            return (Fangyuanxinxi) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Fangyuanxinxi deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Fangyuanxinxi) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}