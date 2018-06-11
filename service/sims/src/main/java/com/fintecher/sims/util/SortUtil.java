package com.fintecher.sims.util;

import com.google.common.base.Splitter;

import java.lang.reflect.Field;
import java.util.Iterator;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description:
 * @Date: Created on 2018/3/13 18:08
 * @Modified_By:
 */

public class SortUtil {

    private static final String AND_CHAR = "&";
    private static final String COMMA_CHAR = ",";
    private static final String BLOCK_CHAR = " ";

    public static String convertSql(Class c, String sortStr) {
        if (sortStr == null || sortStr.trim().isEmpty()) {
            return null;
        }
        Splitter splitter = Splitter.on(COMMA_CHAR).trimResults().omitEmptyStrings();
        Iterable<String> iterable = Splitter.on(AND_CHAR).trimResults().omitEmptyStrings().split(sortStr);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> sort;
        Field field;

        for (String s : iterable) {
            sort = splitter.split(s).iterator();
            if (sort.hasNext()) {
                try {
                    field = c.getDeclaredField(sort.next());
                } catch (NoSuchFieldException e) {
                    continue;
                }
                stringBuilder.append(field.getName()).append(sort.hasNext() ? BLOCK_CHAR.concat(getSort(sort.next())) : BLOCK_CHAR.concat(SortEnum.ASC.name()).concat(COMMA_CHAR));
            }
        }
        if (stringBuilder.toString().endsWith(COMMA_CHAR)) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString().trim().isEmpty() ? null : stringBuilder.toString().trim();
    }

    private static String getSort(String sort) {
        if (SortEnum.DESC.name().equalsIgnoreCase(sort)) {
            return SortEnum.DESC.name();
        } else {
            return SortEnum.ASC.name();
        }
    }

    private enum SortEnum {
        ASC, DESC
    }
}
