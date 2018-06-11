package com.fintecher.sims.rest;

import com.fintecher.sims.entity.MeasuresRecord;
import com.fintecher.sims.entity.MeasuresRecordFile;
import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.mapper.MeasuresRecordMapper;
import com.fintecher.sims.mapper.VehicleMapper;
import com.fintecher.sims.service.MeasuresRecordFileService;
import com.fintecher.sims.service.MeasuresRecordService;
import com.fintecher.sims.util.BeanUtil;
import com.fintecher.sims.util.GeneralEnum;
import com.fintecher.sims.vo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 库放车辆管理
 * @Date: Created on 2018/3/15 9:44
 * @Modified_By:
 */

@RestController
@RequestMapping("/vehicleStock")
@Api(value = "库放车辆管理", description = "库放车辆管理")
public class VehicleStockController extends BaseController {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private MeasuresRecordMapper measuresRecordMapper;

    @Autowired
    private MeasuresRecordService measuresRecordService;

    @Autowired
    private MeasuresRecordFileService measuresRecordFileService;


    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 分页查询库放车辆
     * @Date: Created on 2018/3/15 9:54
     * @Modified_By:
     */

    @GetMapping("/queryVehicleInfo")
    @ApiOperation(value = "分页查询库放车辆", notes = "分页查询库放车辆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. "),
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    })
    public ResponseResult<PageInfo<QueryVehicleStockModel>> queryVehicleStock(QueryVehicleStockParam queryVehicleStockParam, PageParam pageParam,
                                                                              @RequestHeader(value = "authorization") String authorization) {
        UserModel user;
        try {
            user = getUserByToken(authorization);
        } catch (GeneralException e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
        try {
            if (Objects.equals(queryVehicleStockParam.getStorage(), GeneralEnum.BasisJudge.YES.getValue().intValue())) {
                queryVehicleStockParam.setStatus(GeneralEnum.VehicleStatus.STORAGE_PARK.getValue());
            }
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
            List<QueryVehicleStockModel> vehicleStockModelList = vehicleMapper.queryVehicleStock(queryVehicleStockParam);
            PageInfo<QueryVehicleStockModel> pageInfo = new PageInfo<>(vehicleStockModelList);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, pageInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }

    }


    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 查看库放车技术状态与措施记录
     * @Date: Created on 2018/3/15 11:00
     * @Modified_By:
     */

    @GetMapping("/queryMeasuresRecord")
    @ApiOperation(value = "查看库放车技术状态与措施记录", notes = "查看库放车技术状态与措施记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. "),
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    })
    public ResponseResult<PageInfo<MeasuresRecordModel>> queryMeasuresRecord(@RequestParam(value = "车辆ID") Long vehiId, PageParam pageParam,
                                                                             @RequestHeader(value = "authorization") String authorization) {
        try {
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
            List<MeasuresRecordModel> measuresRecordModels = measuresRecordMapper.queryMeasuresRecord(vehiId);
            PageInfo<MeasuresRecordModel> pageInfo = new PageInfo<>(measuresRecordModels);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, pageInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }

    }


    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 增加库放车技术状态与措施记录
     * @Date: Created on 2018/3/15 15:44
     * @Modified_By:
     */

    @PostMapping("/addMeasuresRecord")
    @ApiOperation(value = "增加库放车技术状态与措施记录", notes = "增加库放车技术状态与措施记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    })
    public ResponseResult<PageInfo<MeasuresRecordModel>> addMeasuresRecord(@RequestBody AddMeasuresRecordParam addMeasuresRecordParam,
                                                                           @RequestHeader(value = "authorization") String authorization) {
        UserModel user;
        try {
            user = getUserByToken(authorization);
        } catch (GeneralException e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
        try {
            MeasuresRecord measuresRecord = new MeasuresRecord();
            BeanUtil.copyPropertiesIgnoreNull(addMeasuresRecordParam, measuresRecord);
            List<MeasuresRecordFile> fileList = new ArrayList<>();
            if (Objects.nonNull(addMeasuresRecordParam.getFileModelSet())) {
                for (AddFileParam fileParam : addMeasuresRecordParam.getFileModelSet()) {
                    MeasuresRecordFile measuresRecordFile = new MeasuresRecordFile();
                    BeanUtil.copyPropertiesIgnoreNull(fileParam, measuresRecord);
                    measuresRecord.setOperator(user.getId());
                    fileList.add(measuresRecordFile);
                }
            }
            measuresRecordService.saveMeasuresRecord(measuresRecord, fileList);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_SAVE_MESSAGE);
        }

    }

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 删除库放车技术状态与措施记录
     * @Date: Created on 2018/3/15 15:39
     * @Modified_By:
     */

    @DeleteMapping("/deleteMeasuresRecord")
    @ApiOperation(value = "删除库放车技术状态与措施记录", notes = "删除库放车技术状态与措施记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    })
    public ResponseResult<Integer> deleteMeasuresRecord(@RequestParam(value = "记录ID") Long recordId,
                                                        @RequestHeader(value = "authorization") String authorization) {
        try {
            int a = measuresRecordService.deleteById(recordId);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_DELETE_MESSAGE, a);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_DELETE_MESSAGE);
        }
    }


    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 删除库放车技术状态与措施记录附件
     * @Date: Created on 2018/3/15 15:39
     * @Modified_By:
     */

    @DeleteMapping("/deleteMeasuresRecordFile")
    @ApiOperation(value = "删除库放车技术状态与措施记录附件", notes = "删除库放车技术状态与措施记录附件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    })
    public ResponseResult<Void> deleteMeasuresRecordFile(@RequestParam(value = "附件ID") Long id,
                                                         @RequestHeader(value = "authorization") String authorization) {
        try {
            measuresRecordFileService.deleteById(id);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_DELETE_MESSAGE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_DELETE_MESSAGE);
        }
    }
}
