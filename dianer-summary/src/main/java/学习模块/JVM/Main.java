package 学习模块.JVM;

public class Main {

//    private static int[] o = new int[1024 * 1024];

    public static void main(String[] args) throws Exception {

        while (true) {
            int[] objects = new int[1024 * 1024 / 10]; // 4 * 1M / 10 = 400KB
            Thread.sleep(100);
        }
    }
}
