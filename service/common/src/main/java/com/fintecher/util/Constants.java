package com.fintecher.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: PeiShouWen
 * @Description:
 * @Date 13:32 2017/7/17
 */
public final class Constants {
    //系统管理模块
    public static final String ADMINISTRATOR_ID = "0o0oo0o0-0o0o-0000-0000-0ooo000o0o0o";
    public static final String ADMIN_USER_NAME = "administrator";
    public static final String ADMIN_DEPARTMENT_ID = "1c1cc1c1-1c1c-1111-1111-0ccc000c0c0c";
    public static final String ADMIN_DEPARTMENT_CODE = "oooooooo";
    public static final String ADMIN_DEPARTMENT_NAME = "催大人";
    public static final String ADMIN_ROLE_ID = "2r2rr2r2-2r2r-2222-2222-0rrr000r0r0r";
    public static final String ADMIN_ROLE_NAME = "超级管理员";
    public static final String SESSION_USER = "USER";
    public static final String SYS_EXCEPTION_NOSESSION = "未登录请重新登录";
    public static final String APPLY_PASSWORD_CODE = "SysParam.applypassword";
    public static final String APPLY_PASSWORD_TYPE = "0001";
    public static final String USER_OVERDAY_CODE = "SysParam.overday";
    public static final String USER_OVERDAY_TYPE = "0002";
    public static final String APPLY_USER_NUMBER_CODE = "SysParam.usernumber";
    public static final String APPLY_USER_NUMBER_TYPE = "0003";
    public static final String USER_RESET_PASSWORD_CODE = "SysParam.resetpassword";
    public static final String USER_RESET_PASSWORD_TYPE = "0004";
    public static final String LOGIN_RET_PASSWORD = "21218cca77804d2ba1922c33e0151105"; //默认密码888888
    public static final String RET_PASSWORD = "21218cca77804d2ba1922c33e0151105"; //默认密码888888
    //呼叫中心模块
    public static final String PHONE_CALL_CODE = "SysParam.phone.call";
    public static final String PHONE_CALL_TYPE = "0005";
    public static final String PHONE_ISREALCALL_CODE = "sys.sma.isrealcall";
    public static final Map<String, String> map = new HashMap<String, String>();
    //BF语音卡模块
    public static final String PHONE_BF_URL = "SysParam.bfyuyin.url";
    public static final String PHONE_BF_TYPE = "9001";
    //阅读回款目前excel模板url
    public static final String BACK_CASH_PLAN_EXCEL_URL_CODE = "SysParam.backcashplanexcelurl";
    public static final String BACK_CASH_PLAN_EXCEL_URL_TYPE = "0006";
    //短信发送
    public static final String SMS_PUSH_CODE = "SysParam.sms.push";
    public static final String SMS_PUSH_TYPE = "0017";
    //导入批次号最大999(3位)
    public final static String ORDER_SEQ = "orderSeq";
    public final static Integer ORDER_SEQ_LENGTH = 3;

    //案件编号最大99999（5位）
    public final static String CASE_SEQ = "caseSeq";
    public final static Integer CASE_SEQ_LENGTH = 5;
    //委托方编号最大999（3位）
    public final static String PRIN_SEQ = "prinSeq";
    public static final String ERROR_MESSAGE = "系统错误";
    //日期格式
    public static final String DATE_FORMAT_ONE = "yyyyMMdd";
    //Excel数据导入格式
    public static final String EXCEL_TYPE_XLS = "xls";
    public static final String EXCEL_TYPE_XLSX = "xlsx";
    //软件注册
    public static final String REGISTER_SOFTWARE_CODE = "SysParam.registersoftware";
    public static final String REGISTER_SOFTWARE_TYPE = "9001";

