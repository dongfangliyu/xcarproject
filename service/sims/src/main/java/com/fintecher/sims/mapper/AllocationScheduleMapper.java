package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.AllocationSchedule;
import com.fintecher.sims.util.MyMapper;
import com.fintecher.sims.vo.AllocationScheduleModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/13 15:21
 * @Modified By:
 */

public interface AllocationScheduleMapper extends MyMapper<AllocationSchedule> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 查询调拨进度
     * @Modified By:
     */
    List<AllocationScheduleModel> getAllAllocationSchedule(@Param("id") Long id);
}
