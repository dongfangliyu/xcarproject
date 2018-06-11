package com.fintecher.common.vo.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @System: 车贷金融
 * @Auther: xiaqun
 * @Description: 清结算日报表查询参数
 * @Date: Created on 2018/1/9 11:57
 * @Modified By:
 */

@Data
public class SettlementReportParam {
    @ApiModelProperty(notes = "统计公司ID")
    private Long companyId;

    @ApiModelProperty(notes = "统计通道")
    private Integer channel;

    @ApiModelProperty(notes = "时间纬度")
    private Integer timeLatitude;

    @ApiModelProperty(notes = "最小结算时间")
    private String minSettlementDate;

    @ApiModelProperty(notes = "最大结算时间")
    private String maxSettlementDate;

    /**
     * 时间纬度枚举类
     */
    public enum TimeLatitude {
        YESTERDAY(0, "昨日"),
        TODAY(1, "今日"),
        THIS_WEEK(2, "本周"),
        THIS_MONTH(3, "本月"),
        LAST_WEEK(4, "上月"),
        NEAR_THREE_MONTH(5, "最近三月"),
        THIS_QUARTER(6, "本季度"),
        THIS_YEAR(7, "本年");
        private Integer value;
        private String remark;

        TimeLatitude(Integer value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Integer getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }
}
