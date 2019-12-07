package com.dianer.study.设计模式.观察者模式;

public class SecondObserver extends Observer {

    public SecondObserver(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("Second Observer " + this.subject.getState());
    }
}
