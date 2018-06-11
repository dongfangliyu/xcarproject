package com.fintecher.sims.rest;

import com.fintecher.sims.exception.GeneralException;
import com.fintecher.sims.service.MaterialCategoryService;
import com.fintecher.sims.vo.MaterialCategoryModel;
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
 * @Description: 车辆素材类别管理
 * @Date: Created on 2018/3/6 18:02
 * @Modified By:
 */

@RestController
@RequestMapping("/materialCategory")
@Api(value = "车辆素材类别管理", description = "车辆素材类别管理")
public class MaterialCategoryController extends BaseController {
    @Autowired
    private MaterialCategoryService materialCategoryService;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 查询车辆素材类别
     * @Modified By:
     */
    @GetMapping("/getAllMaterialCategory")
    @ApiOperation(value = "查询车辆素材类别", notes = "查询车辆素材类别")
    public ResponseResult<List<MaterialCategoryModel>> getAllMaterialCategory() {
        log.debug("request to get all material category");
        try {
            Type listType = new TypeToken<List<MaterialCategoryModel>>() {
            }.getType();
            List<MaterialCategoryModel> list = modelMapper.map(materialCategoryService.findAll(), listType);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_LOAD_MESSAGE, list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_LOAD_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 新增车辆素材类别
     * @Modified By:
     */
    @PostMapping("/createCategory")
    @ApiOperation(value = "新增车辆素材类别", notes = "新增车辆素材类别")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> createCategory(@RequestBody MaterialCategoryModel model,
                                               @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to create category,{}", model);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            materialCategoryService.createCategory(model, user);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_SAVE_MESSAGE);
        } catch (GeneralException ge) {
            log.error(ge.getMessage(), ge);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, ge.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_SAVE_MESSAGE);
        }
    }

    /**
     * @System: 进销存
     * @Auther: xiaqun
     * @Description: 修改车辆素材类别
     * @Modified By:
     */
    @PutMapping("/modifyCategory")
    @ApiOperation(value = "修改车辆素材类别", notes = "修改车辆素材类别")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ResponseResult<Void> modifyCategory(@RequestBody MaterialCategoryModel model,
                                               @RequestHeader(value = "authorization") String authorization) {
        log.debug("request to create category,{}", model);
        try {
            UserModel user = getUserByToken(authorization);
            if (Objects.isNull(user)) {
                return new ResponseResult(ResponseResult.Status.FAILURE, "用户未登录，请重新登录");
            }
            materialCategoryService.modifyCategory(model, user);
            return new ResponseResult<>(ResponseResult.Status.SUCCESS, SUCCESS_SAVE_MESSAGE);
        } catch (GeneralException ge) {
            log.error(ge.getMessage(), ge);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, ge.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, FAILURE_SAVE_MESSAGE);
        }
    }
}
