package com.nxs;

import com.nxs.config.LifeCyleConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description: bean生命周期测试类
 * @author: NieXiaoshuang
 * @create: 2018-07-16 22:48
 **/
public class LifeCycleTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifeCyleConfig.class);
        System.out.println("容器创建完成");
        applicationContext.close();

    }
}
