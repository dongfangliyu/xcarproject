package com.fintecher.common.entity.message;

import com.fintecher.common.entity.file.UploadFile;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: jwdstef
 * @Description: 文件上传完成消息
 * @Date 2017/12/11
 */
@Data
public class ImportFileUploadSuccessMessage implements Serializable {
    private UploadFile uploadFile;
    private String batchNum;
    private String userId;
    private String userName;
    private String companyCode;
    private String caseNumber;

}
