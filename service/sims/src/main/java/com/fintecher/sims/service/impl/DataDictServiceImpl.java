package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.DataDict;
import com.fintecher.sims.mapper.DataDictMapper;
import com.fintecher.sims.service.DataDictService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @System: 进销存
 * @Auther: dwx
 * @Description:
 * @Date: Created on 2018/3/14 15:46
 * @Modified_By:
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class DataDictServiceImpl implements DataDictService {
    @Resource
    private DataDictMapper dataDictMapper;

    @Override
    public List<DataDict> findDataDictByTypeCode(String code, String name) {
        return dataDictMapper.findDataDictByTypeCode(code, name);
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 查询数据字典项
     * @Modified By:
     */
    @Override
    @Cacheable(value = "dataDictCache", key = "'petstore:dataDict:all'")
    public List<DataDict> getAll() {
        return dataDictMapper.selectAll();
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 查询数据字典类型对应的数据字典项
     * @Modified By:
     */
    @Override
    @Cacheable(value = "dataDictCache", key = "'petstore:dataDict:all'")
    public List<DataDict> getAllDataDict(String code, String name) {
        return dataDictMapper.getAllDataDict(code, name);
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 删除数据字典项
     * @Modified By:
     */
    @Override
    @CacheEvict(value = "dataDictCache", key = "'petstore:dataDict:all'")
    public Integer deleteDataDict(DataDict dataDict) {
        return dataDictMapper.delete(dataDict);
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 获取数据字典项最大ID
     * @Modified By:
     */
    @Override
    public Integer getMaxId() {
        return dataDictMapper.getMaxId();
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 保存数据字典项
     * @Modified By:
     */
    @Override
    @CacheEvict(value = "dataDictCache", key = "'petstore:dataDict:all'")
    public void saveDataDict(DataDict dataDict) {
        dataDictMapper.insert(dataDict);
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 更新数据字典项
     * @Modified By:
     */
    @Override
    @CacheEvict(value = "dataDictCache", key = "'petstore:dataDict:all'")
    public void updateDataDict(DataDict dataDict) {
        dataDictMapper.updateByPrimaryKey(dataDict);
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 获取最大排序
     * @Modified By:
     */
    @Override
    public Integer getMaxSort(String typeCode) {
        return dataDictMapper.getMaxSort(typeCode);
    }
}
