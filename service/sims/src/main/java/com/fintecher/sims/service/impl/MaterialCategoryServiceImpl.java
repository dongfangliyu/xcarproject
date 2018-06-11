package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.MaterialCategory;
import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.mapper.MaterialCategoryMapper;
import com.fintecher.sims.service.MaterialCategoryService;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.MaterialCategoryModel;
import com.fintecher.sims.vo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/6 17:47
 * @Modified By:
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialCategoryServiceImpl extends BaseServiceImpl<MaterialCategory> implements MaterialCategoryService {
    @Autowired
    private MaterialCategoryMapper materialCategoryMapper;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 新增车辆素材类别
     * @Modified By:
     */
    @Override
    public void createCategory(MaterialCategoryModel model, UserModel user) throws Exception {
        //检查名称唯一性
        MaterialCategory result = materialCategoryMapper.checkUniqueness(model.getName());
        if (Objects.nonNull(result)) {
            throw new GeneralException("车辆素材名称重复");
        }
        MaterialCategory target = new MaterialCategory();
        target.setName(model.getName());
        target.setOperator(user.getId());
        target.setOperateTime(ZWDateUtil.getNowDateTime());
        target.setUpdater(user.getId());
        target.setUpdateTime(ZWDateUtil.getNowDateTime());
        save(target);
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 修改车辆素材类别
     * @Modified By:
     */
    @Override
    public void modifyCategory(MaterialCategoryModel model, UserModel user) throws Exception {
        //检查名称唯一性
        MaterialCategory result = materialCategoryMapper.checkUniqueness(model.getName());
        if (Objects.nonNull(result)) {
            throw new GeneralException("车辆素材名称重复");
        }
        MaterialCategory target = findById(model.getId());
        target.setName(model.getName());
        target.setUpdater(user.getId());
        target.setUpdateTime(ZWDateUtil.getNowDateTime());
        update(target);
    }
}
