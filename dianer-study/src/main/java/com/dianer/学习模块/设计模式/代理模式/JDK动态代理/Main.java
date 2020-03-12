package com.dianer.学习模块.设计模式.代理模式.JDK动态代理;

import com.dianer.annotation.CacheLock;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.*;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        ISinger target = new Singer("种豆得豆");

        ISinger proxy = (ISinger) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHandler(target));

        proxy.sing2();
    }

    // 修改注解参数值
    static void aaa() throws Exception {
        RestController annotation = ISinger.class.getAnnotation(RestController.class);
        if (annotation == null) {
            throw new RuntimeException("注解为空！");
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
        Field value = invocationHandler.getClass().getDeclaredField("memberValues");
        value.setAccessible(true);
        Map<String, Object> memberValues = (Map<String, Object>) value.get(invocationHandler);
        System.out.println("改变前：" + (String) memberValues.get("value"));
        memberValues.put("value", "b");
        System.out.println("改变后：" + annotation.value());
    }

}

class MyInvocationHandler implements InvocationHandler {

    private ISinger target;

    public MyInvocationHandler(ISinger target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
