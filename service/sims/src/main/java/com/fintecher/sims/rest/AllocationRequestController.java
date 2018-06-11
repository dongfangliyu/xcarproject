package com.fintecher.sims.rest;

import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.service.AllocationRequestService;
import com.fintecher.sims.vo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 调拨申请管理
 * @Date: Created on 2018/3/13 11:34
 * @Modified By:
 */

@RestController
@RequestMapping("/allocationRequest")
@Api(value = "调拨申请管理", description = "调拨申请管理")
public class AllocationRequestController extends BaseController {
    @Autowired
    private AllocationRequestService allocationRequestService;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 多条件查询调拨申请
     * @Modified By:
     */
    @GetMapping("/getAllAllocationRequest")
    @ApiOperation(value = "多条件查询调拨申请", notes = "多条件查询调拨申请")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", defaultValue = "1", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", defaultValue = "10", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. ")
    })
    public ResponseResult<PageInfo<AllocationRequestModel>> getAllAllocationRequest(@RequestParam(required = false) @ApiParam(value = "调拨单号") String allocationOrderNumber,
                                                                                    PageParam pageParam) {
        log.debug("request to get all allocation request,{}", allocationOrderNumber);
        try {
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
            List<AllocationRequestModel> list = allocationRequestService.getAllAllocationRequest(allocationOrderNumber);
            PageInfo<AllocationRequestModel> pageInfo = new PageInfo<>(list);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, pageInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 申请调拨
     * @Modified By:
     */
    @PostMapping("/allocationApply")
    @ApiOperation(value = "申请调拨", notes = "申请调拨")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> allocationApply(@RequestBody AllocationRequestParam param,
                                                @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to allocation apply,{}", param);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            allocationRequestService.allocationApply(param, user);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_SAVE_MESSAGE);
        } catch (GeneralException ge) {
            log.error(ge.getMessage(), ge);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, ge.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_SAVE_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 修改调拨申请
     * @Modified By:
     */
    @PutMapping("/modifyAllocationApply")
    @ApiOperation(value = "修改调拨申请", notes = "修改调拨申请")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> modifyAllocationApply(@RequestBody AllocationRequestParam param,
                                                      @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to modify allocation apply,{}", param);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            allocationRequestService.modifyAllocationApply(param, user);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_UPDATE_MESSAGE);
        } catch (GeneralException ge) {
            log.error(ge.getMessage(), ge);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, ge.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_UPDATE_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 根据调拨申请查询车辆信息
     * @Modified By:
     */
    @GetMapping("/getVehicleByAllocationId")
    @ApiOperation(value = "根据调拨申请查询车辆信息", notes = "根据调拨申请查询车辆信息")
    public ResponseResult<List<VehicleDetailsModel>> getVehicleByAllocationId(@RequestParam @ApiParam(value = "调拨申请ID", required = true) Long id) {
        log.debug("request to get vehicle by allocation id,{}", id);
        try {
            List<VehicleDetailsModel> list = allocationRequestService.getVehicleByAllocationId(id);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 调拨申请审批
     * @Modified By:
     */
    @PutMapping("/approveAllocation")
    @ApiOperation(value = "调拨申请审批", notes = "调拨申请审批")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> approveAllocation(@RequestBody ApproveAllocationParam param,
                                                  @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to approve allocation,{}", param);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            allocationRequestService.approveAllocation(param, user);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_UPDATE_MESSAGE);
        } catch (GeneralException ge) {
            log.error(ge.getMessage(), ge);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, ge.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_UPDATE_MESSAGE);
        }
    }
}
