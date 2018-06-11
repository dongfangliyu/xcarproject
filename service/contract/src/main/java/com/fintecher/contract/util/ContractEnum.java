package com.fintecher.contract.util;

/**
 * @Author wxc
 * @Data 2018/2/6 11:57 
 * @Description 合同枚举定义
 */
public enum ContractEnum {
    /**借款协议 */
    ZZL_F001("ZZL_F001","借款协议","erp/loanProtocol.ftl"),
    /** 还款提示函*/
    ZZL_F002("ZZL_F002","还款提示函","erp/repaymentTip.ftl"),
    /**居间服务协议*/
    ZZL_F003("ZZL_F003","居间服务协议","erp/creditConsultAndManageServiceProtocol.ftl"),
    /**委托扣款授权书*/
    ZZL_F004("ZZL_F004","委托扣款授权书","erp/entrustRepayment.ftl"),
    /**委托转账说明*/
    ZZL_F005("ZZL_F005","委托转账说明","entrustTransfer.ftl"),
    //开户相关
    /**富友-苏州中资联投资管理有限公司专用账户协议*/
    ZZL_A001("ZZL_A001","富友-苏州中资联投资管理有限公司专用账户协议","fyAccountProtocol.ftl"),
    /**数字证书服务协议（金账户）*/
    ZZL_A002("ZZL_A002","数字证书服务协议（金账户）","digitalCertificateServiceAgreementByYBQ.ftl"),
    /**数字证书服务协议（易保全）*/
    ZZL_A003("ZZL_A003","数字证书服务协议（易保全）","erp/digitalCertificateServiceAgreementByYBQ.ftl"),
    /**江西银行网络交易资金账户服务三方协议（开户协议）*/
    ZZL_A004("ZZL_A004","江西银行网络交易资金账户服务三方协议（开户协议）","fromFTP"),
    /**平台会员授权协议*/
    ZZL_A005("ZZL_A005","平台会员授权协议","fromFTP"),
    /**承诺书*/
    ZZL_A006("ZZL_A006","承诺书","erp/commitment.ftl"),
    /**数字证书服务协议（天威）*/
    ZZL_A007("ZZL_A007","数字证书服务协议（天威）","erp/digitalCertificateServiceAgreement.ftl"),


    /**借款协议 */
    KD_F001("KD_F001","借款协议","ec/loanProtocol.ftl"),
    /**居间服务协议*/
    KD_A004("KD_A004","居间服务协议","ec/creditConsultAndManageServiceProtocol.ftl"),
    /**委托扣款授权书*/
    KD_A005("KD_A005","委托扣款授权书","ec/entrustRepayment.ftl"),
    /**开户协议（江西银行）*/
    /**金账户开户协议（富友）*/
    KD_A001("KD_A001","富友开户协议","kd/fyAccountProtocol.ftl"),
    /**委托扣款授权书*/
    KD_F004("KD_F004","委托扣款授权书","kd/entrustRepayment.ftl"),
    /**委托转账说明*/
    KD_F005("KD_F005","委托转账说明","entrustTransfer.ftl"),
    /**承诺书*/
    KD_F006("KD_F006","承诺书","commitment.ftl"),
    /**居间服务协议*/
    KD_F007("KD_F007","居间服务协议","kd/creditConsultAndManageServiceProtocol.ftl"),
    /**江西银行-开户协议*/
    KD_F008("KD_F008","江西银行网络交易资金账户服务三方协议","kd/bankAccountProtocol.ftl"),

    KD_F009("KD_F009","借款协议","kd/loanProtocol.ftl"),
    /**借款服务与隐私协议*/
    KD_F010("KD_F010","借款服务与隐私协议","kd/loanAndSecretProtocol.ftl"),
    /**数字证书服务协议（天威）*/
    KD_F011("KD_F011","数字证书服务协议（天威）","kd/numberCertificateProtocol_tw.ftl"),
    /**数字证书服务协议（易保全）*/
    KD_F012("KD_F012","数字证书服务协议（易保全）","kd/numberCertificateProtocol_ybq.ftl"),
    /**平台会员授权协议*/
    KD_F013("KD_F013","平台会员授权协议","kd/userAuthorizeProtocol.ftl"),
    /**承诺书*/
    KD_F014("KD_F014","承诺书","kd/commitment.ftl"),




