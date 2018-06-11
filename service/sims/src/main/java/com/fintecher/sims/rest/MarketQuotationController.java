package com.fintecher.sims.rest;

import com.fintecher.sims.entity.MarketQuotation;
import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.mapper.MarketQuotationMapper;
import com.fintecher.sims.service.MarketQuotationService;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 市场行情管理
 * @Date: Created on 2018/3/15 16:27
 * @Modified_By:
 */

@RestController
@RequestMapping("/marketQuotation")
@Api(value = "市场行情管理", description = "市场行情管理")
public class MarketQuotationController extends BaseController {

    @Autowired
    private MarketQuotationMapper marketQuotationMapper;

    @Autowired
    private MarketQuotationService marketQuotationService;

    @Autowired
    private ModelMapper modelMapper;


    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 分页市场行情信息
     * @Date: Created on 2018/3/15 16:35
     * @Modified_By:
     */
    @GetMapping("/queryMarketQuotation")
    @ApiOperation(value = "分页市场行情信息", notes = "分页市场行情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. "),
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    })
    public ResponseResult<PageInfo<QueryMarketQuotationModel>> queryMarketQuotation(QueryMarketQuotationParam queryMarketQuotationParam, PageParam pageParam,
                                                                                    @RequestHeader(value = "authorization") String authorization) {
        UserModel user;
        try {
            user = getUserByToken(authorization);
        } catch (GeneralException e) {
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
        try {
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
            List<QueryMarketQuotationModel> list = marketQuotationMapper.queryMarketQuotation(queryMarketQuotationParam);
            PageInfo<QueryMarketQuotationModel> pageInfo = new PageInfo<>(list);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, pageInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description:
     * @Date: Created on 2018/3/15 17:28
     * @Modified_By:
     */

    @PostMapping("/addMarketQuotation")
    @ApiOperation(value = "市场行情填报", notes = "市场行情填报")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    })
    public ResponseResult<Void> addMarketQuotation(AddMarketQuotationModel addMarketQuotationModel,
                                                   @RequestHeader(value = "authorization") String authorization) {
        UserModel user;
        try {
            user = getUserByToken(authorization);
        } catch (GeneralException e) {
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
        try {
            MarketQuotation marketQuotation = new MarketQuotation();
            modelMapper.map(addMarketQuotationModel, marketQuotation);
            marketQuotation.setOperateTime(ZWDateUtil.getNowDateTime());
            marketQuotation.setOperator(user.getId());
            marketQuotationService.save(marketQuotation);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_SAVE_MESSAGE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_SAVE_MESSAGE);
        }
    }


}
