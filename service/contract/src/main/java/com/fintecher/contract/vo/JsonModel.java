package com.fintecher.contract.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author wxc
 * @Data 2018/2/2 13:18
 * @Description
 */
@Data
public class JsonModel {

    @ApiModelProperty(value = "返回code ")
    private String code;

    @ApiModelProperty(value = "返回的结果集")
    private String info;

    @ApiModelProperty(value = "相关模板对应对象")
    private SuperModel superModel;

    @ApiModelProperty(value = "object")
    private Object object;
}
