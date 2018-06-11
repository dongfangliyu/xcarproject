package com.fintecher.contract.rest;

import com.fintecher.common.vo.manage.ResponseResult;
import com.fintecher.contract.config.annotation.CurrentUser;
import com.fintecher.contract.entity.ContractInfo;
import com.fintecher.contract.entity.ContractUploadFile;
import com.fintecher.contract.entity.User;
import com.fintecher.contract.service.ContractInfoService;
import com.fintecher.contract.service.ContractService;
import com.fintecher.contract.service.ContractUploadFileService;
import com.fintecher.contract.vo.ContractParams;
import com.fintecher.contract.vo.ContractResourceModel;
import com.fintecher.contract.vo.ResultJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @Author wxc
 * @Data 2018/2/2 10:51
 * @Description 车贷金融--合同管理
 */

@RestController
@RequestMapping("/contractController")
@Api(description = "合同管理模块")
public class ContractController extends BaseController{

    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractUploadFileService contractUploadFileService;
    @Autowired
    private ContractInfoService contractInfoService;
    @Resource
    RestTemplate restTemplate;

    @GetMapping("/createContract")
    @ApiOperation(value = "生成合同",notes = "生成合同")
    public ResponseResult<ResultJson> createContract(ContractParams contractParams){
        try{
            ResultJson resultJson = contractService.buildContracts(contractParams);
            return new ResponseResult(ResponseResult.Status.SUCCESS,resultJson);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"合同生成失败！");
        }
    }

    @GetMapping("/createOneContract")
    @ApiOperation(value = "生成合同",notes = "生成合同")
    public ResponseResult<String> createOneContract(@RequestParam Long orderId,@RequestParam String contectEnum){
        try{
            MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
            param.add("id", orderId.toString());
            ResponseEntity<String> url = restTemplate.postForEntity("http://service-manage/productOrder/updateOrderContract",param, String.class);
            ContractInfo contractInfo = contractService.getContractNum(orderId);
            if (Objects.nonNull(contractInfo)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"此订单已存在合同，请勿重复生成");
            }
            ResultJson resultJson = contractService.buildContract(orderId,contectEnum);
            return new ResponseResult(ResponseResult.Status.SUCCESS,resultJson);
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"合同生成失败！");
        }
    }

    @GetMapping("/previewContract")
    @ApiOperation(value = "带参合同模板预览",notes = "带参合同模板预览")
    public ResponseResult previewContract(@RequestParam Long contractId){
        try{
            String html = contractService.previewContract(contractId);
            if(Objects.isNull(html)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"合同信息不存在！");
            }
            return new ResponseResult(ResponseResult.Status.SUCCESS,html);
        } catch (Exception e){
            log.error(e.getMessage(), e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"预览失败！");
        }
    }

    @GetMapping("/createBlankContract")
    @ApiOperation(value = "生成不带参数空的合同模板",notes = "生成不带参数空的合同模板")
    public ResponseResult createBlankContract(String enumCode){
        try{
            String url = contractService.createBlankContract(enumCode);
            if(Objects.isNull(url)){
                return new ResponseResult(ResponseResult.Status.FAILURE,"合同生成失败！");
            }
            return new ResponseResult(ResponseResult.Status.SUCCESS,url);
        } catch (Exception e){
            return new ResponseResult(ResponseResult.Status.FAILURE,"生成失败！");
        }
    }

    @PostMapping("/uploadContractResource")
    @ApiOperation(value = "合同资料的上传 ",notes = "合同资料的上传")
    @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header")
    public ResponseResult uploadContractResource(@RequestBody ContractResourceModel contractResourceModel,
                                                 @CurrentUser  @ApiIgnore User user){
        try{
            if (Objects.nonNull(contractResourceModel)){
                contractUploadFileService.saveContractResource(contractResourceModel,user);
                return new ResponseResult(ResponseResult.Status.SUCCESS,"保存成功！");
            }
            return new ResponseResult(ResponseResult.Status.FAILURE,"上传资料为空！");
        }catch (Exception e){
            return new ResponseResult(ResponseResult.Status.FAILURE,"上传资料失败！");
        }
    }
    @GetMapping("/getContractResourceAll")
    @ApiOperation(value = "查看订单合同资料",notes = "查看订单合同资料")
    public ResponseResult getContractResourceAll(@RequestParam Long orderId){
        try{
            Example example = new Example(ContractInfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("orderId",orderId);
            List<ContractInfo> list = contractInfoService.selectByExample(example);
            return new ResponseResult(ResponseResult.Status.SUCCESS,list);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return new ResponseResult(ResponseResult.Status.FAILURE,"查询失败");
        }
    }
}
