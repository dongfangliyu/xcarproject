package com.fintecher.contract.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @System: 车贷金融
 * @Auther: liqun
 * @Description:
 * @Date:Created on 2018/1/9 15:59
 * @Modified By：
 */
@ApiModel(description = "合同上传资料")
@Data
@Table(name = "contract_upload_file")
public class ContractUploadFile extends BaseEntity {

    @ApiModelProperty(value = "订单id", notes = "订单id")
    @Column(name = "order_id")
    private Long orderId;

    @ApiModelProperty(value = "资料原名称", notes = "资料原名称")
    @Column(name = "origin_name")
    private String originName;

    @ApiModelProperty(value = "资料上传名称", notes = "资料上传名称")
    @Column(name = "upload_name")
    private String uploadName;

    @ApiModelProperty(value = "合同类型", notes = "合同类型")
    @Column(name = "material_type")
    private String materialType;

    @ApiModelProperty(value = "资料大小", notes = "资料大小")
    @Column(name = "data_size")
    private Integer dataSize;

    @ApiModelProperty(value = "上传资料路径", notes = "上传资料路径")
    @Column(name = "material_url")
    private String materialUrl;

    @ApiModelProperty(value = "是否删除", notes = "是否删除")
    @Column(name = "is_delete")
    private Integer isDelete;

    @ApiModelProperty(value = "操作员", notes = "操作员")
    @Column(name = "operator")
    private Long operator;

    @ApiModelProperty(value = "操作时间", notes = "操作时间")
    @Column(name = "operate_time")
    private Date operateTime;

}
