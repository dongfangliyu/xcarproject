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
 * @Description: 车辆里程记录
 * @Date: Created on 2018/3/14 14:08
 * @Modified_By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "车辆里程记录")
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_vehicle_mileage_record")
public class VehicleMileageRecord extends BaseEntity {

    @ApiModelProperty(value = "车辆ID(外键)")
    private Long vehicleId;

    @ApiModelProperty(value = "操作类型(外键：数据字典)")
    private Long type;

    @ApiModelProperty(value = "出入类型(外键：数据字典)")
    private Long storageType;

    @ApiModelProperty(value = "对应单号")
    private String orderNumber;

    @ApiModelProperty(value = "里程数")
    private Integer odometerNumber;

    @ApiModelProperty(value = "仓库ID")
    private Long parkCompanyId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建人(外键)")
    private Long operator;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

}
