package com.spring.adapter;
import com.spring.entity.Yonghu;
import java.util.HashMap;
import java.util.Map;

public interface UserDataConverter {
    Map<String, Object> convertToMap(Yonghu user);
    Yonghu convertFromMap(Map<String, Object> map);
}