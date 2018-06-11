package com.fintecher.sims.service;

import com.fintecher.sims.entity.PurchaseOrder;
import com.fintecher.sims.vo.PurchaseOrderParam;
import com.fintecher.sims.vo.UserModel;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/16 17:25
 * @Modified By:
 */

public interface PurchaseOrderService extends BaseService<PurchaseOrder> {
    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 新增采购单
     * @Modified By:
     */
    void createPurchaseOrder(PurchaseOrderParam param, UserModel user);
}
