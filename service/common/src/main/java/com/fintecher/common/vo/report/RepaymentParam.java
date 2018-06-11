package com.fintecher.common.vo.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System: 车贷金融
 * @Auther: xiaqun
 * @Description: 月还款报表参数
 * @Date: Created on 2018/1/12 15:34
 * @Modified By:
 */

@Data
public class RepaymentParam {
    @ApiModelProperty(notes = "统计机构")
    private String organization;

    @ApiModelProperty(notes = "统计通道")
    private Integer channel;
}
