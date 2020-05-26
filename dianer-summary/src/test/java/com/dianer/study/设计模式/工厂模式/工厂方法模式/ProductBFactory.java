package 学习模块.设计模式.工厂模式.工厂方法模式;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-11 22:44
 **/
public class ProductBFactory implements Factory {
    @Override
    public Product create() {
        return new ProductB();
    }
}
