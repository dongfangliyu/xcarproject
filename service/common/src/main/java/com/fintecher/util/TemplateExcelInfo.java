package com.fintecher.util;

/**
 * Created by qijigui on 2017/6/1.
 */
public class TemplateExcelInfo {

    //Excel列名称
    public String cellName;
    //Excel列序号
    public String cellNum;
    //Excel列关联字段
    public String relateName;

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getCellNum() {
        return cellNum;
    }

    public void setCellNum(String cellNum) {
        this.cellNum = cellNum;
    }

    public String getRelateName() {
        return relateName;
    }

    public void setRelateName(String relateName) {
        this.relateName = relateName;
    }
}
