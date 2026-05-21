package com.spring.entity;

import java.io.*;

public class Jieyue implements Serializable , Cloneable{
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer zulinid;
    private String zulinbianhao;
    private String kehuxingming;
    private String lianxifangshi;
    private String fangyuanbianhao;
    private String yuanyin;
    private String jieyueren;
    private String jieyueshijian;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getZulinid() { return zulinid; }
    public void setZulinid(Integer zulinid) { this.zulinid = zulinid; }
    public String getZulinbianhao() { return zulinbianhao; }
    public void setZulinbianhao(String zulinbianhao) { this.zulinbianhao = zulinbianhao == null ? "" : zulinbianhao; }
    public String getKehuxingming() { return kehuxingming; }
    public void setKehuxingming(String kehuxingming) { this.kehuxingming = kehuxingming == null ? "" : kehuxingming; }
    public String getLianxifangshi() { return lianxifangshi; }
    public void setLianxifangshi(String lianxifangshi) { this.lianxifangshi = lianxifangshi == null ? "" : lianxifangshi; }
    public String getFangyuanbianhao() { return fangyuanbianhao; }
    public void setFangyuanbianhao(String fangyuanbianhao) { this.fangyuanbianhao = fangyuanbianhao == null ? "" : fangyuanbianhao; }
    public String getYuanyin() { return yuanyin; }
    public void setYuanyin(String yuanyin) { this.yuanyin = yuanyin == null ? "" : yuanyin; }
    public String getJieyueren() { return jieyueren; }
    public void setJieyueren(String jieyueren) { this.jieyueren = jieyueren == null ? "" : jieyueren; }
    public String getJieyueshijian() { return jieyueshijian; }
    public void setJieyueshijian(String jieyueshijian) { this.jieyueshijian = jieyueshijian == null ? "" : jieyueshijian; }
    @Override
    public Jieyue clone() {
        try {
            return (Jieyue) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Jieyue deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Jieyue) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
