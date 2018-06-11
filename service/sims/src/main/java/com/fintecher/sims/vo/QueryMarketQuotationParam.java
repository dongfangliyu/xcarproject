package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 查询市场行情参数
 * @Date: Created on 2018/3/15 16:33
 * @Modified_By:
 */

@Data
public class QueryMarketQuotationParam {

    @ApiModelProperty(value = "供应商ID")
    private Long supplierId;

    @ApiModelProperty(value = "品牌/车系/型号")
    private String searchStr;

    @ApiModelProperty(value = "最小填报时间")
    private Date minCreateTime;

    @ApiModelProperty(value = "最大填报时间")
    private Date maxCreateTime;


}
