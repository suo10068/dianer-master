package com.dianer.study.学习.设计模式.代理模式.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        System.out.println("AAAA");

        ISinger target = new Singer("种豆得豆");

        ISinger proxy = (ISinger) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("向观众问好");
                        Object returnValue = method.invoke(target, args);
                        System.out.println("演唱结束。。。。");
                        return returnValue;
                    }
                });
        proxy.sing();
    }

}
