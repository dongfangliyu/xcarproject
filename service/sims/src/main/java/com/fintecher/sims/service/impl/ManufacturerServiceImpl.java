package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.Manufacturer;
import com.fintecher.sims.mapper.ManufacturerMapper;
import com.fintecher.sims.service.ManufacturerService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description:
 * @Date: Created on 2018/3/13 20:23
 * @Modified_By:
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class ManufacturerServiceImpl extends BaseServiceImpl<Manufacturer> implements ManufacturerService {
    @Autowired
    private ManufacturerMapper manufacturerMapper;
    @Override
    public  List<Manufacturer> findManufacturerByName(String name){
        return manufacturerMapper.findManufacturerByName(name);
    }
}
