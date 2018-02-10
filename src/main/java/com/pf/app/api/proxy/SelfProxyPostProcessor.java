package com.pf.app.api.proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class SelfProxyPostProcessor implements BeanPostProcessor {
    public SelfProxyPostProcessor() {
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof SelfProxy) {
            ((SelfProxy) bean).setSelf((SelfProxy) bean);
        }

        return bean;
    }
}
