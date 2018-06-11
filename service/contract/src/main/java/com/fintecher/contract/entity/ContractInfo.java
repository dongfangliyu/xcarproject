package com.fintecher.contract.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author wxc
 * @Data 2018/2/2 13:45
 * @Description
 */
@Data
@Table(name = "contract_info")
public class ContractInfo extends BaseEntity{

    // 0签章中，1签章成功，2签章失败，3不需要签章
    public static final String CA_SUC = "1"; // 签章成功
    public static final String CA_LOADING = "0";// 签章中
    public static final String CA_EXEC = "2";// 签章异常
    public static final String CA_FALSE = "3";// 不需要签章

    // 1生成中，2生成成功，3生成失败，4上传失败
    public static final String PDF_LOADING = "1";// 生成中
    public static final String PDF_SUC = "2"; // 生成成功
    public static final String PDF_FALSE = "3";// 生成失败
    public static final String PDF_EXEC = "4";// 上传失败

    public static final String STATUS_TRUE = "1";	// 成功
    public static final String STATUS_FALSE = "0"; // 失败

    //0:数据生成中,1:合同生产中,2:CA签章中，3:批次完成，4:作废/失效
    public static final String STATUS_DATA_LOADING = "0"; //
    public static final String STATUS_CONTRACT_LOADING = "1"; //
    public static final String STATUS_CA_LOADING = "2"; //
    public static final String STATUS_DONE = "3"; //
    public static final String STATUS_ABANDON = "4"; //


    @Column(name = "contract_number")
    private String contractNumber; //	VARCHAR	100 	合同编号	合同编号

    @Column(name = "contract_batch_id")
    private String contractBatchId; //	VARCHAR	100 	批次号信息

    @Column(name = "contract_template_url")
    private String contractTemplateUrl; //	VARCHAR	300 	模板地址

    @Column(name = "contract_pdf_status")
    private String contractPdfStatus; //	VARCHAR	2 	pdf 生产状态	生成PDF状态（0不需要生成，1生成中，2生成成功，3生成失败，4上传失败）

    @Column(name = "contract_ca_status")
    private String contractCaStatus; //	VARCHAR	2 	CA签章状态	CA签章状态（0签章中，1签章成功，2签章失败，3不需要签章）

    @Column(name = "order_number")
    private String orderNumber; //	VARCHAR	100	订单编号	合同服务于那个订单

    @Column(name = "pdf_status")
    private String pdfStatus; //	VARCHAR	2	pdf生成状态	0:未上传，1：上传成功

    @Column(name = "ca_status")
    private String caStatus; //	VARCHAR	2	CA签章状态	0:未上传，1：上传成功

    @Column(name = "pdf_url")
    private String pdfUrl; //	VARCHAR	400	pdf保存地址

    @Column(name = "ca_pdf_url")
    private String caPdfUrl; //	VARCHAR	400	签章后的PDF保存地址

    @Column(name = "contract_name")
    private String contractName; //	VARCHAR	100	合同名称

    @Column(name = "contract_data_json")
    private String contractDataJson; //	VARCHAR	1500	合同生成必要数据json

    @Column(name = "create_time")
    private String createTime; //	VARCHAR	20	创建时间

    @Column(name = "status")
    private String status; //	VARCHAR	10 	批次状态	0:数据生成中,1:批次处理异常:,2:批次完成，3:作废/失效

    @Column(name = "contract_enum")
    private String contractEnum;	//合同枚举标识code

    @Column(name = "unique_code1")
    private String uniqueCode1; //	自带唯一标识

    @Column(name = "unique_code2")
    private String uniqueCode2; //

    @Column(name = "unique_code3")
    private String uniqueCode3; //

    @Column(name = "unique_code4")
    private String uniqueCode4; //

    @Column(name = "finish_time")
    private String finishTime; //	VARCHAR	20	完成时间

    @Column(name = "isasyncSign")
    private String isasyncSign;//	VARCHAR	10 		async:异步,sync:同步

    @Column(name = "num")
    private String number;//	VARCHAR	10 		CA处理次数，超过2次，不在处理

    @Column(name = "crm_order_id")
    private Long orderId;
}
