package com.fintecher.sims.util;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: jwdstef
 * @Description: 字符串工具类
 * @Date 2017/6/2
 */
public class ZWStringUtils {
    /**
     * 判断对象为空
     *
     * @param obj 对象名
     * @return 是否为空
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String && ((String) obj).trim().equals("")) {
            return true;
        } else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断对象不为空
     *
     * @param obj 对象名
     * @return 是否不为空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
