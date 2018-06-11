package com.fintecher.sims.service;


import com.fintecher.sims.entity.DataDictType;

import java.util.List;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface DataDictTypeService {
    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询所有数据字典类型
     * @Modified By:
     */
    List<DataDictType> getAllDictType(DataDictType dataDictType);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 获取数据字典项类型最大ID
     * @Modified By:
     */
    Integer getMaxId();

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 保存数据字典项类型
     * @Modified By:
     */
    Integer saveDataDict(DataDictType dataDictType);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 更新数据字典项类型
     * @Modified By:
     */
    Integer updateDataDict(DataDictType dataDictType);
}
