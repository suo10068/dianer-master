package com.dianer.test;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.*;

/**
 * @Program: dianer-study
 * @Description:
 * @Author: SLY
 * @Date: 2020-07-22 13:48
 **/
public class XmlUtil {

    /**
     * 默认编码
     */
    private static final String DEFAULT_ENCODING = "UTF-8";

    private Document document;

    public XmlUtil(String msg) {
        try {
            this.document = DocumentHelper.parseText(msg);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public XmlUtil(File file) {
        SAXReader reader = new SAXReader();
        try {
            this.document = reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public Map<String, Object> parse() {
        // 获取文档根节点
        Element root = document.getRootElement();
        Map<String, Object> map = new HashMap<>();
        // 去除 根节点
        Iterator<Element> it = root.elementIterator();

        while (it.hasNext()) {
            Element element = it.next();
            parseXML(element, map);
        }

        return map;
    }

    private void parseXML(Element el, Map<String, Object> map) {

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

            if (list != null) {
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


}