    //通过文件ID获取文件对象的地址
    public static final String FILEID_SERVICE_URL = "http://file-service/api/";
    //通过TOKEN获取用户对象
    public static final String USERTOKEN_SERVICE_URL = "http://business-service/api/userResource/getUserByToken?token=";
    //通过UserId获取user
    public static final String USERBYID_SERVICE_URL = "http://business-service/api/userResource//findUserById?id=";
    //用户服务
    public static final String USER_SERVICE_URL = "http://business-service/api/api/";
    //business服务
    public static final String BUSINESS_SERVICE_URL = "http://business-service/api/caseInfoResource/";
    //通过用户id获取用户
    public static final String USERNAME_SERVICE_URL = "http://business-service/api/userResource/";
    //通过用户id获取用户
    public static final String PERSONAL_SERVICE_URL = "http://business-service/api/personalResource/";
    //机构服务
    public static final String ORG_SERVICE_URL = "http://business-service/api/departmentResource/";
    //获取得分规则
    public static final String SCOREL_SERVICE_URL = "http://dataimp-service/api/scoreResource/";
    // 公司URL
    public static final String COMPANY_URL = "http://business-service/api/companyResource/getCompanyByCode?companyCode=";
    // 获取上传文件URL
    public static final String UPLOAD_FILE_URL = "http://file-service/api/uploadFile/addUploadFileUrl";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    // 获取案件分配策略
    public static final String CASE_STRATEGY_URL = "http://dataimp-service/api/caseStrategyResource/getCaseStrategy?";
    /**
     * 检查DataInfoExcel中是否存在某委托方的案件
     */
    public static final String CHECK_DATA_INFO_EXCEL_URL = "http://dataimp-service/api/dataInfoExcelResource/checkDataInfoExcel/";

    //案件确认数据发送队列
    public static final String DATAINFO_CONFIRM_QE = "dataInfoExcel.confirm.progress.dev";
    //导出跟进记录消息队列
    public static final String FOLLOWUP_EXPORT_QE = "mr.cui.followup.progress";
    //导出委外跟进记录消息队列
    public static final String FOLLOWUP_OUTSOURCE_EXPORT_QE = "mr.cui.outsource.followup.progress";

    //获取催收员回款报表excel模版url
    public static final String BACK_MONEY_REPORT_EXCEL_URL_CODE = "SysParam.backmoneyreportexcelurl";
    public static final String BACK_MONEY_REPORT_EXCEL_URL_TYPE = "0011";

    //获取催收员业绩进展报表excel模版url
    public static final String PERFORMANCE_REPORT_EXCEL_URL_CODE = "SysParam.performancereportexcelurl";
    public static final String PERFORMANCE_REPORT_EXCEL_URL_TYPE = "0012";

    //获取催收员每日催收过程报表excel模版url
    public static final String DAILY_PROCESS_REPORT_EXCEL_URL_CODE = "SysParam.dailyprocessreportexcelurl";
    public static final String DAILY_PROCESS_REPORT_EXCEL_URL_TYPE = "0013";

    //获取催收员每日催收结果报表excel模版url
    public static final String DAILY_RESULT_REPORT_EXCEL_URL_CODE = "SysParam.dailyresultreportexcelurl";
    public static final String DAILY_RESULT_REPORT_EXCEL_URL_TYPE = "0014";

    //获取催收员业绩排名报表excel模版url
    public static final String PERFORMANCE_RANKING_REPORT_EXCEL_URL_CODE = "SysParam.performancerankingreportexcelurl";
    public static final String PERFORMANCE_RANKING_REPORT_EXCEL_URL_TYPE = "0015";

    //获取催收员业绩排名汇总报表excel模版url
    public static final String PERFORMANCE_SUMMARY_REPORT_EXCEL_URL_CODE = "SysParam.performancesummaryreportexcelurl";
    public static final String PERFORMANCE_SUMMARY_REPORT_EXCEL_URL_TYPE = "0016";

    //获取短信发送统计报表excel模版url
    public static final String SMS_REPORT_EXCEL_URL_CODE = "SysParam.smsreportexcelurl";
    public static final String SMS_REPORT_EXCEL_URL_TYPE = "0018";

