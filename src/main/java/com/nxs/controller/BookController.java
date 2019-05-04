package com.nxs.controller;

import com.nxs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @program: spring-annotation
 * @description: BookController
 * @author: NieXiaoshuang
 * @create: 2018-06-25 23:13
 **/
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
}
