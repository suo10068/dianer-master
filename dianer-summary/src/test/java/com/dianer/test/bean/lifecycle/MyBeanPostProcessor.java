package com.dianer.test.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-29 22:32
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 容器加载的时候会加载一些其他的bean，会调用初始化前和初始化后方法
    // 这次只关注book(bean)的生命周期
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Book) {
            System.out.println("=== MyBeanPostProcessor.postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Book) {
            System.out.println("=== MyBeanPostProcessor.postProcessAfterInitialization");
        }
        return bean;
    }
}