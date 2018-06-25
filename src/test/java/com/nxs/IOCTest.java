package com.nxs;

import com.nxs.config.MainConfig;
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
}
