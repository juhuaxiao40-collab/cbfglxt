package com.spring.entity;

import java.io.*;

public class Kanfang implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String fangyuanbianhao;
    private String fangyuanmingchen;
    private String kehuxingming;
    private String lianxifangshi;
    private String kanfangshijian;
    private String zhuangtai;
    private String beizhu;
    private String kehu;
    private java.sql.Timestamp tianjiashijian;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getFangyuanbianhao() { return fangyuanbianhao; }
    public void setFangyuanbianhao(String fangyuanbianhao) { this.fangyuanbianhao = fangyuanbianhao == null ? "" : fangyuanbianhao; }
    public String getFangyuanmingchen() { return fangyuanmingchen; }
    public void setFangyuanmingchen(String fangyuanmingchen) { this.fangyuanmingchen = fangyuanmingchen == null ? "" : fangyuanmingchen; }
    public String getKehuxingming() { return kehuxingming; }
    public void setKehuxingming(String kehuxingming) { this.kehuxingming = kehuxingming == null ? "" : kehuxingming; }
    public String getLianxifangshi() { return lianxifangshi; }
    public void setLianxifangshi(String lianxifangshi) { this.lianxifangshi = lianxifangshi == null ? "" : lianxifangshi; }
    public String getKanfangshijian() { return kanfangshijian; }
    public void setKanfangshijian(String kanfangshijian) { this.kanfangshijian = kanfangshijian == null ? "" : kanfangshijian; }
    public String getZhuangtai() { return zhuangtai; }
    public void setZhuangtai(String zhuangtai) { this.zhuangtai = zhuangtai == null ? "" : zhuangtai; }
    public String getBeizhu() { return beizhu; }
    public void setBeizhu(String beizhu) { this.beizhu = beizhu == null ? "" : beizhu; }
    public String getKehu() { return kehu; }
    public void setKehu(String kehu) { this.kehu = kehu == null ? "" : kehu; }
    public java.sql.Timestamp getTianjiashijian() { return tianjiashijian; }
    public void setTianjiashijian(java.sql.Timestamp tianjiashijian) { this.tianjiashijian = tianjiashijian; }

    @Override
    public Kanfang clone() {
        try {
            return (Kanfang) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Kanfang deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Kanfang) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}