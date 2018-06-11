package com.fintecher.contract.service.Impl;

import com.fintecher.contract.entity.ContractInfo;
import com.fintecher.contract.entity.ContractUploadFile;
import com.fintecher.contract.entity.User;
import com.fintecher.contract.mapper.ContractInfoMapper;
import com.fintecher.contract.service.ContractInfoService;
import com.fintecher.contract.service.ContractUploadFileService;
import com.fintecher.contract.vo.ContractResourceModel;
import com.fintecher.util.ZWDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ContractUploadFileServiceImpl extends BaseServiceImpl<ContractUploadFile> implements ContractUploadFileService {

   @Autowired
   private ContractInfoService contractInfoService;
    @Override
    public Integer saveContractResource(ContractResourceModel contractResourceModel, User user) {

            ContractInfo contractInfo1 = new ContractInfo();
            contractInfo1.setOrderId(contractResourceModel.getOrderId());
            contractInfoService.deleteByWhere(contractInfo1);
            if(Objects.nonNull(contractResourceModel) && !contractResourceModel.getMaterialUrls().isEmpty()){
                List<String> materialUrls = contractResourceModel.getMaterialUrls();
                for(String url : materialUrls)
                {
                    ContractUploadFile contractUploadFile = new ContractUploadFile();
                    contractUploadFile.setOrderId(contractResourceModel.getOrderId());
                    contractUploadFile.setOperator(user.getId());
                    contractUploadFile.setOperateTime(ZWDateUtil.getNowDateTime());
                    contractUploadFile.setIsDelete(0);//默认0
                    contractUploadFile.setMaterialUrl(url);
                    this.save(contractUploadFile);

                    ContractInfo contractInfo = new ContractInfo();
                    contractInfo.setOrderId(contractResourceModel.getOrderId());
                    contractInfo.setPdfUrl(url);
                    contractInfo.setContractName("汽车融资租赁合同");
                    contractInfoService.save(contractInfo);
                }
                /*contractResourceModel.getMaterialUrls().forEach(str -> {
                    ContractUploadFile contractUploadFile = new ContractUploadFile();
                    contractUploadFile.setOrderId(contractResourceModel.getOrderId());
                    contractUploadFile.setOperator(user.getId());
                    contractUploadFile.setOperateTime(ZWDateUtil.getNowDateTime());
                    contractUploadFile.setIsDelete(0);//默认0
                    contractUploadFile.setMaterialUrl(str);
                    this.save(contractUploadFile);
                });*/
            }
            return null;
    }
}
