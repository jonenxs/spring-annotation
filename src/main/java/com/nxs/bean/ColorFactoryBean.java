package com.nxs.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @program: spring-annotation
 * @description: Spring定义的FactoryBean
 * @author: NieXiaoshuang
 * @create: 2018-07-01 23:42
 **/
public class ColorFactoryBean implements FactoryBean<Color> {

    /**
     *
     * @return Color对象
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("Create Color Bean");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否单例
     * @return true: 单例
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
