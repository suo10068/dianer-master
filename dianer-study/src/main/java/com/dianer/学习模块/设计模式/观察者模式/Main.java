package com.dianer.学习模块.设计模式.观察者模式;

/**
 * 观察者模式
 * 优点：
 * 1、观察者和被观察者是抽象耦合的。
 * 2、建立一套触发机制。
 * <p>
 * 缺点：
 * 1、如果一个被观察者对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多时间。
 * 2、如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。
 * 3、观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。
 * <p>
 * <p>
 * Subject 被观察者
 * Observer 观察者抽象类
 * FirstObserver、SecondObserver 观察者实体类
 */

public class Main {
    public static void main(String[] args) {

        // 被观察对象
        Subject subject = new Subject();
        // 两个观察者
        ObserverFirst firstObserver = new ObserverFirst(subject);
        ObserverSecond secondObserver = new ObserverSecond(subject);
        // 添加观察者
        subject.attach(firstObserver);
        subject.attach(secondObserver);

        subject.attach(new Observer(subject) {
            @Override
            public void update() {
                System.out.println("Third Observer state = " + this.subject.getState());
            }
        });

        subject.setState(4);
    }



}
