package com.fintecher.sims.service;

import com.fintecher.sims.entity.Manufacturer;

import java.util.List;


/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 汽车厂商
 * @Date: Created on 2018/3/13 20:22
 * @Modified_By:
 */

public interface ManufacturerService extends BaseService<Manufacturer> {
    /**
     * @System:
     * @Auther: dwx
     * @Description:根据名称模糊查询
     * @Modified By：
     */
    List<Manufacturer> findManufacturerByName(String name);
}
