package com.fintecher.sims.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 库放车技术状态与措施记录附件
 * @Date: Created on 2018/3/15 15:31
 * @Modified_By:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "invoicing_measures_record_file")
@ApiModel(description = "库放车技术状态与措施记录附件")
public class MeasuresRecordFile extends BaseEntity {

    @ApiModelProperty(value = "后续措施ID(外键)")
    private Long measuresId;

    @ApiModelProperty(value = "文件ID(外键)")
    private String fileId;

    @ApiModelProperty(value = "文件类型(外键：数据字典)")
    private Long fileType;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件大小")
    private String fileSize;

    @ApiModelProperty(value = "创建人(外键)")
    private Long operator;

    @ApiModelProperty(value = "上传时间")
    private Date operateTime;
}
