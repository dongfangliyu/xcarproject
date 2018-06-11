package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.VehicleModel;
import com.fintecher.sims.service.VehicleModelService;
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
public class VehicleModelServiceImpl extends BaseServiceImpl<VehicleModel> implements VehicleModelService {
}
