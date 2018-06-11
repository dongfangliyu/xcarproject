package com.fintecher.sims.service;

import com.fintecher.sims.entity.AllocationSchedule;
import com.fintecher.sims.vo.AllocationScheduleModel;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/13 15:19
 * @Modified By:
 */

public interface AllocationScheduleService extends BaseService<AllocationSchedule> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 查询调拨进度
     * @Modified By:
     */
    List<AllocationScheduleModel> getAllAllocationSchedule(Long id) throws Exception;
}
