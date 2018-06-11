package com.fintecher.sims.vo;

import java.io.Serializable;

/**
 * 返回Response对象
 * Created by jwdstef on 2017/5/27.
 */
public class ResponseResult<T> implements Serializable {
    public enum Status {
        SUCCESS, FAILURE
    }

    private String status;
    private String msg;
    private T object;

    public ResponseResult() {
    }

    public ResponseResult(Status status, String msg) {
        this.status = status.name();
        this.msg = msg;
    }

    public ResponseResult(Status status, String msg, T object) {
        this.status = status.name();
        this.msg = msg;
        this.object = object;
    }

    public ResponseResult(Status status, T object) {
        this.status = status.name();
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseResult<?> that = (ResponseResult<?>) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;
        return object != null ? object.equals(that.object) : that.object == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (object != null ? object.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }
}
