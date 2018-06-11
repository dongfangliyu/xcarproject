package com.fintecher.sims.rest;

import com.fintecher.sims.entity.PurchaseRequisition;
import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.mapper.PurchaseRequisitionMapper;
import com.fintecher.sims.service.PurchaseRequisitionService;
import com.fintecher.sims.vo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 门店采购需求管理
 * @Date: Created on 2018/3/15 17:45
 * @Modified_By:
 */

@RestController
@RequestMapping("/purchaseRequisition")
@Api(value = "门店采购需求管理", description = "门店采购需求管理")
public class PurchaseRequisitionController extends BaseController {

    @Autowired
    private PurchaseRequisitionMapper purchaseRequisitionMapper;

    @Autowired
    private PurchaseRequisitionService purchaseRequisitionService;


    @GetMapping("/queryPurchaseRequisition")
    @ApiOperation(value = "分页查询门店采购需求", notes = "分页查询门店采购需求")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. "),
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    })
    public ResponseResult<PageInfo<QueryPurchaseRequisitionModel>> queryPurchaseRequisition(QueryPurchaseRequisitionParam queryParam, PageParam pageParam,
                                                                                            @RequestHeader(value = "authorization") String authorization) {
        UserModel user;
        try {
            user = getUserByToken(authorization);
        } catch (GeneralException e) {
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
        try {
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
            List<QueryPurchaseRequisitionModel> list = purchaseRequisitionMapper.queryPurchaseRequisition(queryParam);
            PageInfo<QueryPurchaseRequisitionModel> pageInfo = new PageInfo<>(list);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, pageInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 门店需求填报
     * @Modified By:
     */
    @PostMapping("/createPurchaseRequisition")
    @ApiOperation(value = "门店需求填报", notes = "门店需求填报")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> createPurchaseRequisition(@RequestBody PurchaseRequisitionParam param,
                                                          @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to create purchase requisition,{}", param);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            purchaseRequisitionService.createPurchaseRequisition(param, user);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_SAVE_MESSAGE);
        } catch (GeneralException ge) {
            log.error(ge.getMessage(), ge);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, ge.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_SAVE_MESSAGE);
        }
    }
}
