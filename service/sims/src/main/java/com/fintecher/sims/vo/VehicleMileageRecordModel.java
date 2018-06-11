package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 车辆里程model
 * @Date: Created on 2018/3/14 14:44
 * @Modified_By:
 */

@Data
public class VehicleMileageRecordModel {

    @ApiModelProperty(value = "操作类型(外键：数据字典)")
    private Long type;

    @ApiModelProperty(value = "出入类型(外键：数据字典)")
    private Long storageType;

    @ApiModelProperty(value = "对应单号")
    private String orderNumber;

    @ApiModelProperty(value = "里程数")
    private Integer odometerNumber;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

    @ApiModelProperty(value = "创建人")
    private String operator;

    @ApiModelProperty(value = "仓库ID")
    private String parkCompany;

}
