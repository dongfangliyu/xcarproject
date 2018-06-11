package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/20 11:14
 * @Modified By：
 */
@Data
public class VehiclePicModel {
    @ApiModelProperty(value = "型号id")
    private Long modelId;
    @ApiModelProperty(value = "文件id")
    private String fileId;
    @ApiModelProperty(value = "文件名称")
    private String fileName;
    @ApiModelProperty(value = "文件类型")
    private Long fileType;

}
