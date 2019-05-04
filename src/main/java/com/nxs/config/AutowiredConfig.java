package com.nxs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-annotation
 * @description: 自动装配
 * @author: NieXiaoshuang
 * @create: 2019-05-03 22:35
 *  Spring利用依赖注入（DI）完成对IOC容器中各个组件的依赖关系赋值
 *  1、@Autowired 自动注入[spring规范]
 *   1)默认优先按照类型去容器中找对应的组件 applicationContext.getBean(BookDao.class)
 *   2)如果找到多个相同类型的组件 再将属性的名称作为组件的id去容器中查找
 *   3)使用@Qualifier()指定需要装配的组件id
 *   4)自动装配默认一定要将属性赋值好，没有就报错,可以使用 required = false 非强制装配
 *   5）@Primary 让spring进行自动装配的时候使用首选的bean 也可以继续使用 @Qualifier 指定需要装配的bean
 *  2、Spring还支持使用@Resource(JSR250) 和@Inject(JSR330)[java规范]
 *      @Resource
 *          可以和@Autowired一样实现自动装配功能 默认是按照组件名称进行装配
 *          不有支持 @Primary 和 required = false
 *      @Inject
 *          需要先导入javax.inject的包，和Autowired的功能一样
 *          不支持required = false
 *  3、@Autowired 构造器 参数 方法 属性 都是从容器中获取组建的值
 *      1）标注在方法位置
 *      2）标注在构造器位置 如果组件只有一个有参构造器 这个有参构造器的@Autowired可以省略，参数未知的组件还是可以自动从容器中获取
 *      3）放在参数位置 @Bean标注的方法创建对象的时候 方法参数的值从容器中获取
 *  4、自定义组件想要使用spring容器底层的一些组件（ApplicationContext BeanFactory xxx）
 *        自定义组件实现xxxAware 在创建对象的时候 会调用接口规定的方法注入相关组件 Aware
 **/
@Configuration
@ComponentScan({"com.nxs.dao","com.nxs.service","com.nxs.controller","com.nxs.bean"})
public class AutowiredConfig {

}
