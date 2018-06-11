package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.Vehicle;
import com.fintecher.sims.service.VehicleService;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.UserModel;
import com.fintecher.sims.vo.VehicleVoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.GeneralSecurityException;
import java.util.Objects;


/**
 * @System: 进销存
 * @Auther: lijian
 * @Description:
 * @Date: Created on 2018/3/13 13:46
 * @Modified_By:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class VehicleServiceImpl extends BaseServiceImpl<Vehicle> implements VehicleService {
    @Autowired
    private VehicleService vehicleService;
    @Override
    public void listVehicle(VehicleVoModel vehicleVoModel, UserModel user) throws Exception{
        Vehicle vehicle =new Vehicle();
        vehicle.setColor(vehicleVoModel.getColor());
        vehicle.setOperateTime(ZWDateUtil.getNowDateTime());
        vehicle.setOperator(user.getId());
        vehicle.setVehicleModelId(vehicleVoModel.getModelId());
        vehicle.setFrameNumber(vehicleVoModel.getFrameNumber());
        vehicle.setManufacturerId(vehicleVoModel.getManufacturerId());
        vehicle.setVehicleSeriesId(vehicleVoModel.getSeriesId());
        vehicle.setVehicleBrandId(vehicleVoModel.getBrandId());
        vehicleService.save(vehicle);
    }
    @Override
    public void updateVehicle(VehicleVoModel vehicleVoModel,UserModel user) throws Exception{
        Vehicle vehicle = vehicleService.findById(vehicleVoModel.getId());
        if (Objects.isNull(vehicle.getId())){
            throw new GeneralSecurityException("此车辆不存在");
        }
        vehicle.setColor(vehicleVoModel.getColor());
        vehicle.setOperateTime(ZWDateUtil.getNowDateTime());
        vehicle.setOperator(user.getId());
        vehicle.setVehicleModelId(vehicleVoModel.getModelId());
        vehicle.setFrameNumber(vehicleVoModel.getFrameNumber());
        vehicle.setManufacturerId(vehicleVoModel.getManufacturerId());
        vehicle.setVehicleSeriesId(vehicleVoModel.getSeriesId());
        vehicle.setVehicleBrandId(vehicleVoModel.getBrandId());
        vehicleService.updateSelective(vehicle);

    }

}
