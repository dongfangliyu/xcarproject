package com.fintecher.contract.util;

import com.fintecher.contract.service.policy.ContractGeneratorPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.OrderComparator;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author wxc
 * @Data 2018/2/6 13:50
 * @Description 获取ContractGeneratorPolicy类实例
 * 把ContractGeneratorPolicy接口的实例都放到cps集合中
 */
@Component
public class ContractFactoryPostProcessor implements BeanPostProcessor {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof ContractGeneratorPolicy) {
            logger.info("Bean '" + beanName + "' of type [" + bean.getClass() +"] added  generatorPolicy list " );
            List<ContractGeneratorPolicy> cps=ContractFactory.getGeneratorPolicyList();
            cps.add((ContractGeneratorPolicy)bean);
            OrderComparator.sort(cps);
        }
        return bean;
    }
}
