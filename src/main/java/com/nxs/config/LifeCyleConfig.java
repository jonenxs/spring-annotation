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
 * 3)、可以使用JSR250
 *      @PostConstruct : 在Bean创建完成并且属性赋值完成
 *      @PreDestory : 在容器销毁bean之前通知我们进行清理操作
 * 4)、BeanPostProcessor:bean后置处理器
 *       在bean初始化前后进行一些处理工作
 *       postProcessBeforeInitialization 初始化前
 *       postProcessAfterInitialization 初始化后
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
