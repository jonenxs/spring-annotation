package com.nxs.service;

import com.nxs.dao.BookDao;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @program: spring-annotation
 * @description: BookService
 * @author: NieXiaoshuang
 * @create: 2018-06-25 23:13
 **/
@ToString
@Service
public class BookService {

    @Qualifier("bookDao2")
    @Autowired(required = false)
//    @Resource(name = "bookDao2")
//    @Inject
    private BookDao bookDao;

    private void print(){
        System.out.println(bookDao);
    }
}
