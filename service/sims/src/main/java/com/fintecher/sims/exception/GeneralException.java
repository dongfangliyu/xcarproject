package com.fintecher.sims.exception;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 自定义异常
 * @Date: Created on 2018/3/6 18:11
 * @Modified By:
 */

public class GeneralException extends RuntimeException {
    public GeneralException(String msg) {
        super(msg);
    }
}
