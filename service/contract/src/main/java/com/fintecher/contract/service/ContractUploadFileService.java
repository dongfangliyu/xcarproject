package com.fintecher.contract.service;

import com.fintecher.contract.entity.ContractUploadFile;
import com.fintecher.contract.entity.User;
import com.fintecher.contract.vo.ContractResourceModel;

import java.util.List;

public interface ContractUploadFileService extends BaseService<ContractUploadFile>{

    /**
     * 保存合同上传文件
     * @param contractResourceModel
     * @param user
     * @return
     */
    Integer saveContractResource(ContractResourceModel contractResourceModel, User user);
}
