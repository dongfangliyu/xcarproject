package com.fintecher.common.vo.manage;

import io.swagger.annotations.ApiModelProperty;

public class WebSocketMessage<T> {
    @ApiModelProperty(value = "数据类型")
    private String messageType;

    @ApiModelProperty(value = "数据")
    private T data;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public enum MsgType{

        WARN_REMINDER("msg_type_warn","预警提醒"),VIOL_REMINDER("msg_type_viol","违规提醒");

        private String value;
        private String remark;

        MsgType(String value,String remark){
            this.value = value;
            this.remark = remark;
        }

        public String getValue() {
            return value;
        }

        public String getRemark() {
            return remark;
        }
    }
}
