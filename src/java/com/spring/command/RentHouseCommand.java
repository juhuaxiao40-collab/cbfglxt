package com.spring.command;

import com.spring.entity.Fangyuanxinxi;
import com.spring.entity.Feiyong;
import com.spring.entity.Yonghu;
import com.spring.entity.Zulin;
import com.spring.service.FeiyongService;
import com.spring.service.ZulinService;
import com.spring.util.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentHouseCommand implements RentalCommand {

    private Fangyuanxinxi house;
    private Yonghu tenant;
    private ZulinService zulinService;
    private Zulin createdZulin;




    // 构造函数注入ZulinService
    @Autowired
    public RentHouseCommand(ZulinService zulinService) {
        this.zulinService = zulinService;
    }
    /**
     * 设置要出租的房源
     * @param house 房源对象
     */
    public void setHouse(Fangyuanxinxi house) {
        this.house = house;

    }

    /**
     * 设置要出租的租户
     * @param tenant 租户对象
     */
    public void setTenant(Yonghu tenant) {
        this.tenant = tenant;
    }



    @Override
    public boolean execute() {
        if (house == null || tenant == null) {
            return false;
        }

        // 创建租房记录
        createdZulin = new Zulin();
        createdZulin.setFangyuanxinxiid(house.getId());
        createdZulin.setFangyuanbianhao(house.getFangyuanbianhao());
        createdZulin.setFangyuanleixing(house.getFangyuanleixing());
        createdZulin.setJichuzujin(house.getJichuzujin());
        createdZulin.setIszf("否");
        createdZulin.setZulinbianhao(Info.getID());
        createdZulin.setKehuxingming(tenant.getXingming());
        createdZulin.setLianxifangshi(tenant.getShoujihao());
        createdZulin.setZhuangtai("待支付");
        createdZulin.setKehu(tenant.getYonghuming());
        createdZulin.setBeizhu("");
        createdZulin.setZulinriqi(Info.getDateStr());



        //创建租房记录
        try {
            zulinService.insert(createdZulin);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void undo() {
        if (createdZulin != null) {
            try {
                zulinService.delete(createdZulin.getId());
                createdZulin = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getCommandName() {
        return "租房命令";
    }
}