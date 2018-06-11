package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.Manufacturer;
import com.fintecher.sims.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description:
 * @Date: Created on 2018/3/13 20:24
 * @Modified_By:
 */

public interface ManufacturerMapper extends MyMapper<Manufacturer> {
    /**
     * @System:
     * @Auther: dwx
     * @Description:通过汽车厂商
     * @Modified By：
     */
    List<Manufacturer> findManufacturerByName(@Param("name") String name);
}
