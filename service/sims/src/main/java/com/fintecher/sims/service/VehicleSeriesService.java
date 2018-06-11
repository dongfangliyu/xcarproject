package com.fintecher.sims.service;

import com.fintecher.sims.entity.VehicleSeries;
import com.fintecher.sims.vo.UserModel;
import com.fintecher.sims.vo.VehicleSeriesModel;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/13
 * @Modified By：
 */
public interface VehicleSeriesService extends BaseService<VehicleSeries> {
    /**
     * @Auther: dwx
     * @Description:新增
     * @Modified By：
     */
    void addVehicleSeries(VehicleSeriesModel vehicleSeriesModel, UserModel user);
}
