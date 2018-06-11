package com.fintecher.common.vo.manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel
@Data
public class AppVersionVo implements Serializable{
    @ApiModelProperty(value = "版本号")
    private String versNum;

    @ApiModelProperty(value = "app操作系统")
    private List<String> versAppos;

    @ApiModelProperty(value = "文件地址")
    private String versFileUrl;

    @ApiModelProperty(value = "文件大小(B)")
    private Integer versSize;

    @ApiModelProperty(value = "是否静默安装,0否,1是")
    private Boolean versSlieInst;

    @ApiModelProperty(value = "更新类型,0整包更新,1应用内")
    private Boolean versInstType;

    @ApiModelProperty(value = "备注")
    private String versRemark;
}
