package com.nxs.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description: 后置处理器：初始化前后进行处理工作
 * @author: NieXiaoshuang
 * @create: 2018-07-16 23:59
 **/
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor --- postProcessBeforeInitialization --- bean:" + bean + " --- beanName:" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor --- postProcessAfterInitialization --- bean:" + bean + " --- beanName:" + beanName);
        return bean;
    }
}
