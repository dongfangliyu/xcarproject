package com.fintecher.sims.rest;


import com.fintecher.sims.entity.Vehicle;
import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.mapper.VehicleMapper;
import com.fintecher.sims.mapper.VehicleMileageRecordMapper;
import com.fintecher.sims.service.*;
import com.fintecher.sims.util.BeanUtil;
import com.fintecher.sims.util.SortUtil;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @System: 进销存
 * @Auther: lijian
 * @Description: 车辆信息管理
 * @Date: Created on 2018/3/13 12:00
 * @Modified_By:
 */

@RestController
@RequestMapping("/vehicleInfo")
@Api(value = "车辆信息管理", description = "车辆信息管理")
public class VehicleInfoController extends BaseController {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleBrandService vehicleBrandService;

    @Autowired
    private VehicleSeriesService vehicleSeriesService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private VehicleMileageRecordService vehicleMileageRecordService;

    @Autowired
    private VehicleMileageRecordMapper vehicleMileageRecordMapper;


    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 车辆信息管理模块中的分页查询车辆信息
     * @Date: Created on 2018/3/14 9:31
     * @Modified_By:
     */
    @GetMapping("/queryVehicleInfo")
    @ApiOperation(value = "分页查询车辆信息", notes = "分页查询车辆信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. "),
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    })
    public ResponseResult<PageInfo<QueryVehicleInfoModel>> queryVehicleInfo(QueryVehicleInfoParam queryVehicleInfoParam, PageParam pageParam,
                                                                            @RequestHeader(value = "authorization") String authorization) {
        UserModel user;
        try {
            user = getUserByToken(authorization);
        } catch (GeneralException e) {
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
        try {
            queryVehicleInfoParam.setSortStr(SortUtil.convertSql(QueryVehicleInfoModel.class, pageParam.getSort()));
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
            List<QueryVehicleInfoModel> queryVehicleInfoModelList = vehicleMapper.queryVehicleInfo(queryVehicleInfoParam);
            PageInfo<QueryVehicleInfoModel> pageInfo = new PageInfo<>(queryVehicleInfoModelList);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, pageInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 车辆信息管理模块中的按照车辆ID查询车辆信息
     * @Date: Created on 2018/3/14 9:31
     * @Modified_By:
     */
    @GetMapping("/getBaseVehicleInfo")
    @ApiOperation(value = "查询车辆基本信息", notes = "查询车辆基本信息")
    public ResponseResult<VehicleBaseInfo> getBaseVehicleInfo(@RequestParam(value = "车辆ID") Long id,
                                                              @RequestHeader(value = "authorization") String authorization) {
        try {
            VehicleBaseInfo baseInfo = vehicleMapper.getBaseVehicleInfo(id);
            if (Objects.isNull(baseInfo)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "未找到该车辆");
            }
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, baseInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 编辑车辆基本信息
     * @Date: Created on 2018/3/14 9:32
     * @Modified_By:
     */
    @PutMapping("/editBaseVehicleInfo")
    @ApiOperation(value = "编辑车辆基本信息", notes = "编辑车辆基本信息")
    public ResponseResult<Void> editBaseVehicleInfo(@Validated @RequestBody EditBaseVehicleParam editBaseVehicleParam,
                                                    @RequestHeader(value = "authorization") String authorization) {
        UserModel user;
        try {
            user = getUserByToken(authorization);
        } catch (GeneralException e) {
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
        try {
            Vehicle vehicle = vehicleService.findById(editBaseVehicleParam.getId());
            if (Objects.isNull(vehicle)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "未找到该车辆");
            }
            BeanUtil.copyPropertiesIgnoreNull(editBaseVehicleParam, vehicle);
            vehicle.setUpdater(user.getId());
            vehicle.setUpdateTime(ZWDateUtil.getNowDateTime());
            vehicleService.save(vehicle);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_UPDATE_MESSAGE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_UPDATE_MESSAGE);
        }
    }


    /**
     * @System: 进销存
     * @Auther: lijian
     * @Description: 分页查询车辆里程记录
     * @Date: Created on 2018/3/14 14:07
     * @Modified_By:
     */
    @GetMapping("/queryVehicleMileageRecord")
    @ApiOperation(value = "分页查询车辆里程记录", notes = "分页查询车辆里程记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. "),
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    })
    public ResponseResult<PageInfo<VehicleMileageRecordModel>> queryVehicleMileageRecord(@RequestParam(value = "车辆ID") Long vehiId, PageParam pageParam,
                                                                                         @RequestHeader(value = "authorization") String authorization) {
        try {
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
            List<VehicleMileageRecordModel> vehicleMileageRecordModelList = vehicleMileageRecordMapper.queryVehicleMileageRecord(vehiId);
            PageInfo<VehicleMileageRecordModel> pageInfo = new PageInfo<>(vehicleMileageRecordModelList);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, pageInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }


}
