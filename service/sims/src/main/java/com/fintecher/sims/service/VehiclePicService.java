package com.fintecher.sims.service;

import com.fintecher.sims.entity.VehiclePic;

import java.util.List;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 17:29
 * @Modified By：
 */
public interface VehiclePicService extends BaseService<VehiclePic> {
    /**
     * @System:
     * @Auther: dwx
     * @Description:query
     * @Modified By：
     */
    List<VehiclePic> findPicByModelId(Long id);
}
