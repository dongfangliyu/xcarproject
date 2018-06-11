package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description:
 * @Date: Created on 2018/3/15 15:45
 * @Modified_By:
 */

@Data
public class AddMeasuresRecordParam {

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

    @ApiModelProperty(value = "里程表数")
    private Integer odometerNumber;

    @ApiModelProperty(value = "停放状态")
    private Long storageStatus;

    @ApiModelProperty(value = "措施内容")
    private String content;

    @ApiModelProperty(value = "情况描述")
    private String description;

    @ApiModelProperty(value = "附件")
    private Set<AddFileParam> fileModelSet;

}
