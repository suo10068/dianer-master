package com.dianer.study.设计模式.代理模式.jdk;

public class Singer implements ISinger {

    protected String name;

    public Singer(String name) {
        this.name = name;
    }

    @Override
    public void sing() {
        System.out.println("Singer-1 sing " + name + "!!!!");
    }

    @Override
    public void sing2() {
        System.out.println("Singer-1 sing2 " + name + "!!!!");
    }
}
