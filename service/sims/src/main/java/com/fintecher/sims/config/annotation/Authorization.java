package com.fintecher.sims.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: jwdstef
 * @Description: 在Controller的方法上使用此注解，该方法在映射时会检查用户是否登录，未登录返回401错误
 * @Date 2017/5/27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
}
