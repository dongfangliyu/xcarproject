package com.fintecher.common.vo.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System: 车贷金融
 * @Auther: xiaqun
 * @Description: 数据字典模型
 * @Date: Created on 2018/1/11 13:47
 * @Modified By:
 */

@Data
public class DataDictModel {
    @ApiModelProperty(value = "主键ID", notes = "主键ID")
    private Integer id;

    @ApiModelProperty(value = "数据字典项code", notes = "数据字典项code")
    private String typeCode;

    @ApiModelProperty(value = "数据字典code", notes = "数据字典code")
    private String code;

    @ApiModelProperty(value = "数据字典名称", notes = "数据字典名称")
    private String name;

    @ApiModelProperty(value = "数据字典排序", notes = "数据字典排序")
    private Integer sort;
}
