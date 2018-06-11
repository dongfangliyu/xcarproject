package com.fintecher.sims.service;

import com.fintecher.sims.entity.VehicleColor;

import java.util.List;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 16:13
 * @Modified By：
 */
public interface VehicleColorService extends BaseService<VehicleColor> {
    List<VehicleColor>  findColorByName(String name);
}
