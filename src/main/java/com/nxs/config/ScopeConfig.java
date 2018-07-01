package com.nxs.config;

import com.nxs.bean.Color;
import com.nxs.bean.ColorFactoryBean;
import com.nxs.bean.Person;
import com.nxs.bean.Red;
import com.nxs.condition.LinuxCondition;
import com.nxs.condition.MyImportBeanDefinitionRegistrar;
import com.nxs.condition.MyImportSelector;
import com.nxs.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @program: spring-annotation
 * @description: 调整实例的作用域
 * @author: NieXiaoshuang
 * @create: 2018-06-27 22:45
 * (@Conditional)放在类上 满足当前条件，这个类中配置的所有bean注册才会生效
 * (@Import)导入组件，id默认是组件的全类名
 **/
//@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
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

    /**
     * (@Conditional):按照一定条件进行判断，满足条件给容器注册bean
     * 如果操作系统是windows在容器中注册 bill
     * 如果是linux则在容器中注册 linus
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person bill(){
        return new Person("Bill Gates", 62);
    }

    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person linus(){
        return new Person("linus", 50);
    }

    /**
     * 注册组件的方式
     * 1）包扫描+注解 @Controller @Service @Repository @Component []
     * 2) @Bean[导入第三方包组件]
     * 3) @Import [快速给容器导入一个组件]
     *        1) @Import(要导入到容器中的组件)容器就会自动祖册这个组件
     *        2）ImportSelector 返回需要导入组件的全类名数组
     *        3）ImportBeanDefinitionRegistrar 手工注册bean到容器中
     * 4）使用Spring提供的FactoryBean
     *      默认获取的是调用getObject创建的对象，若获取FactoryBean本身，我们需要在id前加一个 "&"
     */

    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
