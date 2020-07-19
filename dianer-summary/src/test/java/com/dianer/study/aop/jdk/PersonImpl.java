package com.dianer.study.aop.jdk;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-27 00:02
 **/
public class PersonImpl implements Person {

    private String name;

    public PersonImpl(String name) {
        this.name = name;
    }

    @Override
    public void say() {
        System.out.println(this.name + " say Hello world!!!");
    }
}
