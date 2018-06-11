package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.MeasuresRecordFile;
import com.fintecher.sims.service.MeasuresRecordFileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 库放车技术状态与措施记录附件
 * @Date: Created on 2018/3/15 15:36
 * @Modified_By:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MeasuresRecordFileServiceImpl extends BaseServiceImpl<MeasuresRecordFile> implements MeasuresRecordFileService {
}
