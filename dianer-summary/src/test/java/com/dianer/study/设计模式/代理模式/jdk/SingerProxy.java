package com.dianer.study.设计模式.代理模式.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: root
 * @description:
 * @author: dianer
 * @create: 2020-04-03 14:43
 **/
public class SingerProxy implements InvocationHandler {

    private ISinger target;

    private SingerProxy() {

    }

    public SingerProxy(ISinger target) {
        this.target = target;
    }

    public static ISinger getProxy() {
        ISinger proxy = (ISinger) Proxy.newProxyInstance(
                ISinger.class.getClassLoader(),
                new Class[]{ISinger.class},
                new SingerProxy());

        return proxy;
    }

    public static ISinger getProxy(ISinger target) {
        ISinger proxy = (ISinger) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new SingerProxy(target));

        return proxy;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (target == null) {
            return invoke1();
        }
        return invoke2(method, args);

    }

    private Object invoke1() {
        before();
        after();
        return "执行完成";
    }

    private Object invoke2(Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        before();
        // 调用 target 的 method 方法
        Object returnValue = method.invoke(target, args);
        after();
        return returnValue;
    }

    private void before() {
        System.out.println("向观众问好");
    }

    private void after() {
        System.out.println("演唱结束。。。。");
    }
}
