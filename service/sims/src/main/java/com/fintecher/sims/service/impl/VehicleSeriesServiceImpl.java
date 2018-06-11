package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.VehicleSeries;
import com.fintecher.sims.service.VehicleSeriesService;
import com.fintecher.sims.vo.UserModel;
import com.fintecher.sims.vo.VehicleSeriesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/13
 * @Modified By：
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class VehicleSeriesServiceImpl extends BaseServiceImpl<VehicleSeries> implements VehicleSeriesService {
    @Autowired
    private VehicleSeriesService vehicleSeriesService;
    /**
     * @Auther: dwx
     * @Description:新增
     * @Modified By：
     */
    @Override
    public void addVehicleSeries(VehicleSeriesModel vehicleSeriesModel, UserModel user){
        VehicleSeries vehicleSeries1 = new VehicleSeries();
        vehicleSeries1.setModels(vehicleSeriesModel.getModels());
        vehicleSeries1.setVehicleBrandId(vehicleSeriesModel.getBrandId());
        vehicleSeries1.setName(vehicleSeriesModel.getSeriesName());
       vehicleSeriesService.save(vehicleSeries1);
    }
}