    /**投呗合同*/
    TB_F001("TB_F001","借款协议","tb/loanProtocol.ftl"),
    TB_F002("TB_F002","承诺书","tb/commitment.ftl"),
    TB_F003("TB_F003","富友-开户协议南京富捷信息科技有限公司","tb/TBfyAccountProtocol.ftl"),
    TB_F004("TB_F004","还款提示函","tb/repaymentTip.ftl"),
    TB_A001("TB_A001","居间服务协议（出借人）","tb/LOANcreditConsultAndManageServiceProtocol.ftl"),
    TB_A002("TB_A002","居间服务协议（借款人）","tb/BORROWcreditConsultAndManageServiceProtocol.ftl"),
    TB_A003("TB_A003","委托扣款授权书","tb/entrustRepayment.ftl"),
    TB_A004("TB_A004","数字证书服务协议（天威）","tb/TBdigitalCertificateServiceAgreement.ftl"),
    TB_A005("TB_A005","数字证书服务协议（易保全）","tb/TBdigitalCertificateServiceAgreementByYBQ.ftl"),
    TB_A006("TB_A006","快捷易贷注册协议","tb/kjydResiteryProtocol.ftl"),
    TB_A007("TB_A007","风险备用金服务协议","tb/TB_A007.ftl"),
    //TB_A008("TB_A008","注册协议","tb/TB_A008.ftl"),


    //Begin ADD:20170919;NOTE:投呗合同
    TB_F005("TB_F005","优选系列产品服务协议","tb/prioritySeriesProductServiceProtocol.ftl"),//ok
    TB_F006("TB_F006","债权转让协议","tb/debtTransferAgreementEBAOProduct.ftl"),//缺少模版
    TB_F007("TB_F007","债权转让协议","tb/debtTransferAgreement.ftl"),//ok
    TB_F008("TB_F008","借款协议","tb/TB_F008.ftl"),//ok
    TB_F009("TB_F009","居间服务协议（出借人）","tb/TB_F009.ftl"),//ok
    TB_F010("TB_F010","居间服务协议（借款人）","tb/TB_F010.ftl"),//ok
    TB_F011("TB_F011","风险备用金服务协议","tb/riskReserveServiceAgreement.ftl"),
    TB_F012("TB_F012","中资联财富会员服务协议","tb/zzlcfhyfwAgreement.ftl"),
    //End ADD:20170919;NOTE:投呗合同


    //Begin 投呗协议类合同模版
    //风险备用金服务协议 - TB_A007("TB_A007","风险备用金服务协议","tb/TB_A007.ftl"),
    TB_X002("TB_X002","风险提示函","tbxy/TB_X002.ftl"),
    TB_X003("TB_X003","恒丰银行股份有限公司网络交易资金账户三方协议","tbxy/TB_X003.ftl"),
    TB_X004("HF_A001", "恒丰银行用户授权协议", "tbxy/hfUserAuthorizeProtocol.ftl"),
    TB_X005("TB_X005","数字证书服务协议（二）","tbxy/TB_X005.ftl"),
    TB_X006("TB_X006","数字证书服务协议（一）","tbxy/TB_X006.ftl"),
    TB_X007("TB_X007","随心投呗会员服务协议","tbxy/TB_X007.ftl"),
    //End 投呗协议类合同模版

    //Begin ADD:20170915;NOTE:贝格合同;
    BG_F001("BG_F001","借款协议","bg/loanProtocol.ftl"),//ok
    BG_F002("BG_F002","居间服务协议（出借人）","bg/LOANcreditConsultAndManageServiceProtocol.ftl"),//ok
    BG_F003("BG_F003","居间服务协议（借款人）","bg/BORROWcreditConsultAndManageServiceProtocol.ftl"),//ok
    BG_F004("BG_F004","省心系列产品服务协议","bg/comfortSeriesProductServiceProtocol.ftl"),//ok
    BG_F005("BG_F005","债权转让协议","bg/debtTransferAgreementEBAOProduct.ftl"),
    BG_F006("BG_F006","债权转让协议","bg/debtTransferAgreement.ftl"),
    //End ADD:20170915;NOTE:贝格合同;


    //Begin:BG 协议类合同
    BG_X001("BG_X001","贝尔在线会员服务协议","bgxy/BG_X001.ftl"),
    BG_X002("BG_X002","风险备用金服务协议","bgxy/BG_X002.ftl"),
    BG_X003("BG_X003","风险提示函","bgxy/BG_X003.ftl"),
    BG_X004("BG_X004","江西银行网络交易资金账户服务三方协议","bgxy/BG_X004.ftl"),
    BG_X005("BG_X005","客户电子账户智能存款说明书","bgxy/BG_X005.ftl"),
    BG_X006("BG_X006","数字证书服务协议（二）","bgxy/BG_X006.ftl"),
    BG_X007("BG_X007","数字证书服务协议（一）","bgxy/BG_X007.ftl"),
    BG_X008("BG_X008","用户授权协议","bgxy/BG_X008.ftl"),
    //End:BG 协议类合同



