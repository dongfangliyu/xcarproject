package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.AllocationRequest;
import com.fintecher.sims.util.MyMapper;
import com.fintecher.sims.vo.AllocationRequestModel;
import com.fintecher.sims.vo.VehicleDetailsModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/13 11:21
 * @Modified By:
 */

public interface AllocationRequestMapper extends MyMapper<AllocationRequest> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 多条件查询调拨申请
     * @Modified By:
     */
    List<AllocationRequestModel> getAllAllocationRequest(@Param("allocationOrderNumber") String allocationOrderNumber);

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 根据调拨申请查询车辆信息
     * @Modified By:
     */
    List<VehicleDetailsModel> getVehicleByAllocationId(@Param("id") Long id);
}
