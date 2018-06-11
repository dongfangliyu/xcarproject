package com.fintecher.sims.mapper;

import com.fintecher.sims.entity.MarketQuotation;
import com.fintecher.sims.util.MyMapper;
import com.fintecher.sims.vo.QueryMarketQuotationModel;
import com.fintecher.sims.vo.QueryMarketQuotationParam;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 市场行情
 * @Date: Created on 2018/3/15 16:26
 * @Modified_By:
 */

public interface MarketQuotationMapper extends MyMapper<MarketQuotation> {

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 多条件查询市场行情
     * @Date: Created on 2018/3/15 16:35
     * @Modified_By:
     */

    List<QueryMarketQuotationModel> queryMarketQuotation(QueryMarketQuotationParam queryMarketQuotationParam);
}
