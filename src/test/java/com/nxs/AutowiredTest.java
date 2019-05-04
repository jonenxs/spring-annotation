package com.nxs;

import com.nxs.bean.Boss;
import com.nxs.config.AutowiredConfig;
import com.nxs.dao.BookDao;
import com.nxs.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @program: spring-annotation
 * @description: 自动装配测试类
 * @author: NieXiaoshuang
 * @create: 2019-05-03 22:40
 **/
public class AutowiredTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutowiredConfig.class);
//        BookService bookService = applicationContext.getBean(BookService.class);
//        System.out.println(bookService.toString());
//        BookDao bookDao = applicationContext.getBean(BookDao.class);
//        System.out.println(bookDao.toString());
        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        applicationContext.close();
    }
}
