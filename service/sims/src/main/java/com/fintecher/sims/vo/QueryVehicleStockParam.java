package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 库放车辆分页搜索条件
 * @Date: Created on 2018/3/15 9:53
 * @Modified_By:
 */

@Data
public class QueryVehicleStockParam {

    @ApiModelProperty(value = "车牌号码/车架号/发动机号")
    private String searchStr;

    @ApiModelProperty(value = "仅查看库放车辆")
    private Integer storage;

    @ApiModelProperty(value = "状态")
    private Long status;

}
