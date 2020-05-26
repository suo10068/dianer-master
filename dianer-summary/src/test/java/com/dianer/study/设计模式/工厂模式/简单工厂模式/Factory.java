package 学习模块.设计模式.工厂模式.简单工厂模式;

/**
 * @program: root
 * @description:
 * @author: dianer
 * @create: 2020-04-03 14:55
 **/
public class Factory {

    public static void main(String[] args) {
        AbstractProduct product = Factory.create("A");
        product.method();
    }

    public static AbstractProduct create(String type) {
        AbstractProduct product = null;

        switch (type) {
            case "A":
                product = new ProductA();
                break;
            case "B":
                product = new ProductB();
                break;
            default:
                product = null;
        }
        return product;
    }

}
