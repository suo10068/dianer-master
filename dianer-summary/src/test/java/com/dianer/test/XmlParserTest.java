package com.dianer.test;

import com.alibaba.fastjson.JSON;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

/**
 * @Program: jnTra
 * @Description:
 * @Author: SLY
 * @Date: 2020-07-21 13:30
 **/
public class XmlParserTest {

    static final String XML_FILE = "F:\\IdeaProjects\\dianer-master\\dianer-summary\\src\\test\\resources\\";


    public static void main(String args[]) throws Exception {

        XmlUtil xmlUtil = new XmlUtil(new File(XML_FILE + "XML-002.xml"));
        Map<String, Object> parse = xmlUtil.parse();
        System.out.println(JSON.toJSONString(parse));

    }



    /**
     * OK
     *
     * @param el
     * @param map
     */
    static void xmlParse(Element el, Map<String, Object> map) {

        if (el.isTextOnly()) {
            System.out.println(el.getName() + "：" + el.getTextTrim());
            map.put(el.getName(), el.getTextTrim());
            return;
        }
        if (el.getName().contains("List")) {
            List<Map<String, Object>> list = new ArrayList<>();
            map.put("List", list);

            Iterator<Element> it = el.elementIterator();
            while (it.hasNext()) {
                Map<String, Object> tmp = new HashMap<>();
                list.add(tmp);
                Element next = it.next();
                xmlParse(next, tmp);
            }
            return;
        }

        Iterator<Element> it = el.elementIterator();
        while (it.hasNext()) {
            Element element = it.next();
            xmlParse(element, map);
        }

    }


}
