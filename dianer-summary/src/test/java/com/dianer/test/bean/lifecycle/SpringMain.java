package com.dianer.test.bean.lifecycle;

import com.dianer.util.FreemarkerUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-29 22:06
 **/
public class SpringMain {


    public static void main(String[] args) throws Exception {

        // 为面试而准备的Bean生命周期加载过程
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-lifecycle.xml");
//        Book book = (Book) context.getBean("book");
//        System.out.println("Book name = " + book.getBookName());
//        context.registerShutdownHook();

        Map<String, Object> map = new HashMap<>();
        map.put("TrsCode", "AAAAAA");
        map.put("num", "007");

        List<Map<String, Object>> list = new ArrayList<>();
        map.put("BList", list);

        Map<String, Object> m1 = new HashMap<>();
        m1.put("ReturnCode", "m1");
        Map<String, Object> m2 = new HashMap<>();
        m2.put("ReturnCode", "m2");
        Map<String, Object> m3 = new HashMap<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);

        FreemarkerUtil freemarkerUtil = (FreemarkerUtil) context.getBean("freemarkerUtil");
        String process = freemarkerUtil.process(map, "test-01");
        System.out.println(process);


    }

}
