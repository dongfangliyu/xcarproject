package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.AllocationRecord;
import com.fintecher.sims.util.MyMapper;
import com.fintecher.sims.vo.AllocationRecordModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/14 11:04
 * @Modified By:
 */

public interface AllocationRecordMapper extends MyMapper<AllocationRecord> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 多条件查询调拨出库记录
     * @Modified By:
     */
    List<AllocationRecordModel> getAllAllocationRecord(@Param("keyword") String keyword,
                                                       @Param("flag") String flag,
                                                       @Param("type") String type);
}
