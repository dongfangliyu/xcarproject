package com.fintecher.sims.rest;

import com.fintecher.sims.vo.*;
import com.fintecher.sims.entity.DataDictType;
import com.fintecher.sims.service.DataDictTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/14 15:30
 * @Modified By：
 */
@RestController
@RequestMapping("/dataDictType")
@Api(value = "数据字典类型",description = "数据字典类型")
public class DataDictTypeController extends BaseController {
    @Autowired
    private DataDictTypeService dataDictTypeService;

    /**
     * @System:
     * @Auther: dwx
     * @Description: 查询所有数据字典类型
     * @Modified By:
     */
    @GetMapping("/getAllDictType")
    @ApiOperation(value = "查询所有数据字典类型", notes = "查询所有数据字典类型")
    public ResponseResult getAllDictType() {
        log.debug("request to get all dict type");
        try {
            DataDictType dataDictType = new DataDictType();
//            dataDictType.setType(0);  //先注了
            List<DataDictType> list = dataDictTypeService.getAllDictType(dataDictType);
            list.sort(Comparator.comparing(DataDictType::getId));
            return new ResponseResult(ResponseResult.Status.SUCCESS, "", list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, e.getMessage());
        }
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 新增或修改数据字典类型
     * @Modified By:
     */
    @PostMapping("/createOrModifyDataDictType")
    @ApiOperation(value = "新增或修改数据字典类型", notes = "新增或修改数据字典类型")
    public ResponseResult createOrModifyDataDictType(@RequestBody DataDictType dataDictType) {
        log.debug("request to create or modify data dict type");
        try {
            if (Objects.isNull(dataDictType.getId())) {
                Integer i = dataDictTypeService.getMaxId();
                dataDictType.setId(i + 1);
                dataDictType.setCode("0" + (i + 1));
                dataDictTypeService.saveDataDict(dataDictType);
            } else {
                dataDictTypeService.updateDataDict(dataDictType);
            }
            return new ResponseResult(ResponseResult.Status.SUCCESS, "ok");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, "failure");
        }
    }
}
