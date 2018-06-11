package com.fintecher.sims.service;

import com.fintecher.sims.entity.AllocationRequest;
import com.fintecher.sims.vo.*;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/13 11:18
 * @Modified By:
 */

public interface AllocationRequestService extends BaseService<AllocationRequest> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 多条件查询调拨申请
     * @Modified By:
     */
    List<AllocationRequestModel> getAllAllocationRequest(String allocationOrderNumber) throws Exception;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 申请调拨
     * @Modified By:
     */
    void allocationApply(AllocationRequestParam param, UserModel user) throws Exception;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 修改调拨申请
     * @Modified By:
     */
    void modifyAllocationApply(AllocationRequestParam param, UserModel user) throws Exception;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 根据调拨申请查询车辆信息
     * @Modified By:
     */
    List<VehicleDetailsModel> getVehicleByAllocationId(Long id) throws Exception;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 调拨申请审批
     * @Modified By:
     */
    void approveAllocation(ApproveAllocationParam param, UserModel user) throws Exception;
}
