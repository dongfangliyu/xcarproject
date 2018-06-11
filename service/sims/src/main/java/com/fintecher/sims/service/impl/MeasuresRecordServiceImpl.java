package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.MeasuresRecord;
import com.fintecher.sims.entity.MeasuresRecordFile;
import com.fintecher.sims.service.MeasuresRecordFileService;
import com.fintecher.sims.service.MeasuresRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description:
 * @Date: Created on 2018/3/15 11:11
 * @Modified_By:
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class MeasuresRecordServiceImpl extends BaseServiceImpl<MeasuresRecord> implements MeasuresRecordService {


    @Autowired
    private MeasuresRecordFileService measuresRecordFileService;

    @Override
    public void saveMeasuresRecord(MeasuresRecord measuresRecord, List<MeasuresRecordFile> fileList) {
        save(measuresRecord);
        for (MeasuresRecordFile file : fileList) {
            file.setMeasuresId(measuresRecord.getId());
            measuresRecordFileService.save(file);
        }
    }
}
