package com.fintecher.contract.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author wxc
 * @Data 2018/2/2 16:03
 * @Description
 */
@Data
@Table(name = "contract_record")
public class ContractRecord extends BaseEntity{
    @Column(name = "contract_number")
    private String contractNumber; //	VARCHAR	100 	合同编号

    @Column(name = "contract_info_id")
    private String contractInfoId; //	VARCHAR	100	合同信息ID

    @Column(name = "create_time")
    private String createTime; //	VARCHAR	20	创建时间

    @Column(name = "pdf_status")
    private String pdfStatus; //	VARCHAR	20	0:本次需要重新创建,1：本次不需要创建

    @Column(name = "ca_status")
    private String caStatus; //	VARCHAR	20	0:本次需要重新签章,1：本次不需要签章

    @Column(name = "pdf_result")
    private String pdfResult; //	VARCHAR	300	pdf 创建返回结果，如果异常，记录异常代码

    @Column(name = "ca_result")
    private String caResult; //	VARCHAR	300	CA 签章返回结果，如果异常，记录异常代码
}
