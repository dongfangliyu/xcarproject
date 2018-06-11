package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.VehicleModel;
import com.fintecher.sims.entity.VehicleParamType;
import com.fintecher.sims.util.MyMapper;
import com.fintecher.sims.vo.VehicleParamModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 11:11
 * @Modified By：
 */
public interface VehicleParamTypeMapper extends MyMapper<VehicleParamType>{

    List<VehicleParamModel> findByParamList(@Param("id")Long id);
}
