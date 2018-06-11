package com.fintecher.report.mapper;

import com.fintecher.common.vo.report.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @System: 车贷金融
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/1/9 11:27
 * @Modified By:
 */
public interface ReportMapper {
    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询全部机构清结算日报表
     * @Modified By:
     */
    List<SettlementReportModel> getSettlementReportAll(SettlementReportParam settlementReportParam);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询单个机构清结算日报表
     * @Modified By:
     */
    List<SettlementReportModel> getSettlementReportOne(SettlementReportParam settlementReportParam);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询还款渠道
     * @Modified By:
     */
    List<DataDictModel> getChannel();

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询某一个还款渠道
     * @Modified By:
     */
    DataDictModel getChannelById(@Param("id") Integer id);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 获取公司名称
     * @Modified By:
     */
    String getCompanyName(@Param("id") Long id);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询月还款报表
     * @Modified By:
     */
    List<RepaymentModel> getRepaymentReport(RepaymentParam repaymentParam);
}
