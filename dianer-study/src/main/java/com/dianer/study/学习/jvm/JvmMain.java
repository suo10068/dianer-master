package com.dianer.study.学习.jvm;

public class JvmMain {

    private static final int _1MB = 512 * 1024;
//    private static final String STRING  = Arrays.toString((new char[1024]));

    public static void main(String[] args) {
        System.out.println("==============");
        int i = 0;

        while (true) {
            System.out.println("[" + (i++) + "]");
            String[] strings = new String[1 * _1MB];
//            String[] strings2 = new String[1 * _1MB];
//            break;
        }
//        System.out.println("======= END =======");
    }

}
