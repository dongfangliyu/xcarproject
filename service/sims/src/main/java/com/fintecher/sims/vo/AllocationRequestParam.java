package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 调拨申请保存参数
 * @Date: Created on 2018/3/13 14:55
 * @Modified By:
 */

@Data
public class AllocationRequestParam {
    @ApiModelProperty(value = "调拨申请ID")
    private Long id;

    @ApiModelProperty(value = "调入仓库ID")
    private Long inCompanyId;

    @ApiModelProperty(value = "调出仓库ID")
    private Long outCompanyId;

    @ApiModelProperty(value = "物流方式")
    private Long logisticsType;

    @ApiModelProperty(value = "车辆ID集合")
    private List<Long> vehicleIds;
}
