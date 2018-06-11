package com.fintecher.common.vo.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
public class AppVersionParam implements Serializable{

    @ApiModelProperty(value = "操作系统")
    private String versAppos;

    @ApiModelProperty(value = "版本号")
    private String versNum;

    @ApiModelProperty(value = "发布开始时间戳")
    private Long pubDateStart;

    @ApiModelProperty(value = "发布结束时间戳")
    private Long pubDateEnd;

    @ApiModelProperty(value = "发布开始时间")
    private Date pubDateBegin;

    @ApiModelProperty(value = "发布结束时间")
    private Date pubDateOver;
}
