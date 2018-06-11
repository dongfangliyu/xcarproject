package com.fintecher.file.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: jwdstef
 * @Description: 解压文件
 * @Date 2017/12/4
 */
@Data
public class UnZipCaseFileRequest {
    @ApiModelProperty("批次号")
    private String batchNum;
    @ApiModelProperty("文件ID")
    private String uploadFile;
    @ApiModelProperty("公司Code")
    private String companyCode;
}
