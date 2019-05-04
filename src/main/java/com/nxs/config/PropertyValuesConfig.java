package com.nxs.config;

import com.nxs.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @program: spring-annotation
 * @description: 属性赋值
 * @author: NieXiaoshuang
 * @create: 2019-05-03 22:07
 * 使用 @PropertySource 读取外部配置文件的k/v到环境变量中
 **/
@PropertySource(value = {"classpath:/person.properties"},encoding = "UTF-8")
@Configuration
public class PropertyValuesConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
