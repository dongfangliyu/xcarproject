package com.fintecher.contract.service.policy;

import com.fintecher.contract.service.ContractBuilder.ContractBuilder;
import com.fintecher.contract.service.ContractBuilder.DirectRentBuilder;
import com.fintecher.contract.service.ContractBuilder.ECA001Builder;
import com.fintecher.contract.service.ContractBuilder.FullSalesBuilder;
import com.fintecher.contract.util.ContractEnum;
import com.fintecher.contract.util.ContractFactory;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @Author wxc
 * @Data 2018/2/6 14:08
 * @Description 策略匹配实现类
 */
@Component
public class ModelPolicy implements ContractGeneratorPolicy{

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public boolean match(JSONObject param, String modeCode) {
        // TODO: 2018/2/6 对应的模板匹配规则
        if (modeCode.equals(ContractEnum.EC_A001.getCode())
                || modeCode.equals(ContractEnum.DIRECT_RENT.getCode())
                ||modeCode.equals(ContractEnum.FULL_SALES.getCode())
//                || modeCode.equals(ContractEnum.EC_A004.getCode())
//                || modeCode.equals(ContractEnum.EC_F001.getCode())
//                || modeCode.equals(ContractEnum.EC_F002.getCode())
//                || modeCode.equals(ContractEnum.EC_F003.getCode())
//                || modeCode.equals(ContractEnum.EC_A005.getCode())
//                || modeCode.equals(ContractEnum.EC_A006.getCode())
//                || modeCode.equals(ContractEnum.EC_A007.getCode())
//                || modeCode.equals(ContractEnum.EC_A008.getCode())
                ) {
            return true;
        }
        return false;
    }

    @Override
    public ContractBuilder get(JSONObject param, String modeCode) {
        // TODO: 2018/2/6 返回对应的合同生成类
        if (modeCode.equals(ContractEnum.EC_A001.getCode())) {
            return ContractFactory.applicationContext.getBean(ECA001Builder.class);
        }
        if (modeCode.equals(ContractEnum.DIRECT_RENT.getCode())) {
            return ContractFactory.applicationContext.getBean(DirectRentBuilder.class);
        }
        //全额销售策略匹配
        if (modeCode.equals(ContractEnum.FULL_SALES.getCode())){
            return ContractFactory.applicationContext.getBean(FullSalesBuilder.class);
        }
//        if (modeCode.equals(ContractEnum.EC_A004.getCode())) {
//            return ContractFactory.applicationContext.getBean(ECA004Builder.class);
//        }
//        if (modeCode.equals(ContractEnum.EC_F001.getCode())) {
//            return ContractFactory.applicationContext.getBean(ECF001Builder.class);
//        }
//        if (modeCode.equals(ContractEnum.EC_F002.getCode())) {
//            return ContractFactory.applicationContext.getBean(ECF002Builder.class);
//        }
//        if (modeCode.equals(ContractEnum.EC_F003.getCode())) {
//            return ContractFactory.applicationContext.getBean(ECF003Builder.class);
//        }
//        if (modeCode.equals(ContractEnum.EC_A005.getCode())) {
//            return ContractFactory.applicationContext.getBean(ECA005Builder.class);
//        }
//        if (modeCode.equals(ContractEnum.EC_A006.getCode())) {
//            return ContractFactory.applicationContext.getBean(ECA006Builder.class);
//        }
//        if (modeCode.equals(ContractEnum.EC_A007.getCode())) {
//            return ContractFactory.applicationContext.getBean(ECA007Builder.class);
//        }
//        if (modeCode.equals(ContractEnum.EC_A008.getCode())) {
//            return ContractFactory.applicationContext.getBean(ECA008Builder.class);
//        }
        return null;
    }
}
