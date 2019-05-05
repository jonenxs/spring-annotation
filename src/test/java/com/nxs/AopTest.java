package com.nxs;

import com.nxs.aop.MathCalculator;
import com.nxs.config.AopConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description: 切面测试
 * @author: NieXiaoshuang
 * @create: 2019-05-04 15:13
 **/
public class AopTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        MathCalculator calculator = applicationContext.getBean(MathCalculator.class);
        calculator.div(4, 2);
        applicationContext.close();
    }
}
