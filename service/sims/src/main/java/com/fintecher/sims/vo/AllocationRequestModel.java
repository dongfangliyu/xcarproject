package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 调拨申请模型
 * @Date: Created on 2018/3/13 13:38
 * @Modified By:
 */

@Data
public class AllocationRequestModel {
    @ApiModelProperty(value = "调拨申请ID")
    private Long id;

    @ApiModelProperty(value = "调拨单号")
    private String allocationOrderNumber;

    @ApiModelProperty(value = "申请日期")
    private Date applyTime;

    @ApiModelProperty(value = "当前状态")
    private Integer applyStatus;

    @ApiModelProperty(value = "调入门店")
    private String inCompanyName;

    @ApiModelProperty(value = "调出门店")
    private String outCompanyName;

    @ApiModelProperty(value = "申请人")
    private String applicantName;

    @ApiModelProperty(value = "申请部门")
    private String applyDepartment;

    @ApiModelProperty(value = "物流方式")
    private Integer logisticsType;
}
