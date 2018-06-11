package com.fintecher.contract.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author wxc
 * @Data 2018/2/2 12:04
 * @Description
 */
@Data
@Table(name = "contract_batch")
public class ContractBatch extends BaseEntity{
    @Column(name = "batch_number")
    private String batchNumber;//	VARCHAR	100 	批次号	批次号，每次递增

    @Column(name = "relation_number")
    private String relationNumber;//	VARCHAR	100 	关联编号	可以是订单号，可以是ID，用于关联信息

    @Column(name = "create_time")
    private String createTime;//	VARCHAR	20 	创建时间

    @Column(name = "category_one")
    private String categoryOne;//	VARCHAR	2 	产品类型	(3助业、4工薪、5车贷、6零用、7赎楼、8消费金融、9U信、10宽贷)

    @Column(name = "category_two")
    private String categoryTwo;//	VARCHAR	2 		0：贝格，1：ERP，2：投呗

    @Column(name = "category_three")
    private String categoryThree;//	VARCHAR	2

    @Column(name = "category_four")
    private String categoryFour;//	VARCHAR	2

    @Column(name = "category_five")
    private String categoryFive;//	VARCHAR	2 		0：poc,1:boc

    @Column(name = "category_six")
    private String categorySix;//	VARCHAR	2

    @Column(name = "category_seven")
    private String categorySeven;//	VARCHAR	2

    @Column(name = "ftp_status")
    private String ftpStatus;//	VARCHAR	2 		0:未上传，1：上传成功

    @Column(name = "ca_channel")
    private String caChannel;//	VARCHAR	2 		CA签约通道(000023-0001:天威 ；000023-0002：易保全)

    @Column(name = "issync")
    private String issync;//	VARCHAR	10 		async:异步,sync:同步

    @Column(name = "isasyncSign")
    private String isasyncSign;//	VARCHAR	10 		async:异步,sync:同步

    @Column(name = "need_pdf")
    private String needPdf;//	VARCHAR	10 	本批次需要生产的pdf数量

    @Column(name = "need_ca")
    private String needCa;//	VARCHAR	10 	本批次需要签章CA的数量

    @Column(name = "need_succ_pdf")
    private String needSuccPdf;//	VARCHAR	10 	本批次成功生产PDF的数量

    @Column(name = "need_succ_ca")
    private String needSuccCa;//	VARCHAR	10 	本批次成功签章的数量

    @Column(name = "status")
    private String status;//	VARCHAR	10 	批次状态	0:数据生成中,1:合同生产中,2:批次完成，3:作废/失效

    @Column(name = "is_call_back")
    private String isCallBack;//	VARCHAR	10 	是否需要毁掉	0：不需要，1：需要 （需要回掉回掉rul必须有值

    @Column(name = "cal_back_url")
    private String calBackUrl;//	VARCHAR	200 	回调通知url

    @Column(name = "back_count")
    private String backCount;//	VARCHAR	10 	回调通知次数(每1小时通知一次，次数<=3)

    @Column(name = "back_status")
    private String backStatus;//	VARCHAR	10 	回调状态(0：等待通知，1：通知成功，2：通知失败)

    @Column(name = "back_time")
    private String backTime;//	VARCHAR	20 	最后一次通知时间

    @Column(name = "async_pdf_status")
    private String asyncPdfStatus;//	VARCHAR	2 	异步签章生成pdf是否全部成功（0:否，1，是）

    @Column(name = "batch_data_json")
    private String batchDataJson; //	VARCHAR	1500	合同生成必要数据json

    @Column(name = "emp_id")
    private String empId;//	VARCHAR	20 	最后一次通知时间

    @Column(name = "type_code")
    private String typeCode;//	VARCHAR	20 	最后一次通知时间

    @Column(name = "contract_model_code")
    private String contractModelCode;//	VARCHAR	20 	最后一次通知时间
}
