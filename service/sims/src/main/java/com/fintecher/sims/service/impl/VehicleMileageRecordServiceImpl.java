package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.VehicleMileageRecord;
import com.fintecher.sims.service.VehicleMileageRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 车辆里程记录
 * @Date: Created on 2018/3/14 14:17
 * @Modified_By:
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class VehicleMileageRecordServiceImpl extends BaseServiceImpl<VehicleMileageRecord> implements VehicleMileageRecordService {
}
