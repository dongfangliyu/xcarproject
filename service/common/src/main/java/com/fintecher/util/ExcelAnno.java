package com.fintecher.util;

import java.lang.annotation.*;

/**
 * @Author: PeiShouWen
 * @Description: Excel导入注解
 * @Date 15:04 2017/3/3
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ExcelAnno {
    /**
     * 在excel文件中某列数据的名称
     *
     * @return 名称
     */
    String cellName() default "";

    /**
     * 实体中的字段类型
     * @return
     */

    public FieldType fieldType() default FieldType.STRING;
    /**
     * 在excel中列的顺序，从小到大排
     *
     * @return 顺序
     */
    int order() default 0;

    enum FieldType{
        STRING, NUM, FLOATNUM, DATE
    }
}
