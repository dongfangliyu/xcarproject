package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.BaseEntity;
import com.fintecher.sims.entity.MaterialItem;
import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.mapper.MaterialItemMapper;
import com.fintecher.sims.service.MaterialItemService;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.MaterialItemModel;
import com.fintecher.sims.vo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;


/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/6 17:54
 * @Modified By:
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialItemServiceImpl extends BaseServiceImpl<MaterialItem> implements MaterialItemService {
    @Autowired
    private MaterialItemMapper materialItemMapper;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 根据车辆素材类别ID查询车辆素材
     * @Modified By:
     */
    @Override
    public List<MaterialItem> getAllItem(Long id) throws Exception {
        return materialItemMapper.getAllItem(id);
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 新增车辆素材
     * @Modified By:
     */
    @Override
    public void createMaterialItem(MaterialItemModel model, UserModel user) throws Exception {
        MaterialItem materialItem = new MaterialItem();
        materialItem.setMaterialCategoryId(model.getMaterialCategoryId());
        materialItem.setName(model.getName());
        materialItem.setIsNecessary(BaseEntity.Basis.NO.getValue());
        materialItem.setOperator(user.getId());
        materialItem.setOperateTime(ZWDateUtil.getNowDateTime());
        materialItem.setUpdater(user.getId());
        materialItem.setUpdateTime(ZWDateUtil.getNowDateTime());
        save(materialItem);
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 修改车辆素材
     * @Modified By:
     */
    @Override
    public void modifyMaterialItem(MaterialItemModel model, UserModel user) throws Exception {
        MaterialItem materialItem = findById(model.getId());
        if (Objects.isNull(materialItem)) {
            throw new GeneralException("该客户素材不存在");
        }
        materialItem.setName(model.getName());
        materialItem.setUpdater(user.getId());
        materialItem.setUpdateTime(ZWDateUtil.getNowDateTime());
        update(materialItem);
    }
}
