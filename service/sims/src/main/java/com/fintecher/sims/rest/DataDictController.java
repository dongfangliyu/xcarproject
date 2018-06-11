package com.fintecher.sims.rest;

import com.fintecher.sims.entity.DataDict;
import com.fintecher.sims.mapper.DataDictMapper;
import com.fintecher.sims.service.DataDictService;
import com.fintecher.sims.vo.PageParam;
import com.fintecher.sims.vo.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Objects;

/**
 * @System:
 * @Auther: dwx
 * @Description:
 * @Date:Created on 2018/3/14 14:20
 * @Modified By：
 */

@RestController
@RequestMapping("/dataDict")
@Api(value = "数据字典项",description = "数据字典项")
public class DataDictController extends BaseController {
    @Autowired
    private DataDictService dataDictService;
        /**
         * @System:
         * @Auther: dwx
         * @Description:查询数据字典项
         * @Modified By：
         */
        @GetMapping("/getAll")
        @ApiOperation(value = "查询数据字典项", notes = "查询数据字典项")
        public ResponseResult getAll() {
            log.debug("request to get all");
            try {
                return new ResponseResult(ResponseResult.Status.SUCCESS, "", dataDictService.getAll());
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return new ResponseResult<>(ResponseResult.Status.FAILURE,"查询失败");
            }
        }
    /**
     * @System:
     * @Auther: dwx
     * @Description: 查询数据字典类型对应的数据字典项
     * @Modified By:
     */
    @GetMapping("/getAllDataDict")
    @ApiOperation(value = "查询数据字典类型对应的数据字典项", notes = "查询数据字典类型对应的数据字典项")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", defaultValue = "1", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", defaultValue = "10", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. ")
    })
    public ResponseResult getAllDataDict(@RequestParam @ApiParam(value = "数据字典类型code码", required = true) String code,
                                         @RequestParam(required = false) @ApiParam(value = "数据名称") String name,
                                         PageParam pageParam) {
        log.debug("request to get all data dict");
        try {
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize(), "sort ASC");
            List<DataDict> list = dataDictService.getAllDataDict(code, name);
            PageInfo<DataDict> pageInfo = new PageInfo<>(list);
            return new ResponseResult(ResponseResult.Status.SUCCESS, "", pageInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE,"查询失败");
        }
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 删除数据字典项
     * @Modified By:
     */
    @DeleteMapping("/deleteDataDict")
    @ApiOperation(value = "删除数据字典项", notes = "删除数据字典项")
    public ResponseResult deleteDataDict(@RequestParam @ApiParam(value = "数据字典项ID", required = true) Integer id) {
        log.debug("request to delete data dict");
        try {
            DataDict dataDict = new DataDict();
            dataDict.setId(id);
            dataDictService.deleteDataDict(dataDict);
            return new ResponseResult(ResponseResult.Status.SUCCESS, "删除成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, "删除失败");
        }
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 新增/修改数据字典项
     * @Modified By:
     */
    @PostMapping("/createOrModifyDataDict")
    @ApiOperation(value = "新增/修改数据字典项", notes = "新增/修改数据字典项")
    public ResponseResult createOrModifyDataDict(@RequestBody DataDict dataDict) {
        log.debug("request to create or modify data dict");
        try {
            if (Objects.isNull(dataDict.getId())) {
                Integer i = dataDictService.getMaxId();
                dataDict.setId(i + 1);
                Integer sort = dataDictService.getMaxSort(dataDict.getTypeCode());
                dataDict.setSort(Objects.isNull(sort) ? 0 : sort + 1);
                dataDictService.saveDataDict(dataDict);
            } else {
                dataDictService.updateDataDict(dataDict);
            }
            return new ResponseResult(ResponseResult.Status.SUCCESS, "");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, "新增失败");
        }
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 查询数据字典类型对应的数据字典项
     * @Modified By:
     */
    @GetMapping("/getDataDictByTypeCode")
    @ApiOperation(value = "查询数据字典类型对应的数据字典项", notes = "查询数据字典类型对应的数据字典项")
    public ResponseResult getDataDictByTypeCode(@RequestParam(value = "typeCode") @ApiParam(value = "code") String typeCode) {
        log.debug("request to get all data dict");
        try {
            List<DataDict> list = dataDictService.findDataDictByTypeCode(typeCode, null);
            return new ResponseResult(ResponseResult.Status.SUCCESS, "", list);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE,"查询失败" );
        }
    }

    /**
     * @System:
     * @Auther: dwx
     * @Description: 分页查询数据字典类型对应的数据字典项
     * @Modified By:
     */
    @GetMapping("/getDataDictByTypeCodeWithPage")
    @ApiOperation(value = "分页查询数据字典类型对应的数据字典项", notes = "分页查询数据字典类型对应的数据字典项")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", defaultValue = "1", dataType = "integer", paramType = "query",
                    value = "页数 (1..N)"),
            @ApiImplicitParam(name = "size", defaultValue = "10", dataType = "integer", paramType = "query",
                    value = "每页大小"),
            @ApiImplicitParam(name = "sort", dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名1 asc,属性名2 desc. ")
    })
    public ResponseResult getDataDictByTypeCodeWithPage(@RequestParam @ApiParam(value = "code码", required = true) String typeCode,
                                                        @RequestParam(required = false) @ApiParam(value = "名称") String name,
                                                        @ApiIgnore PageParam pageParam) {
        log.debug("request to get all data dict");
        try {
            PageHelper.startPage(pageParam.getPage(), pageParam.getSize(), true);
            List<DataDict> list = dataDictService.findDataDictByTypeCode(typeCode, name);
            PageInfo<DataDict> pageInfo = new PageInfo<>(list);
            return new ResponseResult(ResponseResult.Status.SUCCESS, "", pageInfo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseResult<>(ResponseResult.Status.FAILURE, "查询失败");
        }
    }
}
