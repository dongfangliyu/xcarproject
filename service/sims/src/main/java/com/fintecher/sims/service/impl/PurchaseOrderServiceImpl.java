package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.PurchaseOrder;
import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.mapper.PurchaseOrderMapper;
import com.fintecher.sims.service.PurchaseOrderService;
import com.fintecher.sims.util.BeanUtil;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.PurchaseOrderParam;
import com.fintecher.sims.vo.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.lang.management.GarbageCollectorMXBean;
import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description:
 * @Date: Created on 2018/3/16 17:25
 * @Modified By:
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class PurchaseOrderServiceImpl extends BaseServiceImpl<PurchaseOrder> implements PurchaseOrderService {
    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 新增采购单
     * @Modified By:
     */
    @Override
    public void createPurchaseOrder(PurchaseOrderParam param, UserModel user) {
        Example.Criteria criteria = new Example(PurchaseOrder.class).createCriteria();
        criteria.andEqualTo("purchaseNumber", param.getPurchaseNumber());
        List<PurchaseOrder> recordList = purchaseOrderMapper.selectByExample(criteria);
        if (!recordList.isEmpty()) {
            throw new GeneralException("采购单号已存在");
        }
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        BeanUtil.copyPropertiesIgnoreNull(param, purchaseOrder);
        //TODO
//        purchaseOrder.setApplyStatus(); //申请状态
//        purchaseOrder.setApplicant(user.getId()); //申请人
//        purchaseOrder.setApplyTime(ZWDateUtil.getNowDateTime()); //申请时间

    }
}
