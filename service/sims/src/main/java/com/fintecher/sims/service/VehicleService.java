package com.fintecher.sims.service;

import com.fintecher.sims.entity.Vehicle;
import com.fintecher.sims.vo.UserModel;
import com.fintecher.sims.vo.VehicleVoModel;

import java.util.List;


/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 车辆
 * @Date: Created on 2018/3/13 13:39
 * @Modified_By:
 */

public interface VehicleService extends BaseService<Vehicle> {
    /**
     * @System:
     * @Auther: dwx
     * @Description:新增车辆
     * @Modified By：
     */
   void listVehicle(VehicleVoModel vehicleVoModel, UserModel user) throws Exception;

   /**
    * @System:
    * @Auther: dwx
    * @Description:修改车辆
    * @Modified By：
    */
   void updateVehicle(VehicleVoModel vehicleVoModel,UserModel user) throws Exception;
}
