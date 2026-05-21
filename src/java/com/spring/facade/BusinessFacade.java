package com.spring.facade;

import com.spring.command.CommandInvoker;
import com.spring.command.RentHouseCommand;
import com.spring.entity.*;
import com.spring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessFacade {
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private FangyuanxinxiService fangyuanxinxiService;

    @Autowired
    private ZulinService zulinService;

    @Autowired
    private CommandInvoker commandInvoker;

    @Autowired
    private RentHouseCommand rentHouseCommand;

    // 简化的租房流程 （包含用户存在性检查、房源存在性检查、状态更新、租赁记录保存等）
    /*
    * @param userId 用户ID
    * @param houseId 房源ID
    * @param startTime 开始时间
    * @param endTime 结束时间
    * @return 是否成功
    * */

    public boolean rentHouse(int userId, int houseId) {
        try {
            // 1. 检查用户是否存在
            Yonghu user = yonghuService.find(userId);
            if (user == null) {
                System.out.println("用户不存在");
                return false;
            }

            // 2. 检查房源是否存在且可用
            Fangyuanxinxi house = fangyuanxinxiService.find(houseId);
            if (house == null || !"空闲".equals(house.getFangyuanzhuangtai())) {
                System.out.println("房源不存在或不可用");
                return false;
            }

            // 3. 创建租赁记录
            // 使用命令模式执行租房操作
            rentHouseCommand.setTenant(user);
            rentHouseCommand.setHouse(house);

            // 4. 执行命令
            boolean success = commandInvoker.executeCommand(rentHouseCommand);
            if (!success) {
                System.out.println("命令执行失败");
                return false;
            }


            System.out.println("租房流程完成");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("租房流程失败");
            return false;
        }
    }
}