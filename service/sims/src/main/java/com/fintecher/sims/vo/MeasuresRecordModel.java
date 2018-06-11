package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 查看库放车技术状态与措施记录model
 * @Date: Created on 2018/3/15 14:36
 * @Modified_By:
 */

@Data
public class MeasuresRecordModel {

    @ApiModelProperty(value = "主键ID")
    private Long id;

    @ApiModelProperty(value = "时间")
    private Date operateTime;

    @ApiModelProperty(value = "停放状态")
    private Long storageStatus;

    @ApiModelProperty(value = "里程表数")
    private Integer odometerNumber;

    @ApiModelProperty(value = "情况描述")
    private String description;

    @ApiModelProperty(value = "措施内容")
    private String content;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "附件")
    private Set<String> files;

}
