package com.nxs;

import com.nxs.config.MainConfig;
import com.nxs.config.ScopeConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description: IOCTest
 * @author: NieXiaoshuang
 * @create: 2018-06-25 23:15
 **/
public class IOCTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames
             ) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames
        ) {
            System.out.println(beanDefinitionName);
        }

        /**
         * 默认是单实例的
         */
        Object person = applicationContext.getBean("person");
        Object person2 = applicationContext.getBean("person");
        System.out.println(person == person2);
    }
}