    //案件导入excel模板url
    public static final String CASE_IMPORT_TEMPLATE_URL_CODE = "SysParam.caseimportexcelurl";
    public static final String CASE_IMPORT_TEMPLATE_URL_TYPE = "9004";

    //委外案件账目导入模版url
    public static final String SMS_OUTCASE_ACCOUNT_URL_CODE = "sys.outcase.account";
    public static final String SMS_OUTCASE_ACCOUNT_URL_TYPE = "9001";

    //委外案件跟进记录导入模版url
    public static final String SMS_OUTCASE_FOLLOWUP_URL_CODE = "sys.outcase.followup";
    public static final String SMS_OUTCASE_FOLLOWUP_URL_TYPE = "9005";

    //系统参数请求
    public static final String SYSPARAM_URL = "http://business-service/api/sysParamResource";

    //协催过期天数
    public static final String TYPE_TEL = "0010";
    public static final String ASSIST_APPLY_CODE = "SysParam.assistApplyOverday";
    //批量成功步数
    public static final String BATCH_STEP_SUCCESS = "6";
    //批次号生成规则 （1-邢台从Excel获取,0-其他自动生成）
    public static final String BATCH_NUMBER_RULE_CODE = "SysParam.batchnumberrule";
    public static final String BATCH_NUMBER_RULE_TYPE = "9003";

    //录音下载跑批启用状态
    public static final String RECORD_DOWNLOAD_STATUS_CODE = "Sysparam.recorddownload.status";
    public static final String RECORD_DOWNLOAD_STATUS_TYPE = "9020";

    //消息提醒跑批启用状态
    public static final String REMIND_STATUS_CODE = "Sysparam.remind.status";
    public static final String REMIND_STATUS_TYPE = "9021";

    //夜间跑批启用状态
    public static final String OVERNIGHTBATCH_STATUS_CODE = "Sysparam.overnightbatch.status";
    public static final String OVERNIGHTBATCH_STATUS_TYPE = "9022";

    //Excel 07版最大行数
    public static final int ROW_MAX = 1048576;
    // Excel sheet页最大个数
    public static final int SHEET_MAX = 255;

    public static final List<String> monthList = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
    public static final List<String> weekList = Arrays.asList("0", "1", "2", "3", "4", "5", "6");

    /**
     * 数据来源
     */
    public enum DataSource {
        IMPORT(145, "导入"), PORT(146, "接口"), REPAIR(147, "修复");
        private Integer value;
        private String remark;

