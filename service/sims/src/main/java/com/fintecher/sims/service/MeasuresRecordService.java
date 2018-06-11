package com.fintecher.sims.service;

import com.fintecher.sims.entity.MeasuresRecord;
import com.fintecher.sims.entity.MeasuresRecordFile;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 库放车技术状态与措施记录
 * @Date: Created on 2018/3/15 11:07
 * @Modified_By:
 */

public interface MeasuresRecordService extends BaseService<MeasuresRecord> {


    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 新增库放车技术状态与措施记录
     * @Date: Created on 2018/3/15 16:11
     * @Modified_By:
     */
    void saveMeasuresRecord(MeasuresRecord measuresRecord, List<MeasuresRecordFile> fileList);
}
