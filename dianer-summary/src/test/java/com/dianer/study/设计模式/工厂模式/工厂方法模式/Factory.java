package 学习模块.设计模式.工厂模式.工厂方法模式;

import 学习模块.设计模式.工厂模式.简单工厂模式.AbstractProduct;
import 学习模块.设计模式.工厂模式.简单工厂模式.ProductA;
import 学习模块.设计模式.工厂模式.简单工厂模式.ProductB;

/**
 * @program: root
 * @description:
 * @author: dianer
 * @create: 2020-04-03 14:55
 **/
public interface Factory {

    Product create();

}
