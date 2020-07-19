package com.dianer.study.aop.cglib;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-27 00:02
 **/
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void say() {
        System.out.println(this.name + " say Hello world!!!");
    }
}
