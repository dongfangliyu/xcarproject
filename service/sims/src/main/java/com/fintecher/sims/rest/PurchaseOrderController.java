package com.fintecher.sims.rest;

import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.service.PurchaseOrderService;
import com.fintecher.sims.vo.PurchaseOrderParam;
import com.fintecher.sims.vo.ResponseResult;
import com.fintecher.sims.vo.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 采购单管理
 * @Date: Created on 2018/3/16 17:34
 * @Modified By:
 */

@RestController
@Api(value = "采购单管理", description = "采购单管理")
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController extends BaseController {
    @Autowired
    private PurchaseOrderService purchaseOrderService;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 新增采购单
     * @Modified By:
     */
    @PostMapping("/createPurchaseOrder")
    @ApiOperation(value = "新增采购单", notes = "新增采购单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> createPurchaseOrder(@RequestBody PurchaseOrderParam param,
                                                    @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to create purchase order,{}", param);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            purchaseOrderService.createPurchaseOrder(param, user);
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
