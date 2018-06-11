package com.fintecher.sims.vo;

import com.netflix.eureka.V1AwareInstanceInfoConverter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 调拨进度模型
 * @Date: Created on 2018/3/13 17:43
 * @Modified By:
 */

@Data
public class AllocationScheduleModel {
    @ApiModelProperty(value = "时间")
    private Date time;

    @ApiModelProperty(value = "事项")
    private Long item;

    @ApiModelProperty(value = "操作人")
    private String operatorName;
}
