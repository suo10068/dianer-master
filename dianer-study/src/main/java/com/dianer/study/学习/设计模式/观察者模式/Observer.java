package com.dianer.study.学习.设计模式.观察者模式;

/**
 * 观察者抽象类
 */
public abstract class Observer {

    Subject subject; // 被观察对象

    public abstract void update();
}
