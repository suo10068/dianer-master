package com.dianer.study.学习.设计模式.代理模式.JDK动态代理;

public class Singer implements ISinger {

    protected String name;

    public Singer(String name) {
        this.name = name;
    }

    @Override
    public void sing() {
        System.out.println("Singer-1 sing " + name + "!!!!");
    }
}
