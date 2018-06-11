package com.fintecher.sims.rest;

import com.fintecher.sims.entity.VehicleModel;
import com.fintecher.sims.entity.VehicleParamType;
import com.fintecher.sims.entity.VehiclePic;
import com.fintecher.sims.service.VehicleModelService;
import com.fintecher.sims.service.VehicleParamTypeService;
import com.fintecher.sims.service.VehiclePicService;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/15 10:36
 * @Modified By：
 */
@RestController
@RequestMapping("/vehicleParamType")
@Api(value = "车辆参数类型管理", description = "车辆参数类型管理")
public class VehicleParamTypeController extends BaseController {
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private VehicleParamTypeService vehicleParamTypeService;
    @Autowired
    private VehiclePicService vehiclePicService;
    @Autowired
    private ModelMapper modelMapper;
    /**
     * @System:
     * @Auther: dwx
     * @Description:根据车辆型号id获取车辆参数和车辆参数类型
     * @Modified By：
     */
    @GetMapping("/getParamByVehicle")
    @ApiOperation(value ="根据车辆id获取车辆参数和车辆参数类型",notes = "根据车辆id获取车辆参数和车辆参数类型")
    public ResponseResult getParamByVehicle(@RequestParam @ApiParam(value = "车辆型号ID", required = true) Long id){
        try{
            VehicleModel vehicleModel =vehicleModelService.findById(id);
            if (Objects.isNull(vehicleModel)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"车辆型号不存在");
            }
            List<VehicleParamModel> list =vehicleParamTypeService.findByParamList(id);
            return new ResponseResult(ResponseResult.Status.SUCCESS,list);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"查询失败");

        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:新增参数类型
     * @Modified By：
     */
    @PostMapping("/addVehicleParamType")
    @ApiOperation(value = "新增参数类型",notes = "新增参数类型")
    public ResponseResult addVehicleParamType(@RequestBody VehicleParamTypeModel vehicleParamTypeModel, @RequestHeader(value = "authorization") String authorization){
        try{
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            VehicleParamType vehicleParamType = new VehicleParamType();
            modelMapper.map(vehicleParamTypeModel,vehicleParamType);
            vehicleParamType.setName(vehicleParamTypeModel.getName());
            vehicleParamType.setOperateTime(ZWDateUtil.getNowDateTime());
            vehicleParamType.setOperator(user.getId());
            vehicleParamTypeService.save(vehicleParamType);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"新增成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"新增失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:修改参数类型
     * @Modified By：
     */
    @PutMapping("/updateVehicleParamType")
    @ApiOperation(value = "修改参数类型",notes = "修改参数类型")
    public ResponseResult updateVehicleParamType(@RequestBody VehicleParamTypeModel vehicleParamTypeModel, @RequestHeader(value = "authorization") String authorization){
        try{
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            VehicleParamType vehicleParamType = vehicleParamTypeService.findById(vehicleParamTypeModel.getId());
            if (Objects.isNull(vehicleParamType.getId())){
                return new ResponseResult(ResponseResult.Status.FAILURE,"无法修改");
            }
            vehicleParamType.setName(vehicleParamTypeModel.getName());
            vehicleParamType.setOperator(user.getId());
            vehicleParamType.setOperateTime(ZWDateUtil.getNowDateTime());
            vehicleParamTypeService.update(vehicleParamType);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"修改成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"修改失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:根据型号id查询照片
     * @Modified By：
     */
    @GetMapping("getFileByModelId")
    @ApiOperation(value = "根据型号id查询照片",notes = "根据型号id查询照片")
    public ResponseResult getFileByModelId(@RequestParam Long id){
        try{
            List<VehiclePic> list = vehiclePicService.findPicByModelId(id);
            if (list.isEmpty()){
                return new ResponseResult(ResponseResult.Status.FAILURE,"无照片");
            }
            return new ResponseResult(ResponseResult.Status.SUCCESS,list);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"查找失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:新增文件
     * @Modified By：
     */
    @PostMapping("/addVehicleFile")
    @ApiOperation(value = "新增文件",notes = "新增文件")
    public ResponseResult addVehicleFile(@RequestBody VehiclePicModel vehiclePicModel, @RequestHeader(value = "authorization") String authorization) {
        UserModel user = getUserByToken(authorization);
        try {
            if (Objects.isNull(user)) {
                return new ResponseResult(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            VehiclePic vehiclePic = new VehiclePic();
           // modelMapper.map(vehiclePicModel,vehiclePic);
            vehiclePic.setFileId(vehiclePicModel.getFileId());
            vehiclePic.setFileName(vehiclePicModel.getFileName());
            vehiclePic.setFileType(vehiclePicModel.getFileType());
            vehiclePic.setVehicleModelId(vehiclePicModel.getModelId());
            vehiclePic.setOperator(user.getId());
            vehiclePic.setOperateTime(ZWDateUtil.getNowDateTime());
            vehiclePicService.save(vehiclePic);
            return new ResponseResult(ResponseResult.Status.SUCCESS, "新增成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"新增失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:删除文件
     * @Modified By：
     */
     @DeleteMapping("deleteVehicleFile")
     @ApiOperation(value = "删除文件",notes = "删除文件")
    public ResponseResult deleteVehicleFile( @RequestParam Long id,@RequestHeader(value = "authorization") String authorization) {
         try {
             UserModel user = getUserByToken(authorization);
             if (Objects.isNull(user)) {
                 return new ResponseResult(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
             }
             VehiclePic vehiclePic = vehiclePicService.findById(id);

             if (Objects.isNull(vehiclePic.getFileName())){
                 return new ResponseResult(ResponseResult.Status.FAILURE,"此文件不存在");
             }
            vehiclePicService.deleteById(id);
             return new ResponseResult(ResponseResult.Status.SUCCESS,"删除成功");
         }catch (Exception e){
             log.error(e.getMessage(),e);
             return new ResponseResult(ResponseResult.Status.FAILURE,"删除失败");
         }
     }




}
