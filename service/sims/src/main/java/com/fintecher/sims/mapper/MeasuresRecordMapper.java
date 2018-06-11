package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.MeasuresRecord;
import com.fintecher.sims.util.MyMapper;
import com.fintecher.sims.vo.MeasuresRecordModel;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 库放车技术状态与措施记录
 * @Date: Created on 2018/3/15 12:01
 * @Modified_By:
 */

public interface MeasuresRecordMapper extends MyMapper<MeasuresRecord> {

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 查询库放车技术状态与措施记录
     * @Date: Created on 2018/3/15 15:25
     * @Modified_By:
     */

    List<MeasuresRecordModel> queryMeasuresRecord(Long vehiId);
}
