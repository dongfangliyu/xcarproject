package com.fintecher.sims.rest;

import com.fintecher.sims.entity.Manufacturer;
import com.fintecher.sims.service.ManufacturerService;
import com.fintecher.sims.util.ZWDateUtil;
import com.fintecher.sims.vo.ManufacturerModel;
import com.fintecher.sims.vo.PageParam;
import com.fintecher.sims.vo.ResponseResult;
import com.fintecher.sims.vo.UserModel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/16 11:33
 * @Modified By：
 */
@RestController
@RequestMapping("/manufacturer")
@Api(value = "汽车厂商",description = "汽车厂商")
public class ManufacturerController extends BaseController {
    @Autowired
    private ManufacturerService manufacturerService;
    @Autowired
    private ModelMapper modelMapper;
        /**
         * @System:
         * @Auther: dwx
         * @Description:新增汽车厂商
         * @Modified By：
         */
    @PostMapping("/addManufacturer")
    @ApiOperation(value = "新增汽车厂商",notes = "新增汽车厂商")
    public ResponseResult addManufacturer(@RequestBody ManufacturerModel manufacturerModel, @RequestHeader(value = "authorization") String authorization ){
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"用户未登录，请先登录");
            }
            Manufacturer manufacturer = new Manufacturer();
            modelMapper.map(manufacturerModel,manufacturer);
            manufacturer.setOperator(user.getId());
            manufacturer.setOperateTime(ZWDateUtil.getNowDateTime());
            manufacturerService.save(manufacturer);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"新增成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"新增失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:查询汽车厂商
     * @Modified By：
     */
    @GetMapping("findManufacturer")
    @ApiOperation(value = "查询汽车厂商",notes = "查询汽车厂商")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", defaultValue = "1", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", defaultValue = "10", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. ")
    })
    public ResponseResult findManufacturer(@RequestParam String name,PageParam pageParam){
            try{
                List<Manufacturer> list = manufacturerService.findManufacturerByName(name);
                if (Objects.isNull(list)){
                    return new ResponseResult(ResponseResult.Status.FAILURE,"暂无此厂商");
                }
                PageHelper.startPage(pageParam.getPage(), pageParam.getSize(), "sort ASC");
                PageInfo<Manufacturer> pageInfo = new PageInfo<>(list);
                return new ResponseResult(ResponseResult.Status.SUCCESS,pageInfo);
            }catch (Exception e){
                log.error(e.getMessage(),e);
                return new ResponseResult(ResponseResult.Status.FAILURE,"查询失败");
            }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:修改汽车厂商
     * @Modified By：
     */
    @PutMapping("/updateManufacturer")
    @ApiOperation(value = "修改汽车厂商",notes = "修改汽车厂商")
    public ResponseResult updateManufacturer(@RequestBody ManufacturerModel manufacturerModel,@RequestHeader(value = "authorization") String authorization){
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult(ResponseResult.Status.FAILURE, "用户未登录，请先登录");
            }
            Manufacturer manufacturer = manufacturerService.findById(manufacturerModel.getId());
            if (Objects.isNull(manufacturer)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"查无此厂商");
            }
            manufacturer.setIsDelete(manufacturerModel.getIsDelete());
            manufacturer.setName(manufacturerModel.getName());
            manufacturer.setOperator(user.getId());
            manufacturer.setOperateTime(ZWDateUtil.getNowDateTime());
            manufacturerService.updateSelective(manufacturer);
            return new ResponseResult(ResponseResult.Status.SUCCESS,"修改成功");
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"修改失败");
        }
    }
    /**
     * @System:
     * @Auther: dwx
     * @Description:删除汽车厂商
     * @Modified By：
     */
   @DeleteMapping("deleteManufacturer")
    @ApiOperation(value = "删除汽车厂商",notes = "删除汽车厂商")
    public ResponseResult deleteManufacturer(@RequestParam Long id,@RequestHeader(value = "authorization") String authorization){
       try{
       UserModel user = getUserByToken(authorization);
       if (Objects.isNull(user)) {
           return new ResponseResult(ResponseResult.Status.FAILURE, "用户未登录，请先登录");
       }
       Manufacturer manufacturer =manufacturerService.findById(id);
       manufacturer.setIsDelete(0);
       manufacturerService.update(manufacturer);
       return new ResponseResult(ResponseResult.Status.SUCCESS,"ok");
    }catch (Exception e){
           log.error(e.getMessage(),e);
           return new ResponseResult(ResponseResult.Status.FAILURE,e.getMessage());
       }
   }

}
