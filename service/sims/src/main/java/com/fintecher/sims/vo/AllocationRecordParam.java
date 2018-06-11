package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 调拨出入库参数
 * @Date: Created on 2018/3/15 10:07
 * @Modified By:
 */

@Data
public class AllocationRecordParam {
    @ApiModelProperty(value = "关键字")
    private String keyword;

    @ApiModelProperty(value = "是否包含已处理记录 0-不包含 1-包含")
    private Integer flag;
}
