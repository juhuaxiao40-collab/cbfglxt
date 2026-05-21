package com.spring.config;

public class Configure {
    // 私有静态实例，懒汉式加载
    private static volatile Configure instance;
    
    // 上传路径配置
    private String uploadDir;
    
    // 数据库连接配置
    private String dbUrl;
    private String dbUsername;
    private String dbPassword;
    
    // 私有构造函数，防止外部实例化
    private Configure() {
        // 初始化默认配置
        this.uploadDir = "/upload/";
    }
    
    // 全局访问点，双重检查锁定
    public static Configure getInstance() {
        if (instance == null) {
            synchronized (Configure.class) {
                if (instance == null) {
                    instance = new Configure();
                }
            }
        }
        return instance;
    }
    
    // getter和setter方法
    public String getUploadDir() {
        return uploadDir;
    }
    
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
    
    public String getDbUrl() {
        return dbUrl;
    }
    
    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }
    
    public String getDbUsername() {
        return dbUsername;
    }
    
    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }
    
    public String getDbPassword() {
        return dbPassword;
    }
    
    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }
}