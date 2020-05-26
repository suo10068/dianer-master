package com.dianer.spring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-26 01:48
 **/
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("-----MyApplicationContextInitializer initialize-----");
    }
}
