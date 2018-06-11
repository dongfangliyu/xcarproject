package com.fintecher.sims.service;

import com.fintecher.sims.entity.MaterialItem;
import com.fintecher.sims.vo.MaterialItemModel;
import com.fintecher.sims.vo.UserModel;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/6 17:53
 * @Modified By:
 */

public interface MaterialItemService extends BaseService<MaterialItem> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 根据车辆素材类别ID查询车辆素材
     * @Modified By:
     */
    List<MaterialItem> getAllItem(Long id) throws Exception;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 新增车辆素材
     * @Modified By:
     */
    void createMaterialItem(MaterialItemModel model, UserModel user) throws Exception;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 修改车辆素材
     * @Modified By:
     */
    void modifyMaterialItem(MaterialItemModel model, UserModel user) throws Exception;
}
