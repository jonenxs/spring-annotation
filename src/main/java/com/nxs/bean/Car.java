package com.nxs.bean;

import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description: Car
 * @author: NieXiaoshuang
 * @create: 2018-07-16 22:45
 **/
@Component
public class Car {

    public Car() {
        System.out.println("car ---- constructor -----");
    }

    public void init(){
        System.out.println("car ---- init ---");
    }

    public void destroy(){
        System.out.println("car ---- destroy ---");
    }
}
