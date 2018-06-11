package com.fintecher.sims.rest;

import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.service.AllocationRecordService;
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
 * @Auther: xiaqun
 * @Description: 调拨出入库记录管理
 * @Date: Created on 2018/3/14 13:43
 * @Modified By:
 */

@RestController
@RequestMapping("/allocationRecord")
@Api(value = "调拨出入库记录管理", description = "调拨出入库记录管理")
public class AllocationRecordController extends BaseController {
    @Autowired
    private AllocationRecordService allocationRecordService;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 多条件查询调拨出库记录
     * @Modified By:
     */
    @GetMapping("/getOutAllocationRecord")
    @ApiOperation(value = "多条件查询调拨出库记录", notes = "多条件查询调拨出库记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", defaultValue = "1", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", defaultValue = "10", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. ")
    })
    public ResponseResult<PageInfo<AllocationRecordModel>> getOutAllocationRecord(AllocationRecordParam param,
                                                                                  PageParam pageParam) {
        log.debug("request to get out allocation record,{}", param);
        try {
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
            List<AllocationRecordModel> list = allocationRecordService.getOutAllocationRecord(param);
            PageInfo<AllocationRecordModel> pageInfo = new PageInfo<>(list);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, pageInfo);
        } catch (Exception e) {
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 调拨出库
     * @Modified By:
     */
    @PutMapping("/allocationOut")
    @ApiOperation(value = "调拨出库", notes = "调拨出库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> allocationOut(@RequestBody AllocationRecordOutParam param,
                                              @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to allocation out,{}", param);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            allocationRecordService.allocationOut(param, user);
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
     * @Description: 多条件查询调拨入库记录
     * @Modified By:
     */
    @GetMapping("/getInAllocationRecord")
    @ApiOperation(value = "多条件查询调拨入库记录", notes = "多条件查询调拨入库记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", defaultValue = "1", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", defaultValue = "10", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. ")
    })
    public ResponseResult<PageInfo<AllocationRecordModel>> getInAllocationRecord(AllocationRecordParam param,
                                                                                 PageParam pageParam) {
        log.debug("request to get in allocation record,{}", param);
        try {
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
            List<AllocationRecordModel> list = allocationRecordService.getInAllocationRecord(param);
            PageInfo<AllocationRecordModel> pageInfo = new PageInfo<>(list);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, pageInfo);
        } catch (Exception e) {
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 调拨入库
     * @Modified By:
     */
    @PutMapping("/allocationIn")
    @ApiOperation(value = "调拨入库", notes = "调拨入库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> allocationIn(@RequestBody AllocationRecordInParam param,
                                             @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to allocation in,{}", param);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            allocationRecordService.allocationIn(param, user);
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
