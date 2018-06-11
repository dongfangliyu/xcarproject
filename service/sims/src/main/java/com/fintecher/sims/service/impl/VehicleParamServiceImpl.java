package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.VehicleParam;
import com.fintecher.sims.service.VehicleParamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 15:42
 * @Modified By：
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class VehicleParamServiceImpl extends BaseServiceImpl<VehicleParam> implements VehicleParamService {
}
