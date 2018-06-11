package com.fintecher.common.entity.message;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @Author: jwdstef
 * @Description: 短信消息
 * @Date 2017/12/07
 */
@Data
public class EmailMessage implements Serializable{
    private String id;
    private String sendTo;
    private String title;
    private Map<String, Object> model;
    private String templateContent;
    private Date sendTime;
}
