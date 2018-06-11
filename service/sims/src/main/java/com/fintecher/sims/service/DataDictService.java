package com.fintecher.sims.service;


import com.fintecher.sims.entity.DataDict;

import java.util.List;

/**
 * Created by Administrator on 2017/6/13.
 */
public interface DataDictService {
    List<DataDict> findDataDictByTypeCode(String code, String name);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询数据字典项
     * @Modified By:
     */
    List<DataDict> getAll();

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 查询数据字典类型对应的数据字典项
     * @Modified By:
     */
    List<DataDict> getAllDataDict(String code, String name);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 删除数据字典项
     * @Modified By:
     */
    Integer deleteDataDict(DataDict dataDict);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 获取数据字典项最大ID
     * @Modified By:
     */
    Integer getMaxId();

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 保存数据字典项
     * @Modified By:
     */
    void saveDataDict(DataDict dataDict);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 更新数据字典项
     * @Modified By:
     */
    void updateDataDict(DataDict dataDict);

    /**
     * @System: 车贷金融
     * @Auther: xiaqun
     * @Description: 获取最大排序
     * @Modified By:
     */
    Integer getMaxSort(String typeCode);
}
