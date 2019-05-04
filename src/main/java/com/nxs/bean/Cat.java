package com.nxs.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description: Cat
 * @author: NieXiaoshuang
 * @create: 2018-07-16 23:04
 **/
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat --- constructor ---");
    }

    /**
     * 自定义初始化方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat --- afterPropertiesSet ---");
    }

    /**
     * 自定义销毁方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("cat --- destroy ---");
    }
}
