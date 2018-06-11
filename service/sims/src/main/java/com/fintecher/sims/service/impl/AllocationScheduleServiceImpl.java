package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.AllocationSchedule;
import com.fintecher.sims.mapper.AllocationScheduleMapper;
import com.fintecher.sims.service.AllocationScheduleService;
import com.fintecher.sims.vo.AllocationScheduleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/13 15:20
 * @Modified By:
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class AllocationScheduleServiceImpl extends BaseServiceImpl<AllocationSchedule> implements AllocationScheduleService {
    @Autowired
    private AllocationScheduleMapper allocationScheduleMapper;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 查询调拨进度
     * @Modified By:
     */
    @Override
    public List<AllocationScheduleModel> getAllAllocationSchedule(Long id) throws Exception {
        return allocationScheduleMapper.getAllAllocationSchedule(id);
    }
}
