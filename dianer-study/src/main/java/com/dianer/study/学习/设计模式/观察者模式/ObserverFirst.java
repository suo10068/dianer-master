package com.dianer.study.学习.设计模式.观察者模式;

public class ObserverFirst extends Observer {

    public ObserverFirst(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("First Observer " + this.subject.getState());
    }
}
