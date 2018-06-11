package com.fintecher.common.entity.message;

import com.fintecher.common.entity.file.UploadFile;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: jwdstef
 * @Description: 文件解压缩并上传成功消息
 * @Date 2017/12/06
 */
@Data
public class UnReduceFileMessage implements Serializable {
    private UploadFile uploadFile;
    private String path;
    private String batchNum;
    private String userId;
    private Integer total;
    private Integer current;
    private String companyCode;
}
