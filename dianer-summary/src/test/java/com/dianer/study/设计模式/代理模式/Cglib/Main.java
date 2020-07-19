package com.dianer.study.设计模式.代理模式.cglib;

public class Main {


    public static void main(String[] args) {
        // 生成 Cglib 代理类
        Engineer engineerProxy = (Engineer) EngineerProxy.getProxy(new Engineer());
        // 调用相关方法
        engineerProxy.eat();
    }

}
