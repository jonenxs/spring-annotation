package com.nxs.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: spring-annotation
 * @description:
 * @author: NieXiaoshuang
 * @create: 2019-05-03 23:19
 * 默认加在ioc容器中的组件 容器启动会调用无参构造器 创建对象 再进行初始化赋值操作
 **/
@Component
public class Boss {

    private Car car;

    public Car getCar() {
        return car;
    }

    /**
     * @Autowired 标注在方法
     * spring容器创建当前对象，就会调用方法完成赋值
     * 方法使用的参数 自定义类型的值从ioc容器中获取
     * @param car
     */
//    @Autowired
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * 标在构造器位置 ，构造器要用的组件也是从容器中获取
     * @param car
     */
    @Autowired
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss ... 有参构造器");
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
