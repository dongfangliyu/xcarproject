package com.fintecher.sims.util;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description:
 * @Date: Created on 2018/3/13 15:38
 * @Modified_By:
 */

public class GeneralEnum {

    /**
     * 基础状态
     */
    public enum BaseStatus {
        ENABLE(1L, "启用"), DISABLE(0L, "停用");
        private Long value;
        private String remark;

        BaseStatus(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 基础判断
     */
    public enum BasisJudge {
        YES(1L, "是"),
        NO(0L, "否");
        private Long value;
        private String remark;

        BasisJudge(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 处理状态
     */
    public enum ProcessingStatus {
        PROCESSED(3L, "已处理"),
        UNPROCESSED(4L, "未处理");
        private Long value;
        private String remark;

        ProcessingStatus(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 车辆状态
     */
    public enum VehicleStatus {

        DISABLE(0L, "车辆停用"),
        NOT_IN_STORAGE(1L, "未入库"),
        STORAGE_PARK(2L, "库存停放"),
        LOCKED(3L, "锁定中"),
        LOCKED_TRANSFER(4L, "调拨锁定"),
        LOCKED_SELL(5L, "销售锁定"),
        LOCKED_PREPARE(6L, "整备车锁定"),
        OUTBOUND(7L, "出库"),
        OUTBOUND_TRANSFER(8L, "调拨出库"),
        SOLD(9L, "已销售"),
        TRANSFER_ACCOUNT(10L, "已过户");

        private Long value;
        private String remark;

        VehicleStatus(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 调拨申请状态
     */
    public enum AllocationApproveStatus {
        DELETE(0L, "已删除"),
        IN_CONFIRM(1L, "待调入方确认"),
        IN_REFUSE(2L, "调入方拒绝"),
        IN_RETURN(3L, "调入方退回"),
        HEADER_CONFIRM(4L, "待总部审核"),
        HEADER_REFUSE(5L, "总部拒绝"),
        HEADER_RETURN(6L, "总部退回"),
        OUT_CONFIRM(7L, "待调出方确认"),
        OUT_REFUSE(8L, "调出方拒绝"),
        OUT_RETURN(9L, "调出方退回"),
        OUTBOUND(10L, "待出库"),
        STORAGE(11L, "待入库"),
        COMPLETE(12L, "已入库");
        private Long value;
        private String remark;

        AllocationApproveStatus(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 调拨进度事项
     */
    public enum AllocationScheduleItem {
        INITIATE(0L, "调拨申请发起"),
        IN_PASS(1L, "调入营业部经理确认通过"),
        IN_REFUSE(2L, "调入营业部经理确认拒绝"),
        IN_RETURN(3L, "调入营业部经理确认退回"),
        HEADER_PASS(4L, "总车务审核通过"),
        HEADER_REFUSE(5L, "总车务审核拒绝"),
        HEADER_RETURN(6L, "总车务审核退回"),
        OUT_PASS(7L, "调出营业部经理确认通过"),
        OUT_REFUSE(8L, "调出营业部经理确认拒绝"),
        OUT_RETURN(9L, "调出营业部经理确认退回"),
        OUTBOUND(10L, "调出车管确认出库"),
        STORAGE(11L, "调入车管确认入库");
        private Long value;
        private String remark;

        AllocationScheduleItem(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 审核结果
     */
    public enum ApproveResult {
        PASS(0L, "审核通过"),
        REFUSE(1L, "审核拒绝"),
        RETURN(2L, "审核退回");
        private Long value;
        private String remark;

        ApproveResult(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 调拨记录类型
     */
    public enum AllocationType {
        SALE_OUT(0L, "销售出库"),
        ALLOCATION_OUT(1L, "调拨出库"),
        TRANSFER_OUT(2L, "过户出库"),
        PURCHASE_IN(3L, "采购入库"),
        ALLOCATION_IN(4L, "调拨入库"),
        USED_CAR_IN(5L, "整备车入库");
        private Long value;
        private String remark;

        AllocationType(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 里程记录操作类型
     */
    public enum VehicleMileageType {
        SALE(0L, "销售"),
        ALLOCATION(1L, "调拨"),
        PURCHASE(2L, "采购");
        private Long value;
        private String remark;

        VehicleMileageType(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 里程记录出入库类型
     */
    public enum VehicleMileageStorage {
        IN(0L, "入库"),
        OUT(1L, "出库");
        private Long value;
        private String remark;

        VehicleMileageStorage(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 采购类型
     */
    public enum PurchaseType {
        COLLECTION(0L, "集采"),
        PICKING(1L, "地采");
        private Long value;
        private String remark;

        PurchaseType(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 开票方式
     */
    public enum InvoicingWay {
        UNIFIED(0L, "全国机动车统一销售发票"),
        VAT(1L, "增值专用发票");
        private Long value;
        private String remark;

        InvoicingWay(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 付款方式
     */
    public enum payWay {
        HF(0L, "汇付"),
        FY(1L, "富友"),
        PUBLIC(2L, "对公转账");
        private Long value;
        private String remark;

        payWay(Long value, String remark) {
            this.value = value;
            this.remark = remark;
        }

        public Long getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }

    /**
     * 采购单申请状态
     */
    public enum PurchaseOrderStatus {
        //TODO
    }
}
