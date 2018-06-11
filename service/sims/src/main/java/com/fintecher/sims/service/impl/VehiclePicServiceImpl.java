package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.VehiclePic;
import com.fintecher.sims.mapper.VehiclePicMapper;
import com.fintecher.sims.service.VehiclePicService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 17:29
 * @Modified By：
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class VehiclePicServiceImpl extends BaseServiceImpl<VehiclePic> implements VehiclePicService {
    @Autowired
    private VehiclePicMapper vehiclePicMapper;

    @Override
    public List<VehiclePic> findPicByModelId(Long id){
        return vehiclePicMapper.findPicByModelId(id);
    }
}
