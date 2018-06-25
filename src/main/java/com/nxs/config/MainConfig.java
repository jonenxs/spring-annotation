package com.nxs.config;

import com.nxs.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-annotation
 * @description: 配置类
 * @author: NieXiaoshuang
 * @create: 2018-06-25 22:55
 * @Configuration 告诉Spring这是一个配置类
 **/
@Configuration
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
