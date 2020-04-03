package 学习模块.设计模式.单例模式;

class SingletonMain {

    public static void main(String[] args) {
        /**
         * 静态内部类
         */
        Singleton_2 singleton_2 = Singleton_2.getInstance();


        /**
         * 枚举
         */
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);


    }
}
