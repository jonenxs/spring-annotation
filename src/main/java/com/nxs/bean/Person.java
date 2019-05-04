package com.nxs.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @program: spring-annotation
 * @description: Person
 * @author: NieXiaoshuang
 * @create: 2018-06-25 22:51
 **/
@Data
public class Person {

    /**
     * 使用@Value赋值
     * 1.基本数据
     * 2.SpEl #{}
     * 3.${} 配置文件【properties】中的值（在运行环境变量的值）
     */
    @Value("张三")
    private String name;

    @Value("#{20-2}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
