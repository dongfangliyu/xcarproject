package com.fintecher.common.entity.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: jwdstef
 * @Description: 上传文件进度消息
 * @Date 2017/12/05
 */
@Data
public class ProgressMessage implements Serializable {
    private String userId;
    private String text;
    private Integer total;
    private Integer current;
}
