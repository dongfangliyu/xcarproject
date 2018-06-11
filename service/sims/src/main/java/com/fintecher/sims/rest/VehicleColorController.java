package com.fintecher.sims.rest;

import com.fintecher.sims.entity.VehicleColor;
import com.fintecher.sims.service.VehicleColorService;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.ResponseResult;
import com.fintecher.sims.vo.UserModel;
import com.fintecher.sims.vo.VehicleColorModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @Date:Created on 2018/3/15 16:08
 * @Modified By：
 */
@RestController
@RequestMapping("/vehicleColor")
@Api(value = "车辆颜色管理", description = "车辆颜色管理")
public class VehicleColorController extends BaseController {
    @Autowired
    private VehicleColorService vehicleColorService;
    @Autowired
    private ModelMapper modelMapper;
        /**
         * @System:
         * @Auther: dwx
         * @Description:查询所有颜色
         * @Modified By：
         */
    @GetMapping("findAllByColor")
    @ApiOperation(value = "查询车辆所有颜色",notes = "查询车辆所有颜色")
    public ResponseResult findAllByColor() {
        try {
           /* Example example = new Example(VehicleColor.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("vehicleModelId",id);
            List<VehicleColor> list = vehicleColorService.selectByExample(example);
            return new ResponseResult(ResponseResult.Status.SUCCESS,list);*/
            List<VehicleColor> list = vehicleColorService.findAll();
            return new ResponseResult(ResponseResult.Status.SUCCESS, list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult(ResponseResult.Status.FAILURE, "暂无颜色");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:根据颜色名称进行查询
     * @Modified By：
     */
    @GetMapping("findColorByName")
    @ApiOperation(value = "根据颜色名称进行查询",notes = "根据颜色名称进行查询")
    public ResponseResult findColorByName(@RequestParam String name,@RequestHeader(value = "authorization") String authorization){
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            List<VehicleColor> list = vehicleColorService.findColorByName(name);
            return new ResponseResult(ResponseResult.Status.SUCCESS,list);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"暂无此颜色，请先添加");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:新增颜色
     * @Modified By：
     */
    @PostMapping("/addVehicleColor")
    @ApiOperation(value = "新增颜色",notes = "新增颜色")
    public ResponseResult addVehicleColor(@RequestBody VehicleColorModel vehicleColorModel, @RequestHeader(value = "authorization") String authorization){
        try{
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            VehicleColor vehicleColor = new VehicleColor();
            modelMapper.map(vehicleColorModel,vehicleColor);
            vehicleColor.setName(vehicleColorModel.getName());
            vehicleColor.setCode(vehicleColorModel.getCode());
            vehicleColor.setOperator(user.getId());
            vehicleColor.setOperateTime(ZWDateUtil.getNowDateTime());
            vehicleColorService.save(vehicleColor);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"success");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"failure");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:删除已有颜色
     * @Modified By：
     */
    @DeleteMapping("deleteVehicleColor")
    @ApiOperation(value = "删除已有颜色",notes = "删除已有颜色")
    public ResponseResult deleteVehicleColor(@RequestParam Long id,@RequestHeader(value = "authorization") String authorization) {
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult<>(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            vehicleColorService.deleteById(id);
            return new ResponseResult(ResponseResult.Status.SUCCESS, "删除成功");
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"删除失败");
        }
    }

}
