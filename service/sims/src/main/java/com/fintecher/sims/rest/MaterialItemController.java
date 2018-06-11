package com.fintecher.sims.rest;

import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.service.MaterialItemService;
import com.fintecher.sims.vo.MaterialItemModel;
import com.fintecher.sims.vo.ResponseResult;
import com.fintecher.sims.vo.UserModel;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @System: 进销存
 * @Auther: xiaqun
 * @Description: 车辆素材管理
 * @Date: Created on 2018/3/7 17:45
 * @Modified By:
 */

@RestController
@RequestMapping("/materialItem")
@Api(value = "车辆素材管理", description = "车辆素材管理")
public class MaterialItemController extends BaseController {
    @Autowired
    private MaterialItemService materialItemService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 查询车辆素材
     * @Modified By:
     */
    @GetMapping("/getAllMaterialItem")
    @ApiOperation(value = "查询车辆素材", notes = "查询车辆素材")
    public ResponseResult<List<MaterialItemModel>> getAllMaterialItem(@RequestParam @ApiParam(value = "素材类别ID", required = true) Long id) {
        log.debug("request to get all material item,{}", id);
        try {
            Type listType = new TypeToken<List<MaterialItemModel>>() {
            }.getType();
            List<MaterialItemModel> list = modelMapper.map(materialItemService.getAllItem(id), listType);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 新增车辆素材
     * @Modified By:
     */
    @PostMapping("/createMaterialItem")
    @ApiOperation(value = "新增车辆素材", notes = "新增车辆素材")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> createMaterialItem(@RequestBody MaterialItemModel materialItemModel,
                                                   @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to create material item,{}", materialItemModel);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            materialItemService.createMaterialItem(materialItemModel, user);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_SAVE_MESSAGE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_SAVE_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 修改车辆素材
     * @Modified By:
     */
    @PutMapping("/modifyMaterialItem")
    @ApiOperation(value = "修改车辆素材", notes = "修改车辆素材")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> modifyMaterialItem(@RequestBody MaterialItemModel materialItemModel,
                                                   @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to modify material item,{}", materialItemModel);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            materialItemService.modifyMaterialItem(materialItemModel, user);
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
     * @Description: 删除车辆素材
     * @Modified By:
     */
    @DeleteMapping("/deleteMaterialItem")
    @ApiOperation(value = "删除车辆素材", notes = "删除车辆素材")
    public ResponseResult<Void> deleteMaterialItem(@RequestParam @ApiParam(value = "车辆素材ID", required = true) Long id) {
        log.debug("request to delete material item,{}", id);
        try {
            materialItemService.deleteById(id);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_DELETE_MESSAGE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_DELETE_MESSAGE);
        }
    }
}
