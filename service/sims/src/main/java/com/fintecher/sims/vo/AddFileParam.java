package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 保存附件model
 * @Date: Created on 2018/3/15 16:01
 * @Modified_By:
 */
@Data
public class AddFileParam {

    @ApiModelProperty(value = "文件ID(外键)")
    private String fileId;

    @ApiModelProperty(value = "文件类型(外键：数据字典)")
    private Long fileType;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件大小")
    private String fileSize;

    @ApiModelProperty(value = "上传时间")
    private Date operateTime;
}
