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

    static final String XML_FILE = "F:\\IdeaProjects\\dianer-master\\dianer-summary\\src\\test\\resources";


    public static void main(String args[]) throws Exception {
        SAXReader reader = new SAXReader();
//        Document document = DocumentHelper.parseText(XML_MSG);
        Document document = reader.read(new File(XML_FILE + "\\XML-002.xml"));
        // 获取文档根节点
        Element root = document.getRootElement();

        Map<String, Object> map = new HashMap<>();
        parseXML(root, map);
        System.out.println(JSON.toJSONString(map));

    }


    static void parseXML(Element el, Map<String, Object> map) {

        // 该标签 只含有text，无子标签
        if (el.isTextOnly()) {
            map.put(el.getName(), el.getTextTrim());
            return;
        }

        // 同一层次，重复标签，判定为 List列表
        Object obj = map.get(el.getName());
        if (obj != null) {

            List<Map<String, Object>> list = null;

            if (obj instanceof List) {
                list = (List<Map<String, Object>>) obj;
            }
            if (obj instanceof Map) {
                list = new ArrayList<>();
                list.add((Map<String, Object>) obj);
                map.put(el.getName(), list);
            }

            if (list != null){
                Map<String, Object> tmp = new HashMap<>();
                list.add(tmp);

                Iterator<Element> it = el.elementIterator();
                while (it.hasNext()) {
                    Element next = it.next();
                    parseXML(next, tmp);
                }
                return;
            }
        }

        // 新标签
        Map<String, Object> node = new HashMap<>();
        Iterator<Attribute> aIt = el.attributeIterator();
        while (aIt.hasNext()) {
            Attribute attribute = aIt.next();
            node.put(attribute.getName(), attribute.getText());
        }
        map.put(el.getName(), node);

        Iterator<Element> it = el.elementIterator();
        while (it.hasNext()) {
            Element element = it.next();
            parseXML(element, node);
        }
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
