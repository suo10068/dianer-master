package com.dianer.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-06-22 11:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class XmlTest {

    /**
     * Xml模版配置
     *
     * @throws Exception
     */
    @Test
    public void freemarkerTest() throws Exception {

        Configuration conf = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        conf.setDirectoryForTemplateLoading(new File("F:\\IdeaProjects\\dianer-master\\dianer-summary\\src\\test\\resources\\templates"));

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


        StringWriter out = new StringWriter();
        // 创建模版对象
        Template t = conf.getTemplate("test-01.ftl");
        // 在模版上执行插值操作，并输出到制定的输出流中
        t.process(map, out);

        System.out.println(out.toString());


    }

    /**
     * XML 数据 解析
     */
    @Test
    public void xmlParser() {
        String FILE_NAME = "XmlTest.xml";
        
    }


}
