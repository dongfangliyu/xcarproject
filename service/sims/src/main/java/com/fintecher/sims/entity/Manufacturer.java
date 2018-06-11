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
 * @Description:
 * @Date: Created on 2018/3/13 20:17
 * @Modified_By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_manufacturer")
@ApiModel(description = "汽车厂商")
public class Manufacturer extends BaseEntity {

    @ApiModelProperty(value = "厂商名称")
    private String name;

    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;

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
