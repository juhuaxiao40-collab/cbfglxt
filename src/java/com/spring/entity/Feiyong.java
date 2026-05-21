package com.spring.entity;

import java.io.*;

public class Feiyong implements Serializable, Cloneable  {

    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer zulinid;
    private String fangyuanleixing;
    private String feiyongbianhao;
    private String kehuxingming;
    private String kehu;
    private String iszf;
    private String feiyongleixing;
    private String feiyongjine;
    private String qishiriqi;
    private String jiezhiriqi;
    private String beizhu;
    private String tianjiashijian;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getZulinid() { return zulinid; }
    public void setZulinid(Integer zulinid) { this.zulinid = zulinid; }
    public String getFangyuanleixing() { return fangyuanleixing; }
    public void setFangyuanleixing(String fangyuanleixing) { this.fangyuanleixing = fangyuanleixing == null ? "" : fangyuanleixing; }
    public String getFeiyongbianhao() { return feiyongbianhao; }
    public void setFeiyongbianhao(String feiyongbianhao) { this.feiyongbianhao = feiyongbianhao == null ? "" : feiyongbianhao; }
    public String getKehuxingming() { return kehuxingming; }
    public void setKehuxingming(String kehuxingming) { this.kehuxingming = kehuxingming == null ? "" : kehuxingming; }
    public String getKehu() { return kehu; }
    public void setKehu(String kehu) { this.kehu = kehu == null ? "" : kehu; }
    public String getIszf() { return iszf; }
    public void setIszf(String iszf) { this.iszf = iszf == null ? "" : iszf; }
    public String getFeiyongleixing() { return feiyongleixing; }
    public void setFeiyongleixing(String feiyongleixing) { this.feiyongleixing = feiyongleixing == null ? "" : feiyongleixing; }
    public String getFeiyongjine() { return feiyongjine; }
    public void setFeiyongjine(String feiyongjine) { this.feiyongjine = feiyongjine == null || feiyongjine=="" ? "0.00" : feiyongjine; }
    public String getQishiriqi() { return qishiriqi; }
    public void setQishiriqi(String qishiriqi) { this.qishiriqi = qishiriqi == null ? "" : qishiriqi; }
    public String getJiezhiriqi() { return jiezhiriqi; }
    public void setJiezhiriqi(String jiezhiriqi) { this.jiezhiriqi = jiezhiriqi == null ? "" : jiezhiriqi; }
    public String getBeizhu() { return beizhu; }
    public void setBeizhu(String beizhu) { this.beizhu = beizhu == null ? "" : beizhu; }
    public String getTianjiashijian() { return tianjiashijian; }
    public void setTianjiashijian(String tianjiashijian) { this.tianjiashijian = tianjiashijian == null ? "" : tianjiashijian; }
    @Override
    public Feiyong clone() {
        try {
            return (Feiyong) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Feiyong deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Feiyong) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}