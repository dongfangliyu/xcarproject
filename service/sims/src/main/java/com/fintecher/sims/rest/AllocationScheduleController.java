package com.fintecher.sims.rest;

import com.fintecher.sims.service.AllocationScheduleService;
import com.fintecher.sims.vo.AllocationScheduleModel;
import com.fintecher.sims.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 调拨进度管理
 * @Date: Created on 2018/3/13 19:17
 * @Modified By:
 */

@RestController
@RequestMapping("/allocationSchedule")
@Api(value = "调拨进度管理", description = "调拨进度管理")
public class AllocationScheduleController extends BaseController {
    @Autowired
    private AllocationScheduleService allocationScheduleService;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 查询调拨进度
     * @Modified By:
     */
    @GetMapping("/getAllAllocationSchedule")
    @ApiOperation(value = "查询调拨进度", notes = "查询调拨进度")
    public ResponseResult<List<AllocationScheduleModel>> getAllAllocationSchedule(@RequestParam @ApiParam(value = "调拨申请ID", required = true) Long id) {
        log.debug("request to get all allocation schedule,{}", id);
        try {
            List<AllocationScheduleModel> list = allocationScheduleService.getAllAllocationSchedule(id);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }
}
