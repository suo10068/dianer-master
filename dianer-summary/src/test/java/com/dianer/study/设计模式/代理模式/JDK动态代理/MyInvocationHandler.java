package 学习模块.设计模式.代理模式.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @program: root
 * @description:
 * @author: dianer
 * @create: 2020-04-03 14:43
 **/
public class MyInvocationHandler implements InvocationHandler {

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
