package com.nxs;

import com.nxs.bean.Person;
import com.nxs.config.MainConfig;
import com.nxs.config.ScopeConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @program: spring-annotation
 * @description: IOCTest
 * @author: NieXiaoshuang
 * @create: 2018-06-25 23:15
 **/
public class IOCTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);

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

    @Test
    public void test03() {


        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name: beanNamesForType
        ) {
            System.out.println(name);
        }

        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames
        ) {
            System.out.println(beanDefinitionName);
        }
    }

    @Test
    public void testImport(){
        printBeans(applicationContext);
    }
}
