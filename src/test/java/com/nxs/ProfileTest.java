package com.nxs;

import com.nxs.config.ProfileConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @program: spring-annotation
 * @description:
 * @author: NieXiaoshuang
 * @create: 2019-05-04 14:15
 **/
public class ProfileTest {

    /**
     * 1、使用命令行动态参数：在虚拟机参数位置加载 -Dspring.profiles.active=test
     * 2、使用代码激活某个环境，需要使用无参构造器
     */
    @Test
    public void test(){
        //1. 创建 applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //2. 设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test", "dev");
        //3.注册主配置类
        applicationContext.register(ProfileConfig.class);
        //4.启动刷新容器
        applicationContext.refresh();

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        Arrays.stream(namesForType).forEach(System.out::println);

        applicationContext.close();
    }
}
