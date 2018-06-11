package com.fintecher.sims.rest;

import com.fintecher.sims.entity.Vehicle;
import com.fintecher.sims.entity.VehicleBrand;
import com.fintecher.sims.entity.VehicleModel;
import com.fintecher.sims.entity.VehicleSeries;
import com.fintecher.sims.service.VehicleBrandService;
import com.fintecher.sims.service.VehicleModelService;
import com.fintecher.sims.service.VehicleSeriesService;
import com.fintecher.sims.service.VehicleService;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Objects;

/**
 * @System:进销存系统
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/13
 * @Modified By：
 */
@RestController
@RequestMapping("/vehicle")
@Api(value = "车辆品牌型号管理", description = "车辆品牌型号管理")
public class VehicleController extends BaseController {
    private final Logger log = Logger.getLogger(VehicleController.class);
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleBrandService vehicleBrandService;
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private VehicleSeriesService vehicleSeriesService;
    @Autowired
    private ModelMapper modelMapper;
    /**
     * @Auther: dwx
     * @Description:获取车辆所有品牌
     * @Modified By：
     */
    @GetMapping("/getAllBrand")
    @ApiOperation(value = "获取车辆所有品牌",notes = "获取车辆所有品牌")
    public ResponseResult getAllBrand(){
        try{
            List<VehicleBrand> vehicleBrands =vehicleBrandService.findAll();
            return new ResponseResult(ResponseResult.Status.SUCCESS,vehicleBrands);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"查询失败");
        }
    }
    /**
     * @Auther: dwx
     * @Description:车辆型号
     * @Modified By：
     */
    @GetMapping("/getAllModel")
    @ApiOperation(value = "获取车辆所有型号",notes = "获取车辆所有型号")
    public ResponseResult getAllModel(){
        try{
            List<VehicleModel> vehicleModels = vehicleModelService.findAll();
            return new ResponseResult(ResponseResult.Status.SUCCESS,vehicleModels);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"查询失败");
        }
    }

