package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.MaterialCategory;
import com.fintecher.sims.util.MyMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/6 17:48
 * @Modified By:
 */

public interface MaterialCategoryMapper extends MyMapper<MaterialCategory> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 检查类别名称唯一性
     * @Modified By:
     */
    MaterialCategory checkUniqueness(@Param("name") String name);
}
