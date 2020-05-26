package 学习模块.设计模式.单例模式;

/**
 * 枚举实现方式
 */
public class Singleton {

    private Singleton() {
    }

    enum Instance {
        INSTANCE;
        private Singleton singleton;

        Instance() {
            System.out.println("实例化。。。。。");
            singleton = new Singleton();
        }

        public Singleton getInstance() {
            return singleton;
        }
    }

    public static Singleton getInstance() {
        return Instance.INSTANCE.getInstance();
    }

}
