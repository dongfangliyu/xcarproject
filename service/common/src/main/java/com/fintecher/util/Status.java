package com.fintecher.util;

import java.util.Objects;

/**
 * 状态的枚举
 * Created by ChenChang on 2017/3/9.
 */
public enum Status {
    Enable(0), Disable(1);
    private Integer value;

    Status(Integer value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * 通过Integer值查询枚举
     *
     * @param value
     * @return
     */
    public static Status getStateByValue(Integer value) {
        for (Status state : Status.values()) {
            if (Objects.equals(value, state.getValue())) {
                return state;
            }
        }
        return Disable;
    }
}
