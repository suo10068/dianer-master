package 学习模块.多线程;

/**
 * @program: dianer-study
 * @description:
 * @author: dianer
 * @create: 2020-04-25 18:43
 **/
public class _Synchronized {

    public void test(int a) throws Exception {
        synchronized (this) {
            System.out.println("======");
            if (a == 2) {
                throw new Exception("");
            }
        }
    }

    public synchronized void test2() {
        System.out.println("======");
    }
}

