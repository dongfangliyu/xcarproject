package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.PurchaseRequisition;
import com.fintecher.sims.util.MyMapper;
import com.fintecher.sims.vo.QueryPurchaseRequisitionModel;
import com.fintecher.sims.vo.QueryPurchaseRequisitionParam;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 采购需求
 * @Date: Created on 2018/3/15 17:43
 * @Modified_By:
 */

public interface PurchaseRequisitionMapper extends MyMapper<PurchaseRequisition> {

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 分页查询采购需求
     * @Date: Created on 2018/3/15 17:58
     * @Modified_By:
     */
    List<QueryPurchaseRequisitionModel> queryPurchaseRequisition(QueryPurchaseRequisitionParam queryParam);
}
