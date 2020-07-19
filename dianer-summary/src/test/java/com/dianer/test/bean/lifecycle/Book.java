package com.dianer.test.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-29 22:29
 **/
public class Book implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String bookName;

    public Book() {
        System.out.println("1 : Book Initializing ");
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        System.out.println("2 : setBookName: Book name has set. bookname : " + bookName);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("3 : Book.setBeanName invoke。BeanName = " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("4 : Book.setBeanFactory invoke " + beanFactory.getBean("book").equals(this));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("5 : Book.setApplicationContext invoke");
    }

    // 自定义初始化方法
    @PostConstruct
    public void springPostConstruct() {
        System.out.println("7 : @PostConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("8 : Book.afterPropertiesSet invoke");
    }

    // 通过init-method 属性配置的初始化方法
    public void myPostConstruct() {
        System.out.println("9 : Book.myPostConstruct invoke");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println(": Book.destory invoke");
    }



    public String getBookName() {
        return bookName;
    }




    public void myPreDestory() {
        System.out.println("Book.myPreDestory invoke");
        System.out.println("---------------destroy-----------------");
    }

    // 自定义销毁方法
    @PreDestroy
    public void springPreDestory() {
        System.out.println("@PreDestory");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("------inside finalize-----");
    }
}