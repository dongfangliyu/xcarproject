package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.Vehicle;
import com.fintecher.sims.util.MyMapper;
import com.fintecher.sims.vo.*;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description:
 * @Date: Created on 2018/3/13 13:48
 * @Modified_By:
 */

public interface VehicleMapper extends MyMapper<Vehicle> {

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 车辆信息多条件查询
     * @Date: Created on 2018/3/14 15:05
     * @Modified_By:
     */

    List<QueryVehicleInfoModel> queryVehicleInfo(QueryVehicleInfoParam queryVehicleInfoParam);

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 查询车辆基本信息
     * @Date: Created on 2018/3/14 15:05
     * @Modified_By:
     */

    VehicleBaseInfo getBaseVehicleInfo(Long id);

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 查询库放车辆
     * @Date: Created on 2018/3/15 9:57
     * @Modified_By:
     */
    List<QueryVehicleStockModel> queryVehicleStock(QueryVehicleStockParam queryVehicleStockParam);
}
