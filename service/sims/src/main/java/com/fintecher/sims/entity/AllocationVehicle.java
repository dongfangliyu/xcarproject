package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 调拨申请车辆中间表
 * @Date: Created on 2018/3/13 11:40
 * @Modified By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "调拨申请车辆中间表")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_allocation_vehicle")
public class AllocationVehicle extends BaseEntity {
    @ApiModelProperty(value = "调拨申请ID")
    @Column(name = "allocation_request_id")
    private Long allocationRequestId;

    @ApiModelProperty(value = "车辆ID")
    @Column(name = "vehicle_id")
    private Long vehicleId;
}
