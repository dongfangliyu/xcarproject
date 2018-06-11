package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.VehicleColor;
import com.fintecher.sims.mapper.VehicleColorMapper;
import com.fintecher.sims.service.VehicleColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 16:13
 * @Modified By：
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class VehicleColorServiceImpl extends BaseServiceImpl<VehicleColor> implements VehicleColorService {
    @Autowired
    private VehicleColorMapper vehicleColorMapper;
    @Override
    public List<VehicleColor> findColorByName(String name){
        return vehicleColorMapper.findColorByName(name);
    }

}
