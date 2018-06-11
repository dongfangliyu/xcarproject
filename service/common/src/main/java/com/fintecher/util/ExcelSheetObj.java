package com.fintecher.util;


import com.fintecher.web.BaseObject;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: PeiShouWen
 * @Description: ExcelSheet页数据对象
 * @Date 11:22 2017/3/6
 */
public class ExcelSheetObj extends BaseObject implements Serializable{
    private String sheetName;
    private List datasList;
    private String importMsg;
    private List<CellError> cellErrorList;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List getDatasList() {
        return datasList;
    }

    public void setDatasList(List datasList) {
        this.datasList = datasList;
    }

    public String getImportMsg() {
        return importMsg;
    }

    public void setImportMsg(String importMsg) {
        this.importMsg = importMsg;
    }

    public List<CellError> getCellErrorList() {
        return cellErrorList;
    }

    public void setCellErrorList(List<CellError> cellErrorList) {
        this.cellErrorList = cellErrorList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExcelSheetObj that = (ExcelSheetObj) o;

        if (sheetName != null ? !sheetName.equals(that.sheetName) : that.sheetName != null) return false;
        if (datasList != null ? !datasList.equals(that.datasList) : that.datasList != null) return false;
        if (importMsg != null ? !importMsg.equals(that.importMsg) : that.importMsg != null) return false;
        return cellErrorList != null ? cellErrorList.equals(that.cellErrorList) : that.cellErrorList == null;
    }

    @Override
    public int hashCode() {
        int result = sheetName != null ? sheetName.hashCode() : 0;
        result = 31 * result + (datasList != null ? datasList.hashCode() : 0);
        result = 31 * result + (importMsg != null ? importMsg.hashCode() : 0);
        result = 31 * result + (cellErrorList != null ? cellErrorList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExcelSheetObj{" +
                "sheetName='" + sheetName + '\'' +
                ", datasList=" + datasList +
                ", importMsg='" + importMsg + '\'' +
                ", cellErrorList=" + cellErrorList +
                '}';
    }
}
