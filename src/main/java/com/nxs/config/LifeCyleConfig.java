package com.nxs.config;

import com.nxs.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean 生命周期
 * bean 创建---初始化---销毁
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法：容器在bean进行到当前生命周期的时候来调用我们
 * 自定义的初始化和销毁方法
 * 构造（对象创建）
 *       单实例：在容器启动时创建对象
 *       多实例：在容器获取时创建对象
 * 初始化
 *      对象创建完成，并赋值好，调用初始化方法
 *  销毁
 *      单实例：容器关闭时
 *      多实例：容器不会管理
 * 1)、指定初始化和销毁方法
 *      指定init-method="" destroy-method=""
 * 2)、通过让bean实现InitializingBean(定义初始化逻辑) 和DisposableBean（定义销毁逻辑）
 * @program: spring-annotation
 * @description: 生命周期配置类
 * @author: NieXiaoshuang
 * @create: 2018-07-16 22:41
 **/
@ComponentScan("com.nxs.bean")
@Configuration
public class LifeCyleConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}
