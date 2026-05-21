package com.spring.entity;

import java.io.*;

public class Zulin implements Serializable , Cloneable{
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer fangyuanxinxiid;
    private String fangyuanbianhao;
    private String fangyuanleixing;
    private String jichuzujin;
    private String iszf;
    private String zulinbianhao;
    private String kehuxingming;
    private String lianxifangshi;
    private String zhuangtai;
    private String kehu;
    private String beizhu;
    private String zulinriqi;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getFangyuanxinxiid() { return fangyuanxinxiid; }
    public void setFangyuanxinxiid(Integer fangyuanxinxiid) { this.fangyuanxinxiid = fangyuanxinxiid; }
    public String getFangyuanbianhao() { return fangyuanbianhao; }
    public void setFangyuanbianhao(String fangyuanbianhao) { this.fangyuanbianhao = fangyuanbianhao == null ? "" : fangyuanbianhao; }
    public String getFangyuanleixing() { return fangyuanleixing; }
    public void setFangyuanleixing(String fangyuanleixing) { this.fangyuanleixing = fangyuanleixing == null ? "" : fangyuanleixing; }
    public String getJichuzujin() { return jichuzujin; }
    public void setJichuzujin(String jichuzujin) { this.jichuzujin = jichuzujin == null || jichuzujin=="" ? "0.00" : jichuzujin; }
    public String getIszf() { return iszf; }
    public void setIszf(String iszf) { this.iszf = iszf == null ? "" : iszf; }
    public String getZulinbianhao() { return zulinbianhao; }
    public void setZulinbianhao(String zulinbianhao) { this.zulinbianhao = zulinbianhao == null ? "" : zulinbianhao; }
    public String getKehuxingming() { return kehuxingming; }
    public void setKehuxingming(String kehuxingming) { this.kehuxingming = kehuxingming == null ? "" : kehuxingming; }
    public String getLianxifangshi() { return lianxifangshi; }
    public void setLianxifangshi(String lianxifangshi) { this.lianxifangshi = lianxifangshi == null ? "" : lianxifangshi; }
    public String getZhuangtai() { return zhuangtai; }
    public void setZhuangtai(String zhuangtai) { this.zhuangtai = zhuangtai == null ? "" : zhuangtai; }
    public String getKehu() { return kehu; }
    public void setKehu(String kehu) { this.kehu = kehu == null ? "" : kehu; }
    public String getBeizhu() { return beizhu; }
    public void setBeizhu(String beizhu) { this.beizhu = beizhu == null ? "" : beizhu; }
    public String getZulinriqi() { return zulinriqi; }
    public void setZulinriqi(String zulinriqi) { this.zulinriqi = zulinriqi == null ? "" : zulinriqi; }
    @Override
    public Zulin clone() {
        try {
            return (Zulin) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Zulin deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Zulin) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
