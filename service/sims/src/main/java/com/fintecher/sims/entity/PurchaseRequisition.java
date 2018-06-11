package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 采购需求
 * @Date: Created on 2018/3/15 17:37
 * @Modified_By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_purchase_requisition")
@ApiModel(description = "采购需求")
public class PurchaseRequisition extends BaseEntity {

    @ApiModelProperty(value = "门店ID(外键)")
    private Long companyId;

    @ApiModelProperty(value = "车辆品牌ID(外键)")
    private Long vehicleBrandId;

    @ApiModelProperty(value = "车辆系列ID(外键)")
    private Long vehicleSeriesId;

    @ApiModelProperty(value = "车辆型号ID(外键)")
    private Long vehicleModelId;

    @ApiModelProperty(value = "车辆颜色")
    private String color;

    @ApiModelProperty(value = "数量")
    private Integer number;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "申请人(外键)")
    private Long approver;

    @ApiModelProperty(value = "申请时间")
    private Date approveTime;

    @ApiModelProperty(value = "最后操作人(外键)")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    private Date updateTime;

}
