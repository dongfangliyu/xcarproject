package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.AllocationVehicle;
import com.fintecher.sims.service.AllocationVehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/13 11:43
 * @Modified By:
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class AllocationVehicleServiceImpl extends BaseServiceImpl<AllocationVehicle> implements AllocationVehicleService {
}
