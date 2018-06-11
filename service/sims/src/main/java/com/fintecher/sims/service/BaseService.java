package com.fintecher.sims.service;


import com.fintecher.sims.entity.BaseEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 查询所有数据
     *
     * @return
     */
    List<T> findAll();

    /**
     * 根据条件查询一条数据，如果有多条数据会抛出异常
     *
     * @param record
     * @return
     */
    T findOne(T record);

    /**
     * 根据条件查询数据列表
     *
     * @param record
     * @return
     */
    List<T> findListByWhere(T record);

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param record
     * @return
     */
    PageInfo<T> findPageListByWhere(Integer pageNum, Integer pageSize, T record);

    /**
     * 新增数据，返回成功的条数
     *
     * @param record
     * @return
     */
    Integer save(T record);

    /**
     * 新增数据，使用不为null的字段，返回成功的条数
     *
     * @param record
     * @return
     */
    Integer saveSelective(T record);

    /**
     * 批量保存，返回保存的条数
     *
     * @param list
     * @return
     */
    int saveList(List<T> list);

    /**
     * 修改数据，返回成功的条数
     *
     * @param record
     * @return
     */
    Integer update(T record);

    /**
     * 修改数据，使用不为null的字段，返回成功的条数
     *
     * @param record
     * @return
     */
    Integer updateSelective(T record);

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    Integer deleteById(Long id);

    /**
     * 批量删除
     *
     * @param clazz
     * @param property
     * @param values
     * @return
     */
    Integer deleteByIds(Class<T> clazz, String property, List<Object> values);

    /**
     * 根据条件做删除
     *
     * @param record
     * @return
     */
    Integer deleteByWhere(T record);

    /**
     * 自定义查询
     *
     * @param example
     * @return
     */
    List<T> selectByExample(Object example);

    /**
     * 根据Example条件进行查询总数
     *
     * @param example
     * @return
     */
    int selectCountByExample(Object example);


}
