package 学习模块.多线程;

/**
 * @program: root
 * @description:
 * @author: dianer
 * @create: 2020-04-03 13:52
 **/
public class _ThreadLocal {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(0);
                Integer i = 0;
                while (i < 10) {
                    i = threadLocal.get();
                    threadLocal.set(i + 1);
                    System.out.println("AAA " + i);
                }

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(0);
                Integer i = 0;
                while (i < 10) {
                    i = threadLocal.get();
                    threadLocal.set(i + 1);
                    System.out.println("BBB " + i);
                }

            }
        });
        t.start();
        t2.start();
    }

}
