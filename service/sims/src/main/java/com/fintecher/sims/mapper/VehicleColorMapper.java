package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.VehicleColor;
import com.fintecher.sims.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 16:15
 * @Modified By：
 */
public interface VehicleColorMapper extends MyMapper<VehicleColor> {
    List<VehicleColor> findColorByName(@Param("name") String name);
}
