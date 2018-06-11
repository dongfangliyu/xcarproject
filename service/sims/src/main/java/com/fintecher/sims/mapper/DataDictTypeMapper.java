package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.DataDictType;
import com.fintecher.sims.util.MyMapper;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/1414:56
 * @Modified By：
 */
public interface DataDictTypeMapper extends MyMapper<DataDictType> {
    /**
     * @System:
     * @Auther: dwx
     * @Description: 获取数据字典项类型最大ID
     * @Modified By:
     */
    Integer getMaxId();
}
