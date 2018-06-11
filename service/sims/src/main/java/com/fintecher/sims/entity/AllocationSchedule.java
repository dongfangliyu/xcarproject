package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 调拨进度实体
 * @Date: Created on 2018/3/13 15:13
 * @Modified By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "调拨进度")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_allocation_schedule")
public class AllocationSchedule extends BaseEntity {
    @ApiModelProperty(value = "调拨申请ID")
    @Column(name = "allocation_request_id")
    private Long allocationRequestId;

    @ApiModelProperty(value = "事项")
    @Column(name = "item")
    private Long item;

    @ApiModelProperty(value = "备注")
    @Column(name = "remark")
    private String remark;

    @ApiModelProperty(value = "操作人")
    @Column(name = "operator")
    private Long operator;

    @ApiModelProperty(value = "操作时间")
    @Column(name = "operate_time")
    private Date operateTime;
}
