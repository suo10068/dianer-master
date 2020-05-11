package 学习模块.设计模式.工厂模式.工厂方法模式;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-11 22:45
 **/
public class Main {

    public static void main(String[] args) throws Exception {
        Factory factoryA = (Factory)Class.forName("学习模块.设计模式.工厂模式.工厂方法模式.ProductAFactory").newInstance();
        factoryA.create().method();
    }
}
