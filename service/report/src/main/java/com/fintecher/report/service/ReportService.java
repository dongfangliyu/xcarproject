package com.fintecher.report.service;

import com.fintecher.common.vo.report.RepaymentModel;
import com.fintecher.common.vo.report.RepaymentParam;
import com.fintecher.common.vo.report.SettlementReportModel;
import com.fintecher.common.vo.report.SettlementReportParam;

import java.io.IOException;
import java.util.List;

/**
 * @System: 车贷金融
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/1/9 9:33
 * @Modified By:
 */
public interface ReportService {
    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询清结算日报表
     * @Modified By:
     */
    List<SettlementReportModel> getSettlementReport(SettlementReportParam settlementReportParam);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 导出清结算日报表
     * @Modified By:
     */
    String exportSettlementReport(SettlementReportParam settlementReportParam) throws IOException;

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询月还款报表
     * @Modified By:
     */
    List<RepaymentModel> getRepaymentReport(RepaymentParam repaymentParam);
}
