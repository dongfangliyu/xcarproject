package com.fintecher.sims.service;

import com.fintecher.sims.entity.AllocationRecord;
import com.fintecher.sims.vo.*;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/14 11:03
 * @Modified By:
 */

public interface AllocationRecordService extends BaseService<AllocationRecord> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 多条件查询调拨出库记录
     * @Modified By:
     */
    List<AllocationRecordModel> getOutAllocationRecord(AllocationRecordParam param) throws Exception;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 调拨出库
     * @Modified By:
     */
    void allocationOut(AllocationRecordOutParam param, UserModel user) throws Exception;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 多条件查询调拨入库记录
     * @Modified By:
     */
    List<AllocationRecordModel> getInAllocationRecord(AllocationRecordParam param) throws Exception;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 调拨入库
     * @Modified By:
     */
    void allocationIn(AllocationRecordInParam param, UserModel user) throws Exception;
}
