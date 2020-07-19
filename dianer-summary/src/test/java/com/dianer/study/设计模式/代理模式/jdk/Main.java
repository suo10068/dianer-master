package com.dianer.study.设计模式.代理模式.jdk;

public class Main {

    public static void main(String[] args) throws Exception {

        ISinger target = new Singer("种豆得豆");

        ISinger proxy = SingerProxy.getProxy(target);

        proxy.sing2();


        SingerProxy.getProxy().sing();



    }

}

