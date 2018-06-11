package com.fintecher.sims.service;

import com.fintecher.sims.entity.MaterialCategory;
import com.fintecher.sims.vo.MaterialCategoryModel;
import com.fintecher.sims.vo.UserModel;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/6 17:46
 * @Modified By:
 */

public interface MaterialCategoryService extends BaseService<MaterialCategory> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 新增车辆素材类别
     * @Modified By:
     */
    void createCategory(MaterialCategoryModel model, UserModel user) throws Exception;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 修改车辆素材类别
     * @Modified By:
     */
    void modifyCategory(MaterialCategoryModel model, UserModel user) throws Exception;
}
