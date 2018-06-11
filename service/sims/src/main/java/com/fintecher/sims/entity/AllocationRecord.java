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
 * @Description: 调拨出入库记录实体
 * @Date: Created on 2018/3/14 10:45
 * @Modified By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "调拨出入库记录")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_allocation_record")
public class AllocationRecord extends BaseEntity {
    @ApiModelProperty(value = "调拨申请ID")
    @Column(name = "allocation_order_id")
    private Long allocationOrderId;

    @ApiModelProperty(value = "车辆ID")
    @Column(name = "vehicle_id")
    private Long vehicleId;

    @ApiModelProperty(value = "出库类型")
    @Column(name = "type")
    private Long type;

    @ApiModelProperty(value = "情况描述")
    @Column(name = "description")
    private String description;

    @ApiModelProperty(value = "申请时间")
    @Column(name = "apply_time")
    private Date applyTime;

    @ApiModelProperty(value = "处理状态")
    @Column(name = "handle_status")
    private Long handleStatus;

    @ApiModelProperty(value = "处理人")
    @Column(name = "handler")
    private Long handler;

    @ApiModelProperty(value = "处理备注")
    @Column(name = "handle_remark")
    private String handleRemark;

    @ApiModelProperty(value = "处理时间")
    @Column(name = "handle_time")
    private Date handleTime;

    @ApiModelProperty(value = "调拨出入库时间")
    @Column(name = "storage_time")
    private Date storageTime;

    @ApiModelProperty(value = "最后操作人")
    @Column(name = "updater")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    @Column(name = "update_time")
    private Date updateTime;
}
