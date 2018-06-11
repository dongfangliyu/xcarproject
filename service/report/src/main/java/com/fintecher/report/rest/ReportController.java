package com.fintecher.report.rest;

import com.fintecher.common.vo.manage.ResponseResult;
import com.fintecher.common.vo.report.RepaymentModel;
import com.fintecher.common.vo.report.RepaymentParam;
import com.fintecher.common.vo.report.SettlementReportModel;
import com.fintecher.common.vo.report.SettlementReportParam;
import com.fintecher.report.service.ReportService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @System: 车贷金融
 * @Auther: xiaqun
 * @Description: 报表管理
 * @Date: Created on 2018/1/9 9:30
 * @Modified By:
 */

@RestController
@RequestMapping("/report")
@Api(description = "报表管理")
public class ReportController {
    private final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Autowired
    private ReportService reportService;

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询清结算日报表
     * @Modified By:
     */
    @GetMapping("/getSettlementReport")
    @ApiOperation(value = "查询清结算日报表", notes = "查询清结算日报表")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Correct response", response = SettlementReportModel.class)})
    public ResponseResult getSettlementReport(SettlementReportParam settlementReportParam) {
        log.debug("request to get settlement report");
        try {
            List<SettlementReportModel> list = reportService.getSettlementReport(settlementReportParam);
            return new ResponseResult(ResponseResult.Status.SUCCESS, "", list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
    }

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 导出清结算日报表
     * @Modified By:
     */
    @GetMapping("/exportSettlementReport")
    @ApiOperation(value = "导出清结算日报表", notes = "导出清结算日报表")
    public ResponseResult exportSettlementReport(SettlementReportParam settlementReportParam) {
        log.debug("request to export settlement report");
        try {
            String url = reportService.exportSettlementReport(settlementReportParam);
            return new ResponseResult(ResponseResult.Status.SUCCESS, "", url);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
    }

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询月还款报表
     * @Modified By:
     */
    @GetMapping("/getRepaymentReport")
    @ApiOperation(value = "查询月还款报表", notes = "查询月还款报表")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Correct response", response = RepaymentModel.class)})
    public ResponseResult getRepaymentReport(RepaymentParam repaymentParam) {
        log.debug("request to get repayment report");
        try {
            List<RepaymentModel> list = reportService.getRepaymentReport(repaymentParam);
            return new ResponseResult(ResponseResult.Status.SUCCESS, "", list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
    }
}
