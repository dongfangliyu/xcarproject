package com.fintecher.sims.rest;

import com.fintecher.sims.entity.VehicleParam;
import com.fintecher.sims.service.VehicleParamService;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.ResponseResult;
import com.fintecher.sims.vo.UserModel;
import com.fintecher.sims.vo.VehicleParamModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Objects;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/14 16:36
 * @Modified By：
 */
@RestController
@RequestMapping("/vehicleParam")
@Api(value = "车辆参数管理", description = "车辆参数管理")
public class VehicleParamController extends BaseController {

    @Autowired
    private VehicleParamService vehicleParamService;
    @Autowired
    private ModelMapper modelMapper;
    /**
     * @System:
     * @Auther: dwx
     * @Description:查询所有车辆参数
     * @Modified By：
     */
    @GetMapping("/findAllByVehicleParam")
    @ApiOperation(value = "查询所有车辆参数",notes = "查询所有车辆参数")
    public ResponseResult findAllByVehicleParam(){
        log.debug("request to select all car param");
        try {
            List<VehicleParam> list = vehicleParamService.findAll();
            return new ResponseResult(ResponseResult.Status.SUCCESS, list);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"查询失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:新增车辆参数
     * @Modified By：
     */
    @PostMapping("/addVehicleParam")
    @ApiOperation(value = "新增车辆参数",notes = "新增车辆参数")
    public ResponseResult addVehicleParam(@RequestBody VehicleParamModel vehicleParamModel, @RequestHeader(value = "authorization") String authorization){
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            VehicleParam vehicleParam = new VehicleParam();
            modelMapper.map(vehicleParamModel,vehicleParam);
            vehicleParam.setParamTypeId(vehicleParamModel.getModelId());
            vehicleParam.setName(vehicleParamModel.getParamName());
            vehicleParam.setValue(vehicleParamModel.getParamValue());
            vehicleParam.setOperateTime(ZWDateUtil.getNowDateTime());
            vehicleParam.setOperator(user.getId());
            vehicleParamService.save(vehicleParam);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"新增成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"新增失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:修改车辆参数
     * @Modified By：
     */
    @PutMapping("/updateVehicleParam")
    @ApiOperation(value = "修改车辆参数",notes = "修改车辆参数")
    public ResponseResult updateVehicleParam(@RequestBody VehicleParamModel vehicleParamModel,@RequestHeader(value = "authorization") String authorization){
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            VehicleParam vehicleParam =vehicleParamService.findById(vehicleParamModel.getId());
            if (Objects.isNull(vehicleParamModel.getId())){
                return new ResponseResult(ResponseResult.Status.FAILURE,"无法修改");
            }
            vehicleParam.setName(vehicleParamModel.getParamName());
            vehicleParam.setParamTypeId(vehicleParamModel.getModelId());
            vehicleParam.setOperateTime(ZWDateUtil.getNowDateTime());
            vehicleParam.setOperator(user.getId());
            vehicleParamService.updateSelective(vehicleParam);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"修改成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"修改失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:删除车辆参数
     * @Modified By：
     */
    @DeleteMapping("/deleteVehicleParam")
    @ApiOperation(value = "删除车辆参数",notes = "删除车辆参数")
    public ResponseResult deleteVehicleParam(@RequestParam @ApiParam(value = "车辆参数ID", required = true) Long id,
                                             @RequestHeader(value = "authorization") String authorization){
        try{
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            VehicleParam vehicleParam = vehicleParamService.findById(id);
            if (Objects.isNull(vehicleParam)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"参数不存在");
            }
            vehicleParamService.deleteById(id);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"删除成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"删除失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:根据参数类型查询类型下面参数
     * @Modified By：
     */
    @GetMapping("/queryParamTypeByParam")
    @ApiOperation(value = "根据参数类型查询类型下面参数",notes = "根据参数类型查询类型下面参数")
    public ResponseResult queryParamTypeByParam(@RequestParam @ApiParam(value = "车辆参数ID", required = true) Long id){
        log.debug("select vehicle param by param type code ");
        try {
            Example example = new Example(VehicleParam.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("paramTypeId", id);
            List<VehicleParam> list = vehicleParamService.selectByExample(example);
            return new ResponseResult(ResponseResult.Status.SUCCESS,list);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"查询失败");
        }

    }


}
