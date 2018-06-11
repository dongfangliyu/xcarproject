package com.fintecher.report.service.impl;

import com.fintecher.common.vo.report.*;
import com.fintecher.util.ZWDateUtil;
import com.fintecher.report.mapper.ReportMapper;
import com.fintecher.report.service.ReportService;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @System: 车贷金融
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/1/9 9:43
 * @Modified By:
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class ReportServiceImpl implements ReportService {
    private final Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);

    @Autowired
    private ReportMapper reportMapper;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询清结算日报表
     * @Modified By:
     */
    @Override
    public List<SettlementReportModel> getSettlementReport(SettlementReportParam settlementReportParam) {
        if (Objects.isNull(settlementReportParam.getCompanyId())) {
            return reportMapper.getSettlementReportAll(settlementReportParam);
        } else {
            return reportMapper.getSettlementReportOne(settlementReportParam);
        }
    }

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 导出清结算日报表
     * @Modified By:
     */
    @Override
    public String exportSettlementReport(SettlementReportParam settlementReportParam) throws IOException {
        //获取报表
        List<SettlementReportModel> list = getSettlementReport(settlementReportParam);
        //生成excel
        HSSFWorkbook workbook = null;
        File file = null;
        ByteArrayOutputStream out = null;
        FileOutputStream fileOutputStream = null;
        try {
            workbook = new HSSFWorkbook();
            out = new ByteArrayOutputStream();
            HSSFSheet sheet = workbook.createSheet("清结算日报表");
            CellStyle headStyle = style(workbook, 0);
            CellStyle bodyStyle = style(workbook, 1);
            //生成报表表头
            String companyName = Objects.isNull(settlementReportParam.getCompanyId()) ? null : reportMapper.getCompanyName(settlementReportParam.getCompanyId());
            generateSheet(sheet, companyName, settlementReportParam.getChannel(), headStyle);
            //向报表中写入数据
            writeData(sheet, settlementReportParam.getChannel(), list, companyName, bodyStyle);
            workbook.write(out);
            String filePath = FileUtils.getTempDirectoryPath().concat(File.separator).concat("清结算日报表.xls");
            file = new File(filePath);
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(out.toByteArray());
            FileSystemResource resource = new FileSystemResource(file);
            MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
            param.add("file", resource);
            return restTemplate.postForEntity("http://service-file/uploadFile/addUploadFileUrl", param, String.class).getBody();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        } finally {
            // 关闭流
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
            }
            // 删除文件
            if (file != null) {
                file.delete();
            }
        }
    }

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 生成报表表头并写入数据
     * @Modified By:
     */
    private HSSFSheet generateSheet(HSSFSheet sheet, String organization, Integer channel, CellStyle headStyle) {
        Cell cell;
        List<DataDictModel> dictModels = reportMapper.getChannel();
        //创建行
        for (int i = 0; i < 2; i++) { //生成2行
            //表头列号
            int headerCol = 0;
            Row row = sheet.createRow(i);
            //给单元格设值
            cell = row.createCell(headerCol);
            cell.setCellValue("公司简称");
            cell.setCellStyle(headStyle);
            headerCol++;
            if (Objects.nonNull(organization)) { //查单个公司
                cell = row.createCell(headerCol);
                cell.setCellValue("日期");
                cell.setCellStyle(headStyle);
                headerCol++;
                cell = row.createCell(headerCol);
                cell.setCellValue("客户名");
                cell.setCellStyle(headStyle);
                headerCol++;
            }

            if (Objects.isNull(channel)) { //不选择通道
                for (int j = 0; j < dictModels.size(); j++) {
                    for (int k = 0; k < 10; k++) {
                        cell = row.createCell(headerCol);
                        if (i == 0) { //第一行
                            cell.setCellValue(dictModels.get(j).getName());
                            cell.setCellStyle(headStyle);
                        } else { //第二行
                            writeHeader(cell, k, headStyle);
                        }
                        headerCol++;
                    }
                }
            } else { //选择通道
                DataDictModel dataDictModel = reportMapper.getChannelById(channel);
                for (int k = 0; k < 10; k++) {
                    cell = row.createCell(headerCol);
                    if (i == 0) { //第一行
                        cell.setCellValue(dataDictModel.getName());
                        cell.setCellStyle(headStyle);
                    } else { //第二行
                        writeHeader(cell, k, headStyle);
                    }
                    headerCol++;
                }
            }
        }

        //合并渠道
        if (Objects.isNull(channel)) {
            for (int i = 1; i <= dictModels.size(); i++) {
                CellRangeAddress cra = new CellRangeAddress(0, 0, (Objects.isNull(organization)) ? i * 10 - 9 : i * 10 - 7, (Objects.isNull(organization)) ? i * 10 : i * 10 + 2); // 四个参数分别是：起始行，结束行,起始列，结束列
                sheet.addMergedRegion(cra);
            }
        } else {
            CellRangeAddress cra = new CellRangeAddress(0, 0, (Objects.isNull(organization)) ? 1 : 3, (Objects.isNull(organization)) ? 10 : 12); // 四个参数分别是：起始行，结束行,起始列，结束列
            sheet.addMergedRegion(cra);
        }
        //合并统计通道
        if (Objects.isNull(organization)) {
            //合并公司简称
            CellRangeAddress cra = new CellRangeAddress(0, 1, 0, 0); // 四个参数分别是：起始行，结束行,起始列，结束列
            sheet.addMergedRegion(cra);
        } else {
            //合并公司简称,日期,客户名
            for (int i = 0; i < 3; i++) {
                CellRangeAddress cra1 = new CellRangeAddress(0, 1, i, i); // 四个参数分别是：起始行，结束行,起始列，结束列
                sheet.addMergedRegion(cra1);
            }
        }
        return sheet;
    }

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 写入报表表头
     * @Modified By:
     */
    private Cell writeHeader(Cell cell, int j, CellStyle headStyle) {
        switch (j) {
            case 0:
                cell.setCellValue("保证金");
                cell.setCellStyle(headStyle);
                break;
            case 1:
                cell.setCellValue("首付");
                cell.setCellStyle(headStyle);
                break;
            case 2:
                cell.setCellValue("购置税");
                cell.setCellStyle(headStyle);
                break;
            case 3:
                cell.setCellValue("保险");
                cell.setCellStyle(headStyle);
                break;
            case 4:
                cell.setCellValue("杂费");
                cell.setCellStyle(headStyle);
                break;
            case 5:
                cell.setCellValue("月租本金");
                cell.setCellStyle(headStyle);
                break;
            case 6:
                cell.setCellValue("月租利息");
                cell.setCellStyle(headStyle);
                break;
            case 7:
                cell.setCellValue("罚息");
                cell.setCellStyle(headStyle);
                break;
            case 8:
                cell.setCellValue("手续费");
                cell.setCellStyle(headStyle);
                break;
            case 9:
                cell.setCellValue("小计");
                cell.setCellStyle(headStyle);
                break;
        }
        return cell;
    }

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 写入报表数据
     * @Modified By:
     */
    private Cell writeData(Cell cell, int j, SettlementReportModel settlementReportModel, CellStyle bodyStyle) {
        switch (j) {
            case 0:
                cell.setCellValue(Objects.isNull(settlementReportModel.getDepositCash()) ? "-" : settlementReportModel.getDepositCash().toString());
                cell.setCellStyle(bodyStyle);
                break;
            case 1:
                cell.setCellValue(Objects.isNull(settlementReportModel.getInitialPayment()) ? "-" : settlementReportModel.getInitialPayment().toString());
                cell.setCellStyle(bodyStyle);
                break;
            case 2:
                cell.setCellValue(Objects.isNull(settlementReportModel.getPurchaseTax()) ? "-" : settlementReportModel.getPurchaseTax().toString());
                cell.setCellStyle(bodyStyle);
                break;
            case 3:
                cell.setCellValue(Objects.isNull(settlementReportModel.getInsuranceExpenses()) ? "-" : settlementReportModel.getInsuranceExpenses().toString());
                cell.setCellStyle(bodyStyle);
                break;
            case 4:
                cell.setCellValue(Objects.isNull(settlementReportModel.getOtherFee()) ? "-" : settlementReportModel.getOtherFee().toString());
                cell.setCellStyle(bodyStyle);
                break;
            case 5:
                cell.setCellValue(Objects.isNull(settlementReportModel.getPrincipalReceived()) ? "-" : settlementReportModel.getPrincipalReceived().toString());
                cell.setCellStyle(bodyStyle);
                break;
            case 6:
                cell.setCellValue(Objects.isNull(settlementReportModel.getInterestReceived()) ? "-" : settlementReportModel.getInterestReceived().toString());
                cell.setCellStyle(bodyStyle);
                break;
            case 7:
                cell.setCellValue(Objects.isNull(settlementReportModel.getPenaltyReceived()) ? "-" : settlementReportModel.getPenaltyReceived().toString());
                cell.setCellStyle(bodyStyle);
                break;
            case 8:
                cell.setCellValue(Objects.isNull(settlementReportModel.getParam()) ? "-" : settlementReportModel.getParam().toString());
                cell.setCellStyle(bodyStyle);
                break;
            case 9:
                cell.setCellValue(Objects.isNull(settlementReportModel.getSum()) ? "-" : settlementReportModel.getSum().toString());
                cell.setCellStyle(bodyStyle);
                break;
        }
        return cell;
    }

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 写入报表数据
     * @Modified By:
     */
    private Sheet writeData(HSSFSheet sheet, Integer channel, List<SettlementReportModel> list, String organization, CellStyle bodyStyle) {
        if (Objects.isNull(list) || list.isEmpty()) {
            return sheet;
        }
        Cell cell;
        Row row;
        for (SettlementReportModel model : list) {
            int dataRow = 2; //起始行号
            int dataCol = 0; //起始列号
            row = sheet.createRow(dataRow);
            if (Objects.equals(dataCol, 0)) {
                cell = row.createCell(dataCol);
                cell.setCellValue(Objects.isNull(model.getCompanyName()) ? "-" : model.getCompanyName());
                cell.setCellStyle(bodyStyle);
                dataCol++;
                if (Objects.nonNull(organization)) { //查全公司
                    cell = row.createCell(dataCol);
                    cell.setCellValue(Objects.isNull(model.getDate()) ? "-" : ZWDateUtil.fomratterDate(model.getDate(), "yyyy-MM-dd"));
                    cell.setCellStyle(bodyStyle);
                    dataCol++;
                    cell = row.createCell(dataCol);
                    cell.setCellValue(Objects.isNull(model.getPersonalName()) ? "-" : model.getPersonalName());
                    cell.setCellStyle(bodyStyle);
                    dataCol++;
                }
            }
            if (Objects.isNull(channel)) { //查全部渠道
                String name = "";
                if (Objects.equals(name, model.getCompanyName())) {
                    for (int i = 0; i < 10; i++) {
                        cell = row.createCell(dataCol);
                        writeData(cell, i, model, bodyStyle);
                        dataCol++;
                    }
                } else {
                    if (!Objects.equals(dataRow, 2)) {
                        dataRow++;
                        row = sheet.createRow(dataRow);
                    }
                    for (int i = 0; i < 10; i++) {
                        cell = row.createCell(dataCol);
                        writeData(cell, i, model, bodyStyle);
                        dataCol++;
                    }
                }
            } else { //查单个渠道
                for (int i = 0; i < 10; i++) {
                    cell = row.createCell(dataCol);
                    writeData(cell, i, model, bodyStyle);
                    dataCol++;
                }
                dataRow++;
            }
        }
        return sheet;
    }

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: Excel样式
     * @Modified By:
     */
    private CellStyle style(Workbook workbook, Integer type) {
        //Excel格式
        CellStyle headStyle = workbook.createCellStyle();
        CellStyle bodyStyle = workbook.createCellStyle();
        headStyle.setAlignment(HorizontalAlignment.CENTER);
        bodyStyle.setAlignment(HorizontalAlignment.CENTER);
        //设置头文件字体
        Font fontTitle = workbook.createFont();
        fontTitle.setFontName("黑体");
        fontTitle.setFontHeightInPoints((short) 12);//设置字体大小
        headStyle.setFont(fontTitle);
        Font fontBody = workbook.createFont();
        fontBody.setFontName("宋体");
        fontBody.setFontHeightInPoints((short) 11);
        bodyStyle.setFont(fontBody);
        if (Objects.equals(0, type)) {
            return headStyle;
        } else if (Objects.equals(1, type)) {
            return bodyStyle;
        } else {
            return null;
        }
    }

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询月还款报表
     * @Modified By:
     */
    @Override
    public List<RepaymentModel> getRepaymentReport(RepaymentParam repaymentParam) {
        return reportMapper.getRepaymentReport(repaymentParam);
    }
}
