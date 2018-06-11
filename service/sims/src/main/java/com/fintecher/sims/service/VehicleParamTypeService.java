package com.fintecher.sims.service;

import com.fintecher.sims.entity.VehicleModel;
import com.fintecher.sims.entity.VehicleParamType;
import com.fintecher.sims.vo.VehicleParamModel;

import java.util.List;
import java.util.Map;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 10:39
 * @Modified By：
 */
public interface VehicleParamTypeService extends BaseService<VehicleParamType> {
    /**
     * @System:
     * @Auther: dwx
     * @Description:查询
     * @Modified By：
     */
    List<VehicleParamModel> findByParamList(Long id);

}
