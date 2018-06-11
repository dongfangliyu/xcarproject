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
 * @Description: 库放车技术状态与措施记录
 * @Date: Created on 2018/3/15 11:04
 * @Modified_By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_measures_record")
@ApiModel(description = "库放车技术状态与措施记录")
public class MeasuresRecord extends BaseEntity {

    @ApiModelProperty(value = "车辆ID(外键)")
    private Long vehicleId;

    @ApiModelProperty(value = "里程表数")
    private Integer odometerNumber;

    @ApiModelProperty(value = "停放状态")
    private Long storageStatus;

    @ApiModelProperty(value = "措施内容")
    private String content;

    @ApiModelProperty(value = "情况描述")
    private String description;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建人(外键)")
    private Long operator;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

    @ApiModelProperty(value = "最后操作人(外键)")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    private Date updateTime;
}
