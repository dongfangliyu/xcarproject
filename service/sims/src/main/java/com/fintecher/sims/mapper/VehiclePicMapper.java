package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.VehiclePic;
import com.fintecher.sims.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 17:43
 * @Modified By：
 */
public interface VehiclePicMapper extends MyMapper<VehiclePic> {
    List<VehiclePic> findPicByModelId(@Param("id") Long id);
}
