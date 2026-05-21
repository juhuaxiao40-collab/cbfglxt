package com.spring.proxy;

import com.spring.service.YonghuService;
import com.spring.entity.Yonghu;
import com.spring.util.SelectExample;

import java.util.Collections;
import java.util.List;


// 代理模式实现用户服务代理
public class YonghuServiceProxy implements YonghuService {
    private YonghuService target;

    public YonghuServiceProxy(YonghuService target) {
        this.target = target;
    }

    @Override
    public Yonghu login(String username, String password) {
        System.out.println("调用YonghuService.login()方法，参数：username=" + username);
        Yonghu result = target.login(username, password);
        System.out.println("YonghuService.login()方法执行完成，结果：" + (result != null ? "登录成功" : "登录失败"));
        return result;
    }

    @Override
    public boolean updatePassword(int id, String newPassword) {
        return false;
    }


    @Override
    public Integer count(SelectExample map) {
        System.out.println("调用YonghuService.count()方法");
        return target.count(map);
    }

    @Override
    public List<Yonghu> selectPage(SelectExample example, int page, int pageSize) {
        return Collections.emptyList();
    }

    @Override
    public List<Yonghu> selectAll(SelectExample example) {
        System.out.println("调用YonghuService.selectAll()方法");
        return target.selectAll(example);
    }

    @Override
    public int delete(Object id) {
        System.out.println("调用YonghuService.delete()方法，参数：id=" + id);
        return target.delete(id);
    }


    @Override
    public Yonghu find(Object id) {
        System.out.println("调用YonghuService.find()方法，参数：id=" + id);
        Yonghu result = target.find(id);
        System.out.println("YonghuService.find()方法执行完成，结果：" + (result != null ? "找到用户" : "未找到用户"));
        return result;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        System.out.println("调用YonghuService.checkLogin()方法，参数：username=" + username);
        boolean result = target.checkLogin(username, password);
        System.out.println("YonghuService.checkLogin()方法执行完成，结果：" + (result ? "登录成功" : "登录失败"));
        return result;
    }

    @Override
    public int insert(Yonghu pojo) {

        System.out.println("调用YonghuService.insert()方法，参数：pojo=" + pojo);
        int result = target.insert(pojo);
        System.out.println("YonghuService.insert()方法执行完成，结果：" + result);
        return result;
   }

    @Override
    public int update(Yonghu pojo) {

        System.out.println("调用YonghuService.update()方法，参数：pojo=" + pojo);
        int result = target.update(pojo);
        System.out.println("YonghuService.update()方法执行完成，结果：" + result);
        return result;
    }

}