package com.spring.adapter;
import com.spring.entity.Yonghu;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
/**
 * 用户数据适配器，实现用户数据转换接口
 */
@Component
public class UserDataAdapter implements UserDataConverter {
    @Override
    public Map<String, Object> convertToMap(Yonghu user) {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", user.getId());
        map.put("username", user.getYonghuming());
        map.put("realName", user.getXingming());
        map.put("phone", user.getShoujihao());
        map.put("role", user.getCx());

        return map;
    }

    @Override
    public Yonghu convertFromMap(Map<String, Object> map) {
        Yonghu user = new Yonghu();
        user.setId((Integer) map.get("userId"));
        user.setYonghuming((String) map.get("username"));
        user.setXingming((String) map.get("realName"));
        user.setShoujihao((String) map.get("phone"));
        user.setCx((String) map.get("role"));
        return user;
    }
}