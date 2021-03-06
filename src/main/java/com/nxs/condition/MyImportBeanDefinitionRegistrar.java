package com.nxs.condition;

import com.nxs.bean.Rainbow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @program: spring-annotation
 * @description: ImportBeanDefinitionRegistrar
 * @author: NieXiaoshuang
 * @create: 2018-07-01 23:29
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *  把所有需要添加到容器中bean: BeanDefinitionRegistry.registerBeanDefinition自定义手工注册
     * @param importingClassMetadata 当前类的注解信息
     * @param registry BeanDefinition 注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.nxs.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.nxs.bean.Blue");
        if (red && blue) {
            //指定Bean定义信息（Bean类型，scope作用域。。。）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Rainbow.class);
            registry.registerBeanDefinition("rainbow",rootBeanDefinition);
        }
    }
}
