package com.nxs.bean;

import lombok.Data;

/**
 * @program: spring-annotation
 * @description: Person
 * @author: NieXiaoshuang
 * @create: 2018-06-25 22:51
 **/
@Data
public class Person {

    private String name;

    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