        DataSource(Integer value, String remark) {
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

    /**
     * 晚间批量任务调度
     */
    public final static String OVERNIGHT_TRIGGER_GROUP = "overNightTriggerGroup";
    public final static String OVERNIGHT_TRIGGER_NAME = "overNightTriggerName";
    public final static String OVERNIGHT_TRIGGER_DESC = "晚间批量触发器";
    public final static String OVERNIGHT_JOB_GROUP = "OverNightJobGroup";
    public final static String OVERNIGHT_JOB_NAME = "OverNightJobName";
    public final static String OVERNIGHT_JOB_DESC = "晚间批量";
    public final static String SYSPARAM_OVERNIGHT = "SysParam.overNight";
    public final static String SYSPARAM_OVERNIGHT_STATUS = "Sysparam.overnight.status";
    public final static String SYSPARAM_OVERNIGHT_STEP = "Sysparam.overnight.step";


    /**
     * 录音下载调度
     */
    public final static String RECORD_TRIGGER_GROUP = "recordTriggerGroup";
    public final static String RECORD_TRIGGER_NAME = "recordTriggerName";
    public final static String RECORD_TRIGGER_DESC = "录音下载触发器";
    public final static String RECORD_JOB_GROUP = "recordJobGroup";
    public final static String RECORD_JOB_NAME = "recordJobName";
    public final static String RECORD_JOB_DESC = "录音下载批量";
    public final static String SYSPARAM_RECORD = "Sysparam.record";
    public final static String SYSPARAM_RECORD_STATUS = "Sysparam.record.status";

    /**
     * 消息提醒调度
     */
    public final static String REMINDER_TRIGGER_GROUP = "reminderTriggerGroup";
    public final static String REMINDER_TRIGGER_NAME = "reminderTriggerName";
    public final static String REMINDER_TRIGGER_DESC = "消息提醒触发器";
    public final static String REMINDER_JOB_GROUP = "reminderJobGroup";
    public final static String REMINDER_JOB_NAME = "reminderJobName";
    public final static String REMINDER_JOB_DESC = "消息提醒批量";
    public final static String SYSPARAM_REMINDER = "Sysparam.reminder";
    public final static String SYSPARAM_REMINDER_STATUS = "Sysparam.reminder.status";

    /**
     * 案件回收相关调度
     */
    public final static String RECOVER_TRIGGER_GROUP = "recoverTriggerGroup";
    public final static String RECOVER_TRIGGER_NAME = "recoverTriggerName";
    public final static String RECOVER_TRIGGER_DESC = "案件回收触发器";
    public final static String RECOVER_JOB_GROUP = "recoverJobGroup";
    public final static String RECOVER_JOB_NAME = "recoverJobName";
    public final static String RECOVER_JOB_DESC = "案件回收相关";
    public final static String SYSPARAM_RECOVER = "Sysparam.recover";
    public final static String SYSPARAM_RECOVER_STATUS = "Sysparam.recover.status";

    /**
     * 批量执行状态
     */
    public enum BatchStatus {
        STOP("0", "未执行"), RUNING("1", "正在执行");

        String value;
        String code;

        BatchStatus(String value, String code) {
            this.value = value;
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * 电催小流转
     **/
    public final static String SYS_PHNOEFLOW_SMALLDAYS = "sys.phnoeFlow.smallDays";
    /**
     * 电催大流转
     **/
    public final static String SYS_PHNOEFLOW_BIGDAYS = "sys.phnoeFlow.bigDays";
    /**
     * 电催留案流转
     **/
    public final static String SYS_PHNOEFLOW_LEAVEDAYS = "sys.phnoeFlow.leaveDays";
    /**
     * 电催留案比例
     **/
    public final static String SYS_PHNOEFLOW_LEAVERATE = "sys.phnoeFlow.leaveRate";
    /**
     * 电催强制流转提醒天数
     **/
    public final static String SYS_PHNOEFLOW_BIGDAYSREMIND = "sys.phnoeFlow.bigDaysRemind";
    /**
     * 电催无进展提醒天数
     **/
    public final static String SYS_PHONEREMIND_DAYS = "sys.phoneRemind.days";
    /**
     * 电催小流转部门
     **/
    public final static String SYS_PHNOETURN_SMALLDEPTNAME = "电催小流转";
    /**
     * 电催强制流转部门
     **/
    public final static String SYS_PHNOETURN_BIGDEPTNAME = "电催强制流转";
    /**
     * 电催留案流转部门
     **/
    public final static String SYS_PHNOETURN_LEAVEDEPTNAME = "电催留案流转";


    /**
     * 外访小流转
     **/
    public final static String SYS_OUTBOUNDFLOW_SMALLDAYS = "sys.outboundFlow.smallDays";
    /**
     * 外访大流转
     **/
    public final static String SYS_OUTBOUNDFLOW_BIGDAYS = "sys.outboundFlow.bigDays";
    /**
     * 外访留案流转
     **/
    public final static String SYS_OUTBOUNDFLOW_LEAVEDAYS = "sys.outboundFlow.leaveDays";
    /**
     * 外访留案比例
     **/
    public final static String SYS_OUTBOUNDFLOW_LEAVERATE = "sys.outboundflow.leaveRate";
    /**
     * 外访强制流转提醒天数
     **/
    public final static String SYS_OUTBOUNDFLOW_BIGDAYSREMIND = "sys.outboundFlow.bigDaysRemind";
    /**
     * 外访无进展提醒天数
     **/
    public final static String SYS_OUTREMIND_DAYS = "sys.outRemind.days";
    /**
     * 外访小流转部门
     **/
    public final static String SYS_OUTTURN_SMALLDEPTNAME = "外访小流转";
    /**
     * 外访强制流转部门
     **/
    public final static String SYS_OUTTURN_BIGDEPTNAME = "外访强制流转";
    /**
     * 外访留案流转部门
     **/
    public final static String SYS_OUTTURN_LEAVEDEPTNAME = "外访留案流转";

    /**
     * 全程协催案件强制流转天数
     **/
    public final static String SYS_ASSIST_BIGDAYS = "sys.assist.bigdays";
    /**
     * 单次协催小流转天数
     **/
    public final static String SYS_ASSIST_SMALLDAYS = "sys.assist.smalldays";
    /**
     * 协催留案天数
     **/
    public final static String SYS_ASSIST_LEAVEDAYS = "sys.assist.leavedays";
    /**
     * 协催留案比例
     **/
    public final static String SYS_ASSIST_LEAVERATE = "sys.assist.leaveRate";

    /**
     * 协催无进展提醒天数
     **/
    public final static String SYS_ASSISTREMIND_DAYS = "sys.assistRemind.days";
    /**
     * 协催强制流转提醒天数
     **/
    public final static String SYS_ASSISTREMIND_BIGDAYSREMIND = "sys.assistRemind.bigDaysRemind";

    /**
     * 抢单半径（公里）
     **/
    public final static String SYS_QIANGDAN_RADIUS = "sys.qiangdan.radius";
    /**
     * 地球半径
     **/
    public final static double EARTH_RADIUS = 6371;

    /**
     * mysql系统数据库备份
     */
    public final static String MYSQL_BACKUP_ADDRESS_CODE = "Sysparam.mysqlbackup.address";
    public final static String MYSQL_BACKUP_ADDRESS_TYPE = "9001";
    public final static String MYSQL_RECOVER_ADDRESS_CODE = "Sysparam.mysqlrecover.address";
    public final static String MYSQL_RECOVER_ADDRESS_TYPE = "9001";
    /**
     * mongodb系统数据库备份
     */
    public final static String MONGODB_BACKUP_ADDRESS_CODE = "Sysparam.mongodbbackup.address";
    public final static String MONGODB_BACKUP_ADDRESS_TYPE = "9001";
    public final static String MONGODB_RECOVER_ADDRESS_CODE = "Sysparam.mongodbrecover.address";
    public final static String MONGODB_RECOVER_ADDRESS_TYPE = "9001";

    /**
     * 策略分配相关参数
     */
    public final static String CASE_INFO_DISTRIBUTE_RULE = "caseInfoDistribute.ftl";
    public final static String CASE_INFO_RULE = "caseInfo.ftl";
    public final static String OUTSOURCE = "outsource.ftl";

    /**
     * 策略所属城市属性
     */
    public final static String STRATEGY_AREA_ID = "area.id";

    /**
     * 策略产品系列属性
     */
    public final static String STRATEGY_PRODUCT_SERIES = "product.productSeries.seriesName";

    /**
     * 案件分案撤销参数
     */
    public final static String SYS_REVOKE_DISTRIBUTE = "Sysparam.revokedistribute";
    public final static String SYS_REVOKE_DISTRIBUTE_TYPE = "9001";

    /**
     * 审批原因模板
     */
    public final static String APPROVE_REASON_TEMPLATE_CODE = "ApproveReasonTemplate";
    public final static String APPROVE_REASON_TEMPLATE_TYPE = "9002";

    /**
     * 产品包模板
     */
    public final static String PRODUCT_PACKAGE_TEMPLATE_CODE = "ProductPackageTemplate";
    public final static String PRODUCT_PACKAGE_TEMPLATE_TYPE = "9002";
}
