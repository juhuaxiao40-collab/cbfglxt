package com.spring.entity;

import java.io.*;

public class Yonghu implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String cx;
    private String yonghuming;
    private String mima;
    private String xingming;
    private String xingbie;
    private String shoujihao;
    private String touxiang;
    private String youxiang;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCx() { return cx; }
    public void setCx(String cx) { this.cx = cx == null ? "" : cx; }
    public String getYonghuming() { return yonghuming; }
    public void setYonghuming(String yonghuming) { this.yonghuming = yonghuming == null ? "" : yonghuming; }
    public String getMima() { return mima; }
    public void setMima(String mima) { this.mima = mima == null ? "" : mima; }
    public String getXingming() { return xingming; }
    public void setXingming(String xingming) { this.xingming = xingming == null ? "" : xingming; }
    public String getXingbie() { return xingbie; }
    public void setXingbie(String xingbie) { this.xingbie = xingbie == null ? "" : xingbie; }
    public String getShoujihao() { return shoujihao; }
    public void setShoujihao(String shoujihao) { this.shoujihao = shoujihao == null ? "" : shoujihao; }
    public String getTouxiang() { return touxiang; }
    public void setTouxiang(String touxiang) { this.touxiang = touxiang == null ? "" : touxiang; }
    public String getYouxiang() { return youxiang; }
    public void setYouxiang(String youxiang) { this.youxiang = youxiang == null ? "" : youxiang; }

    @Override
    public Yonghu clone() {
        try {
            return (Yonghu) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Yonghu deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Yonghu) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }}
