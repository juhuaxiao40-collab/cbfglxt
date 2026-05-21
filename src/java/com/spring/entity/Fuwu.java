package com.spring.entity;

import java.io.*;

public class Fuwu implements Serializable , Cloneable{
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer zulinid;
    private String fuwubianhao;
    private String kehuxingming;
    private String lianxifangshi;
    private String fuwuleixing;
    private String fuwuzhuangtai;
    private String fuwuneirong;
    private String fuwuliuyan;
    private String tianjiaren;
    private String tianjiashijian;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getZulinid() { return zulinid; }
    public void setZulinid(Integer zulinid) { this.zulinid = zulinid; }
    public String getFuwubianhao() { return fuwubianhao; }
    public void setFuwubianhao(String fuwubianhao) { this.fuwubianhao = fuwubianhao == null ? "" : fuwubianhao; }
    public String getKehuxingming() { return kehuxingming; }
    public void setKehuxingming(String kehuxingming) { this.kehuxingming = kehuxingming == null ? "" : kehuxingming; }
    public String getLianxifangshi() { return lianxifangshi; }
    public void setLianxifangshi(String lianxifangshi) { this.lianxifangshi = lianxifangshi == null ? "" : lianxifangshi; }
    public String getFuwuleixing() { return fuwuleixing; }
    public void setFuwuleixing(String fuwuleixing) { this.fuwuleixing = fuwuleixing == null ? "" : fuwuleixing; }
    public String getFuwuzhuangtai() { return fuwuzhuangtai; }
    public void setFuwuzhuangtai(String fuwuzhuangtai) { this.fuwuzhuangtai = fuwuzhuangtai == null ? "" : fuwuzhuangtai; }
    public String getFuwuneirong() { return fuwuneirong; }
    public void setFuwuneirong(String fuwuneirong) { this.fuwuneirong = fuwuneirong == null ? "" : fuwuneirong; }
    public String getFuwuliuyan() { return fuwuliuyan; }
    public void setFuwuliuyan(String fuwuliuyan) { this.fuwuliuyan = fuwuliuyan == null ? "" : fuwuliuyan; }
    public String getTianjiaren() { return tianjiaren; }
    public void setTianjiaren(String tianjiaren) { this.tianjiaren = tianjiaren == null ? "" : tianjiaren; }
    public String getTianjiashijian() { return tianjiashijian; }
    public void setTianjiashijian(String tianjiashijian) { this.tianjiashijian = tianjiashijian == null ? "" : tianjiashijian; }
    @Override
    public Fuwu clone() {
        try {
            return (Fuwu) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Fuwu deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Fuwu) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
