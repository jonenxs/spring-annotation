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
 * 初始化前   postProcessBeforeInitialization
 * 初始化
 *      对象创建完成，并赋值好，调用初始化方法
 * 初始化后 BeanPostProcessor.postProcessAfterInitialization
 * 销毁
 *      单实例：容器关闭时
 *      多实例：容器不会管理bean 容器不会调用销毁方法
 *
 * BeanPostProcessor 原理
 *      AbstractAutowireCapableBeanFactory.doCreateBean()
 *遍历得到容器中所有的BeanPostProcessor 依次执行 beforeInitialization
 * 一旦返回null跳出循环，不会执行后面的BeanPostProcessor.postProcessorsBeforeInitialization
 *  populateBean(beanName, mbd, instanceWrapper)  给bean进行属性赋值；
 *  initializeBean(beanName, exposedObject, mbd) {
 *      applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *      invokeInitMethods(beanName, wrappedBean, mbd); 执行初始化初始化方法
 *      applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 * }
 *
 *
 *
 * 1)、指定初始化和销毁方法
 *      指定init-method="" destroy-method=""
 * 2)、通过让bean实现InitializingBean(定义初始化逻辑) 和DisposableBean（定义销毁逻辑）Car
 * 3)、可以使用JSR250 Dog
 *      @PostConstruct : 在Bean创建完成并且属性赋值完成
 *      @PreDestory : 在容器销毁bean之前通知我们进行清理操作
 * 4)、BeanPostProcessor:bean后置处理器  MyBeanPostProcessor
 *       在bean初始化前后进行一些处理工作
 *       postProcessBeforeInitialization 初始化前
 *       postProcessAfterInitialization 初始化后
 *
 *  spring底层对 BeanPostProcessor 的使用
 *         bean赋值 注入其它组件 @Autowired 生命周期注解 @Async
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
