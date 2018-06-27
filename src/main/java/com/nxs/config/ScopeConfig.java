package com.nxs.config;

import com.nxs.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @program: spring-annotation
 * @description: 调整实例的作用域
 * @author: NieXiaoshuang
 * @create: 2018-06-27 22:45
 **/
@Configuration
public class ScopeConfig {

    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE prototype 多实例的 ioc容器启动时并不会创建，而是在获取实例时才会调用方法创建实例，获取几次创建几次
     * ConfigurableBeanFactory#SCOPE_SINGLETON singleton 单实例的（默认值） ioc容器启动时会调用方法创建对象放到容器中，以后每次获取直接从容器(map)中get
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST request 同一个请求
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION session 同一个会话
     * 懒加载
     *  单实例bean 默认在容器启动时创建对象
     *  (@Lazy)懒加载：容器启动不会创建对象，第一次使用（获取）Bean创建对象，并初始化
     * @return
     */
//    @Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person(){
        return new Person("张三", 25);
    }
}
