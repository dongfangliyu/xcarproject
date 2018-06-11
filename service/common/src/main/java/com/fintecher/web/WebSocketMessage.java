package com.fintecher.web;

/**
 * Created by ChenChang on 2017/4/5.
 */
public class WebSocketMessage<T> {
    private Long unReadeCount;
    private String messageType;
    T data;

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public WebSocketMessage(String messageType) {
        this.messageType = messageType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getUnReadeCount() {
        return unReadeCount;
    }

    public void setUnReadeCount(Long unReadeCount) {
        this.unReadeCount = unReadeCount;
    }
}
