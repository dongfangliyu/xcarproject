package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 调拨申请审批参数
 * @Date: Created on 2018/3/13 20:26
 * @Modified By:
 */

@Data
public class ApproveAllocationParam {
    @ApiModelProperty(value = "调拨申请ID")
    private Long id;

    @ApiModelProperty(value = "申请类型 0-调入方 1-总部 2-调出方")
    private Integer type;

    @ApiModelProperty(value = "审批结果")
    private Long approveResult;

    @ApiModelProperty(value = "审批备注")
    private String remark;
}
