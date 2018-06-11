package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.DataDictType;
import com.fintecher.sims.mapper.DataDictTypeMapper;
import com.fintecher.sims.service.DataDictTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @System: 进销存
 * @Auther: dwx
 * @Description:
 * @Date: Created on 2018/3/14 14:46
 * @Modified_By:
 */

@Transactional(rollbackFor = Exception.class)
@Service
public class DataDictTypeServiceImpl implements DataDictTypeService {
    @Resource
    DataDictTypeMapper dataDictTypeMapper;

    /**
     * @System:
     * @Auther: dwx
     * @Description: 查询所有数据字典类型
     * @Modified By:
     */
    public List<DataDictType> getAllDictType(DataDictType dataDictType) {
        return dataDictTypeMapper.select(dataDictType);
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 获取数据字典项类型最大ID
     * @Modified By:
     */
    @Override
    public Integer getMaxId() {
        return dataDictTypeMapper.getMaxId();
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 保存数据字典项类型
     * @Modified By:
     */
    @Override
    public Integer saveDataDict(DataDictType dataDictType) {
        return dataDictTypeMapper.insert(dataDictType);
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 更新数据字典项类型
     * @Modified By:
     */
    @Override
    public Integer updateDataDict(DataDictType dataDictType) {
        return dataDictTypeMapper.updateByPrimaryKey(dataDictType);
    }
}
