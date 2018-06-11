package com.fintecher.sims.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description:
 * @Date: Created on 2018/3/13 20:35
 * @Modified_By:
 */

@Data
public class EditBaseVehicleParam {

    @NotNull(message = "车辆不能为空")
    @ApiModelProperty(value = "车辆ID")
    private Long id;

    @ApiModelProperty(value = "车架号")
    private String frameNumber;

    @ApiModelProperty(value = "生产日期")
    private Date productionDate;

    @ApiModelProperty(value = "车牌号码")
    private String plateNumber;

    @ApiModelProperty(value = "排放标准")
    private String emissioStandard;

    @ApiModelProperty(value = "上牌日期")
    private Date plateDate;

    @ApiModelProperty(value = "合格证号")
    private String certificateNumber;

    @ApiModelProperty(value = "车辆隶属")
    private String subjection;

    @ApiModelProperty(value = "发动机号")
    private String engineNumber;

    @ApiModelProperty(value = "入库日期")
    private Date storageInDate;

    @ApiModelProperty(value = "厂商ID(外键)")
    private Long manufacturerId;

    @ApiModelProperty(value = "GPS状态(外键：数据字典)")
    private Long gpsStatus;

    @ApiModelProperty(value = "车辆性质(外键：数据字典)")
    private Long properties;

    @ApiModelProperty(value = "车况(外键：数据字典)")
    private Long condition;

    @ApiModelProperty(value = "车况异常说明")
    private String abnormalExplain;


}
