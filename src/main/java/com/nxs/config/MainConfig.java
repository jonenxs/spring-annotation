package com.nxs.config;

import com.nxs.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @program: spring-annotation
 * @description: 配置类
 * @author: NieXiaoshuang
 * @create: 2018-06-25 22:55
 * @Configuration 告诉Spring这是一个配置类
 * @ComponentScan value 指定要扫描的包 excludeFilters 指定扫描时排除那些组件
 * includeFilters 指定扫描时只包含那些组件
 **/
@Configuration
@ComponentScan(value = "com.nxs" ,
//        excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//        },
        includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class})
}, useDefaultFilters = false)
public class MainConfig {

    /**
     * @Bean 向spring容器中注册一个bean
     * 类型为返回值的类型，id默认为方法名
     * @return
     */
    @Bean("person")
    public Person person(){
        return new Person("lisi", 19);
    }
}
