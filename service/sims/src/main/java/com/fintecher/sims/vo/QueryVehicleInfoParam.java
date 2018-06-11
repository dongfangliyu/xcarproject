package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 库存-车辆管理-车辆信息多条件查询条件
 * @Date: Created on 2018/3/13 13:54
 * @Modified_By:
 */

@Data
public class QueryVehicleInfoParam {

    @ApiModelProperty(value = "车牌号码/车架号/发动机号")
    private String searchStr;

    @ApiModelProperty(value = "排序")
    private String sortStr;
}
