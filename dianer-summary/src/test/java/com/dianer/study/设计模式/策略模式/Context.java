package 学习模块.设计模式.策略模式;

/**
 * 策略模式
 **/
public class Context  {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        context.executeStrategy(3, 4);
    }
}
