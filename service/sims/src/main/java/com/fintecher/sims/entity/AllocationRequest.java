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
 * @Description: 调拨申请实体
 * @Date: Created on 2018/3/13 11:06
 * @Modified By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "调拨申请")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_allocation_request")
public class AllocationRequest extends BaseEntity {
    @ApiModelProperty(value = "调拨单号")
    @Column(name = "allocation_order_number")
    private String allocationOrderNumber;

    @ApiModelProperty(value = "调出门店ID")
    @Column(name = "out_company_id")
    private Long outCompanyId;

    @ApiModelProperty(value = "调入门店ID")
    @Column(name = "in_company_id")
    private Long inCompanyId;

    @ApiModelProperty(value = "物流方式")
    @Column(name = "logistics_type")
    private Long logisticsType;

    @ApiModelProperty(value = "申请人")
    @Column(name = "applicant")
    private Long applicant;

    @ApiModelProperty(value = "申请时间")
    @Column(name = "apply_time")
    private Date applyTime;

    @ApiModelProperty(value = "申请部门ID")
    @Column(name = "apply_department_id")
    private Long applyDepartmentId;

    @ApiModelProperty(value = "申请状态")
    @Column(name = "apply_status")
    private Long applyStatus;

    @ApiModelProperty(value = "调入部门处理状态")
    @Column(name = "in_handle_status")
    private Long inHandleStatus;

    @ApiModelProperty(value = "调入部门处理备注")
    @Column(name = "in_handle_remark")
    private String inHandleRemark;

    @ApiModelProperty(value = "调入部门处理人")
    @Column(name = "in_handler")
    private Long inHandler;

    @ApiModelProperty(value = "调入部门处理时间")
    @Column(name = "in_handle_time")
    private Date inHandleTime;

    @ApiModelProperty(value = "总部处理状态")
    @Column(name = "head_handle_status")
    private Long headHandleStatus;

    @ApiModelProperty(value = "总部处理备注")
    @Column(name = "head_handle_remark")
    private String headHandleRemark;

    @ApiModelProperty(value = "总部处理人")
    @Column(name = "head_handler")
    private Long headHandler;

    @ApiModelProperty(value = "总部处理时间")
    @Column(name = "head_handle_time")
    private Date headHandleTime;

    @ApiModelProperty(value = "调出部门处理状态")
    @Column(name = "out_handle_status")
    private Long outHandleStatus;

    @ApiModelProperty(value = "调出部门处理备注")
    @Column(name = "out_handle_remark")
    private String outHandleRemark;

    @ApiModelProperty(value = "调出部门处理人")
    @Column(name = "out_handler")
    private Long outHandler;

    @ApiModelProperty(value = "调出部门处理时间")
    @Column(name = "out_handle_time")
    private Date outHandleTime;

    @ApiModelProperty(value = "最后操作人")
    @Column(name = "updater")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    @Column(name = "update_time")
    private Date updateTime;
}
