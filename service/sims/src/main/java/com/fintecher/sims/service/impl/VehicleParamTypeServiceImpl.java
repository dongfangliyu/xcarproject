package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.VehicleModel;
import com.fintecher.sims.entity.VehicleParamType;
import com.fintecher.sims.mapper.VehicleParamTypeMapper;
import com.fintecher.sims.service.VehicleParamTypeService;
import com.fintecher.sims.vo.VehicleParamModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 10:40
 * @Modified By：
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class VehicleParamTypeServiceImpl extends BaseServiceImpl<VehicleParamType> implements VehicleParamTypeService {
    @Autowired
    private VehicleParamTypeMapper vehicleParamTypeMapper;
    @Override
    public List<VehicleParamModel> findByParamList(Long id){
        return vehicleParamTypeMapper.findByParamList(id);
    }

}
