package com.dianer.test.bean.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-29 22:06
 **/
public class SpringMain {


    public static void main(String[] args) {

        // 为面试而准备的Bean生命周期加载过程
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
        Book book = (Book) context.getBean("book");
        System.out.println("Book name = " + book.getBookName());
        context.registerShutdownHook();

    }

}
