package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.MaterialItem;
import com.fintecher.sims.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/6 17:56
 * @Modified By:
 */

public interface MaterialItemMapper extends MyMapper<MaterialItem> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 根据车辆素材类别ID查询车辆素材
     * @Modified By:
     */
    List<MaterialItem> getAllItem(@Param("id") Long id);
}
