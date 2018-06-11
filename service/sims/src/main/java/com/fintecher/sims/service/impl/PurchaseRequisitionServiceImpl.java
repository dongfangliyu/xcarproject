package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.PurchaseRequisition;
import com.fintecher.sims.entity.VehicleBrand;
import com.fintecher.sims.entity.VehicleModel;
import com.fintecher.sims.entity.VehicleSeries;
import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.service.PurchaseRequisitionService;
import com.fintecher.sims.service.VehicleBrandService;
import com.fintecher.sims.service.VehicleModelService;
import com.fintecher.sims.service.VehicleSeriesService;
import com.fintecher.sims.util.BeanUtil;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.PurchaseRequisitionParam;
import com.fintecher.sims.vo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 采购需求
 * @Date: Created on 2018/3/15 17:42
 * @Modified_By:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PurchaseRequisitionServiceImpl extends BaseServiceImpl<PurchaseRequisition> implements PurchaseRequisitionService {
    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleSeriesService vehicleSeriesService;

    @Autowired
    private VehicleBrandService vehicleBrandService;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 门店需求填报
     * @Modified By:
     */
    @Override
    public void createPurchaseRequisition(PurchaseRequisitionParam param, UserModel user) throws Exception {
        VehicleModel vehicleModel = vehicleModelService.findById(param.getVehicleModelId());
        if (Objects.isNull(vehicleModel)) {
            throw new GeneralException("车辆型号信息不存在");
        }
        VehicleSeries vehicleSeries = vehicleSeriesService.findById(vehicleModel.getVehicleSeriesId());
        if (Objects.isNull(vehicleSeries)) {
            throw new GeneralException("车辆系列信息不存在");
        }
        VehicleBrand vehicleBrand = vehicleBrandService.findById(vehicleSeries.getVehicleBrandId());
        if (Objects.isNull(vehicleBrand)) {
            throw new GeneralException("车辆品牌信息不存在");
        }
        PurchaseRequisition purchaseRequisition = new PurchaseRequisition();
        BeanUtil.copyPropertiesIgnoreNull(param, purchaseRequisition);
        purchaseRequisition.setVehicleSeriesId(vehicleSeries.getId()); //车辆系列ID
        purchaseRequisition.setVehicleBrandId(vehicleBrand.getId()); //车辆品牌ID
        purchaseRequisition.setApprover(user.getId()); //申请人
        purchaseRequisition.setApproveTime(ZWDateUtil.getNowDateTime()); //申请时间
        purchaseRequisition.setUpdater(user.getId()); //最后操作人
        purchaseRequisition.setUpdateTime(ZWDateUtil.getNowDateTime()); //最后操作时间
        save(purchaseRequisition);
    }
}
