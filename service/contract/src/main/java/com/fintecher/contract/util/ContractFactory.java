package com.fintecher.contract.util;

import com.fintecher.contract.service.ContractBuilder.ContractBuilder;
import com.fintecher.contract.service.policy.ContractGeneratorPolicy;
import com.fintecher.contract.vo.JsonModel;
import com.github.pagehelper.StringUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wxc
 * @Data 2018/2/6 13:36
 * @Description 合同工厂类
 */
@Service
public class ContractFactory implements ApplicationContextAware{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static List<ContractGeneratorPolicy> cps = new ArrayList<>();//在生成和配置bean时把所有的合同处理类放到这个集合中

    public static ApplicationContext applicationContext;

    private static ContractFactory cf=null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContractFactory.applicationContext=applicationContext;
    }

    /**
     * 获取工厂类实例
     * @return
     */
    public static ContractFactory getInstance(){
        if(cf==null){
            return applicationContext.getBean(ContractFactory.class);
        }else{
            return cf;
        }
    }

    /**
     * 生成合同生成类集合
     * @return
     */
    static List<ContractGeneratorPolicy> getGeneratorPolicyList(){
        return cps;
    }

    /**
     * 根据合同枚举code获取对应的合同创建类
     * @param muneCode
     * @return
     */
    public ContractBuilder generateEnum(String muneCode){
        for (ContractGeneratorPolicy gp: cps) {
            if (gp.match(null,muneCode)) {
                ContractBuilder cb = gp.get(null,muneCode);
                return cb;
            }
        }
        return null;
    }

    public JsonModel generate(JSONObject param, String modeCode, String channel) throws Exception{
        JsonModel result = new JsonModel();
        result.setCode(ContractCode.EXCE00005.getCode());
        for (ContractGeneratorPolicy gp: cps) {
            if (gp.match(param,modeCode)) {
                ContractBuilder cb = gp.get(param,modeCode);
                //参数传入相应的模板中,并且验证相应的信息
//                if(!"fromFTP".equals(cb.getContractEnum().getTemplateName()) && StringUtil.isEmpty((String)param.get("contractDataJson"))){ // 如果传参数为空
//                    result.setCode(ContractCode.EXCE00006.getCode());
//                    result.setInfo(ContractCode.EXCE00006.getInfo()+"-"+modeCode);
//                    return result;
//                }

                JsonModel jm = null;
                if(!"fromFTP".equals(cb.getContractEnum().getTemplateName())){
                    JSONObject paramJson = JSONObject.fromObject(param.get("contractDataJson"));
//                    jm = cb.verificationParam(paramJson);
//                    if (!jm.getCode().equals(ContractCode.SUCC00002.getCode())) {
//                        logger.warn(jm.getInfo());
//                        return jm;
//                    }
                }
                logger.warn("合同生成：申请单ID="+modeCode);
                jm = cb.build(param, modeCode, channel);
                return jm;
            }
        }
        return result;
    }
}
