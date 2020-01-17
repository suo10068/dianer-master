package com.dianer.学习模块.设计模式.观察者模式;

/**
 * 观察者抽象类
 */
public abstract class Observer {

    Subject subject; // 被观察对象

    Observer(Subject subject) {
        this.subject = subject;
    }

    protected Observer() {
    }

    public abstract void update();
}