    //线下合同模版配置
    /**借款协议*/
    DW_F001("DW_F001","借款协议","erplinedown/loanProtocol.ftl"),
    /**借款协议*/
    DW_F004("DW_F004","借款协议","erplinedown/newLoanProtocol.ftl"),
    /**还款提示函*/
    DW_F002("DW_F002","还款提示函","erplinedown/repaymentTip.ftl"),
    /**居间服务协议*/
    DW_A001("DW_A001","居间服务协议","erplinedown/creditConsultAndManageServiceProtocol.ftl"),
    /**委托扣款授权书*/
    DW_A002("DW_A002","委托扣款授权书","erplinedown/entrustRepayment.ftl"),
    /**富友-苏州中资联投资管理有限公司专用账户协议*/
    DW_F003("DW_F003","富友-苏州中资联投资管理有限公司专用账户协议","erplinedown/fyAccountProtocol.ftl"),
    /**数字证书服务协议（金账户）*/
    DW_A003("DW_A003","数字证书服务协议（金账户）","erplinedown/digitalCertificateServiceAgreement.ftl"),
    /**数字证书服务协议（易保全）*/
    DW_A004("DW_A004","数字证书服务协议（易保全）","erplinedown/digitalCertificateServiceAgreementByYBQ.ftl"),
    /**委托转账说明书*/
    DW_A005("DW_A005","委托转账说明书","entrustTransfer.ftl"),


    /**借款协议 */
    EC_F001("EC_F001","借款协议","ec/loanProtocol.ftl"),
    /**借款协议(消费金融) */
    EC_F002("EC_F002","借款协议(消费金融)","ec/loanProtocolA008.ftl"),
    /**借款协议 (U信现金)*/
    EC_F003("EC_F003","借款协议 (U信现金)","ec/loanProtocolA009.ftl"),
    /**贷我走注册协议*/
    EC_A001("EC_A001","贷我走注册协议V2.3","ec/daiWoZouCertificateServiceAgreement.ftl"),
    /**征信查询授权书*/
    EC_A002("EC_A002","征信查询授权书","ec/aletterOfCreditForInquiry.ftl"),
    /**居间服务协议*/
    EC_A004("EC_A004","居间服务协议","ec/creditConsultAndManageServiceProtocol.ftl"),
    /**委托扣款授权书*/
    EC_A005("EC_A005","委托扣款授权书","ec/entrustRepayment.ftl"),
    /**数字证书  天威*/
    EC_A006("EC_A006","数字证书服务协议(天威)","ec/ECdigitalCertificateServiceAgreement.ftl"),
    /**数字证书  易保全*/
    EC_A007("EC_A007","数字证书服务协议(易保全)","ec/ECdigitalCertificateServiceAgreementByYBQ.ftl"),
    /**中资联富有协议*/
    EC_A008("EC_A008","富友—苏州中资联投资管理有限公司专用账户协议","ec/ECfyAccountProtocol.ftl"),
    /**商品消费分期确认书*/
    EC_A009("EC_A009","商品消费分期确认书","ec/goodsConsumptionInstallmentConfirmation.ftl"),



    /**恒丰银行*/
    /**用户授权协议 */
    HF_A001("HF_A001", "恒丰银行用户授权协议", "hfBank/hfUserAuthorizeProtocol.ftl"),
    HF_A002("HF_A002", "恒丰银行股份有限公司网络交易资金账户三方协议", "hfBank/hfTripartiteArrangement.ftl"),

    ZYD_F001("ZYD_F001","借款协议","zyd/loanProtocol.ftl"),
    ZYD_F002("ZYD_F002","融资服务协议","zyd/loanProtocol.ftl"),
    ZYD_A001("ZYD_A001","委托扣款授权书","zyd/entrustRepayment.ftl"),


    /**赎楼贷，借桥**/
    SLD_F001("SLD_F001", "借款协议", "sld/loanProtocol.ftl"),

    /**全款销售---汽车销售有限公司**/
    FULL_SALES("FULL_SALES","汽车全款销售合同","cd/fullSalesContract.ftl"),
    /**直租---汽车融资租赁**/
    DIRECT_RENT("DIRECT_RENT","汽车融资租赁合同","cd/directRentContract.ftl")
    ;

    ContractEnum(String code,String name, String templateName){
        this.code=code;
        this.name=name;
        this.templateName=templateName;
    }

    private String code;
    private String name;
    private String templateName;



    @Override
    public String toString(){
        return this.code+"|"+name+"|"+templateName;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getTemplateName() {
        return templateName;
    }


    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