/**
 * @Auther: dwx
 * @Description:
 * @Modified By：
 */

    @GetMapping("/getAllSeries")
    @ApiOperation(value = "获取车辆所有系列",notes = "获取车辆所有系列")
    public ResponseResult getAllSeries(){
        try{
            List<VehicleSeries> vehicleSeries = vehicleSeriesService.findAll();
            return new ResponseResult(ResponseResult.Status.SUCCESS,vehicleSeries);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"查询失败");
        }
    }

    /**
     * @Auther: dwx
     * @Description:新增车辆
     * @Modified By：
     */

    @PostMapping("/addVehicle")
    @ApiOperation(value = "新增车辆",notes = "新增车辆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> addVehicle(@RequestBody VehicleVoModel vehicleVoModel, @RequestHeader(value = "authorization") String authorization ){
        try{
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)){
                return new ResponseResult<>(ResponseResult.Status.FAILURE,"用户未登录，请登录后操作");
            }
               vehicleService.listVehicle(vehicleVoModel,user);
                return new ResponseResult<>(ResponseResult.Status.SUCCESS,"新增车辆成功");

        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE,"新增车辆失败");
        }
    }
    /**
     * @Auther: dwx
     * @Description:根据车辆品牌获得系列
     * @Modified By：
     */
    @PostMapping("/getSeriesByBrandId")
    @ApiOperation(value = "根据车辆品牌获得系列",notes = "根据车辆品牌获得系列")
    public ResponseResult<VehicleSeries> getSeriesByBrandId (@RequestParam Long brandId){
        try {
            Example example = new Example(VehicleSeries.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("vehicleBrandId", brandId);
            List<VehicleSeries> vehicleSeries = vehicleSeriesService.selectByExample(example);
            return new ResponseResult(ResponseResult.Status.SUCCESS,vehicleSeries);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"查询失败");
        }

    }
    /**
     * @Auther: dwx
     * @Description:新增系列
     * @Modified By：
     */
    @PostMapping("/addVehicleSeries")
    @ApiOperation(value = "新增系列",notes = "新增系列")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseResult addVehicleSeries(@RequestBody VehicleSeriesModel vehicleSeriesModel, @RequestHeader(value = "authorization") String authorization){
        try{
            UserModel user =getUserByToken(authorization);
            if (Objects.isNull(user)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"用户未登录，请登录再新增");
            }
            VehicleSeries vehicleSeries = new VehicleSeries();
            //判断系列是否为空
            if (vehicleSeriesModel.getSeriesName().equals("")){
                return new ResponseResult(ResponseResult.Status.FAILURE,"系列不能为空");
            }
            Example example = new Example(VehicleSeries.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("name",vehicleSeriesModel.getSeriesName());
            List<VehicleSeries> vehicleSeries1 = vehicleSeriesService.selectByExample(example);
            if (vehicleSeries1.size()!=0){
                return new ResponseResult(ResponseResult.Status.FAILURE,"系列名称已存在,请重新输入");
            }
            vehicleSeries.setOperateTime(ZWDateUtil.getNowDateTime());
            vehicleSeries.setOperator(user.getId());
            vehicleSeriesService.addVehicleSeries(vehicleSeriesModel, user);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"新增成功");
        }catch(Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"新增失败");
        }
    }

        /**
         * @System:
         * @Auther: dwx
         * @Description:新增品牌
         * @Modified By：
         */
    @PostMapping("addVehicleBrand")
    @ApiOperation(value = "新增品牌",notes = "新增品牌")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseResult addVehicleBrand (@RequestBody VehicleBrandModel vehicleBrandModel, @RequestHeader(value = "authorization") String authorization){
        try{
                UserModel user =getUserByToken(authorization);
                if (Objects.isNull(user)){
                    return new ResponseResult(ResponseResult.Status.FAILURE,"请登录之后再进行操作");
                }
                VehicleBrand vehicleBrand =new VehicleBrand();
                //判断传入品牌名称是否为空
               if (vehicleBrandModel.getBrandName().equals("")){
                    return new ResponseResult(ResponseResult.Status.FAILURE,"品牌名称不能为空");
                }
            Example example = new Example(VehicleBrand.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("name",vehicleBrandModel.getBrandName());
            List<VehicleBrand> vehicleBrands  = vehicleBrandService.selectByExample(example);
            if (vehicleBrands.size() !=0){
                return new ResponseResult(ResponseResult.Status.FAILURE,"品牌名称已存在");
            }
            vehicleBrand.setName(vehicleBrandModel.getBrandName());
            vehicleBrand.setOperator(user.getId());
            vehicleBrand.setOperateTime(ZWDateUtil.getNowDateTime());
            vehicleBrandService.save(vehicleBrand);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"新增成功");

        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"新增失败");

        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:根据系列查看型号
     * @Modified By：
     */
    @GetMapping("/getModelBySrries")
    @ApiOperation(value = "根据系列查看型号",notes = "根据系列查看型号")
    public ResponseResult<VehicleModel> getModelBySeries(@RequestParam Long id){
        try {
            Example example = new Example(VehicleModel.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("vehicleSeriesId", id);
            List<VehicleModel> list = vehicleModelService.selectByExample(example);
            return new ResponseResult(ResponseResult.Status.SUCCESS,list);
        }catch(Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"查询失败");
        }

    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:修改车辆
     * @Modified By：
     */
    @PutMapping("updateVehicle")
    @ApiOperation(value = "修改车辆",notes = "修改车辆")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseResult updateVehicle(@RequestBody VehicleVoModel vehicleVoModel,@RequestHeader(value = "authorization") String authorization ){
        try{
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"请登录之后再进行操作");
            }
            vehicleService.updateVehicle(vehicleVoModel,user);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"修改成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"修改失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:删除车辆
     * @Modified By：
     */
    @DeleteMapping("deleteVehicle")
    @ApiOperation(value = "删除车辆",notes = "删除车辆")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
        public ResponseResult deleteVehicle(@RequestParam Long vehicleId,@RequestHeader(value = "authorization")String authorization){
        try{
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"您未登录，请先登录");
            }
            vehicleService.deleteById(vehicleId);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"删除成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"删除失败");
        }
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description:删除车辆系列
     * @Modified By：
     */
    @DeleteMapping("deleteVehicleBySeries")
    @ApiOperation(value = "删除车辆系列",notes = "删除车辆系列")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseResult deleteVehicleBySeries(@RequestParam Long seriesId,@RequestHeader(value = "authorization")String authorization){
        try{
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"您未登录，请先登录");
            }
            Example example =new Example(Vehicle.class);
            Example.Criteria criteria =example.createCriteria();
            criteria.andEqualTo("vehicleSeriesId",seriesId);
            List<Vehicle> list = vehicleService.selectByExample(example);
            if (!list.isEmpty()){
                return new ResponseResult(ResponseResult.Status.FAILURE,"系列下有车辆型号存在，不允许删除");
            }
            vehicleSeriesService.deleteById(seriesId);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"删除成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"删除失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:删除车辆品牌
     * @Modified By：
     */
    @DeleteMapping("deleteVehicleByBrand")
    @ApiOperation(value = "删除车辆品牌",notes = "删除车辆品牌")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseResult deleteVehicleByBrand(@RequestParam Long brandId,@RequestHeader(value = "authorization")String authorization){
        try{
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"您未登录，请先登录");
            }
            Example example =new Example(Vehicle.class);
            Example.Criteria criteria =example.createCriteria();
            criteria.andEqualTo("vehicleBrandId",brandId);
            List<VehicleSeries> list = vehicleSeriesService.selectByExample(example);
            if (!list.isEmpty()){
                return new ResponseResult(ResponseResult.Status.SUCCESS,"品牌下面存在系列，不允许删除");
            }
            vehicleBrandService.deleteById(brandId);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"删除成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"删除失败");
        }
    }

}
