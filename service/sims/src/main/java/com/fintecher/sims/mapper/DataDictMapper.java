package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.DataDict;
import com.fintecher.sims.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/1414:53
 * @Modified By：
 */
public interface DataDictMapper extends MyMapper<DataDict> {
    /**
     * @System:
     * @Auther: dwx
     * @Description:根据数据字典类型码查询数据
     * @Modified By：
     */
    List<DataDict> findDataDictByTypeCode(@Param("code") String code,
                                          @Param("name") String name);
    /**
     * @System:
     * @Auther: dwx
     * @Description:查询数据字典类型对应的数据字典项
     * @Modified By：
     */
    List<DataDict> getAllDataDict(@Param("code") String code,
                                  @Param("name") String name);


    /**
     * @System:
     * @Auther: dwx
     * @Description: 获取数据字典项最大ID
     * @Modified By:
     */
    Integer getMaxId();

    /**
     * @System:
     * @Auther: dwx
     * @Description: 获取最大排序
     * @Modified By:
     */
    Integer getMaxSort(@Param("typeCode") String typeCode);

}
