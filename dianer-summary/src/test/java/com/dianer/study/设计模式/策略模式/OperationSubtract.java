package 学习模块.设计模式.策略模式;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-05-20 20:29
 **/
public class OperationSubtract extends Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
