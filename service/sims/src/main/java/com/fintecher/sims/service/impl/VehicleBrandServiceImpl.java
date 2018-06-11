package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.VehicleBrand;
import com.fintecher.sims.service.VehicleBrandService;
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
public class VehicleBrandServiceImpl extends BaseServiceImpl<VehicleBrand> implements VehicleBrandService {
}
