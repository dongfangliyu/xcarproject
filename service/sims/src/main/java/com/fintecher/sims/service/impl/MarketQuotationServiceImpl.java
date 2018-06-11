package com.fintecher.sims.service.impl;

import com.fintecher.sims.entity.MarketQuotation;
import com.fintecher.sims.service.MarketQuotationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 市场行情
 * @Date: Created on 2018/3/15 16:25
 * @Modified_By:
 */


@Service
@Transactional(rollbackFor = Exception.class)
public class MarketQuotationServiceImpl extends BaseServiceImpl<MarketQuotation> implements MarketQuotationService {
}
