package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @System:
 * @Auther: dwx
 * @Description:数据字典项
 * @Date:Created on 2018/3/1413:46
 * @Modified By：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_data_dict")
@ApiModel(description = "数据字典项")
public class DataDict implements java.io.Serializable {
    /**
     * 主键id
     */
    @Id
    @ApiModelProperty(value = "主键ID")
    private Integer id;
    /**
     * 数据字典项code
     */
    @ApiModelProperty(value = "数据字典类别code")
    private String typeCode;
    /**
     * 数据字典code
     */
    @ApiModelProperty(value = "数据字典code")
    private String code;
    /**
     * 数据字典名称
     */
    @ApiModelProperty(value = "数据字典名称")
    private String name;
    /**
     * 数据字典排序
     */
    @ApiModelProperty(value = "数据字典排序")
    private Integer sort;

    @ApiModelProperty(value = "创建人")
    private Long operator;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

    @ApiModelProperty(value = "最后操作人")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    private Date updateTime;


}
