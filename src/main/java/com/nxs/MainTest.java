package com.nxs;

import com.nxs.bean.Person;
import com.nxs.config.MainConfig;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: spring-annotation
 * @description: Test
 * @author: NieXiaoshuang
 * @create: 2018-06-25 22:50
 **/
@Log
public class MainTest {

    public static void main(String[] args) {
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) xmlApplicationContext.getBean("person");
        log.info("person=" + person);

        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = configApplicationContext.getBean(Person.class);
        log.info("bean=" + bean);
        String[] beanNamesForType = configApplicationContext.getBeanNamesForType(Person.class);
        for (String beanNames : beanNamesForType) {
            log.info("beanNames=" + beanNames);
        }
    }
}
