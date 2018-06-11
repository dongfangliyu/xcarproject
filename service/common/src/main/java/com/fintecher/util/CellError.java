package com.fintecher.util;

import java.io.Serializable;

/**
 * @Author: PeiShouWen
 * @Description: Excel导入错误信息实体
 * @Date 15:35 2017/3/3
 */
public class CellError implements Serializable{

    /**
     * sheet页名称
     */
    private String sheetName;
    /**
     * the cell's rowIndex. 0-based
     */
    private int rowIndex;

    /**
     * the cell's columnIndex. 0-based
     */
    private int columnIndex;

    /**
     * the corresponding propName
     */
    private String propName;

    /**
     * the corresponding headerText
     */
    private String headerText;
    /**
     * 错误信息
     */
    private String errorMsg;


    public CellError() {
    }

    public CellError(String sheetName, int rowIndex, int columnIndex, String propName, String headerText, String errorMsg, Exception cause) {
        this.sheetName = sheetName;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.propName = propName;
        this.headerText = headerText;
        this.errorMsg = errorMsg;
    }



    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
