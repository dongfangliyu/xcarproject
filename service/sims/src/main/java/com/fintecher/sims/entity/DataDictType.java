package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/1414:07
 * @Modified By：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_data_dict_type")
@ApiModel(description = "数据字典项类别")
public class DataDictType implements java.io.Serializable {

    /**
     * 主键id
     */
    @Id
    @ApiModelProperty(value = "主键ID")
    private Integer id;
    /**
     * 数据字典项code
     */
    @ApiModelProperty(value = "数据字典项code")
    private String code;
    /**
     * 数据字典项名称
     */
    @ApiModelProperty(value = "数据字典项名称")
    private String name;
    /**
     * 数据字典项类型  0 业务类型  1 非业务类型
     */
    @ApiModelProperty(value = "数据字典状态")
    private Integer type;

    @ApiModelProperty(value = "创建人")
    private Long operator;

    @ApiModelProperty(value = "创建时间")
    private Date operateTime;

    @ApiModelProperty(value = "最后操作人")
    private Long updater;

    @ApiModelProperty(value = "最后操作时间")
    private Date updateTime;
}
