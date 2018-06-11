package com.fintecher.sims.service;

import com.fintecher.sims.entity.PurchaseRequisition;
import com.fintecher.sims.vo.PurchaseRequisitionParam;
import com.fintecher.sims.vo.UserModel;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 采购需求
 * @Date: Created on 2018/3/15 17:43
 * @Modified_By:
 */

public interface PurchaseRequisitionService extends BaseService<PurchaseRequisition> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 门店需求填报
     * @Modified By:
     */
    void createPurchaseRequisition(PurchaseRequisitionParam param, UserModel user) throws Exception;
}
