package com.dianer.学习模块.数据结构;

/**
 * 1 - 100000 中所有的对称数字，例如 11、121、1221
 */
public class 题目_2 {

    private static final int NUM = 1000;

    public static void main(String[] args) {
        for (int i = 100; i < NUM; i++) {
            if (validate(i))
                System.out.println(i);
        }
    }

    private static boolean validate(int k) {
        String s = String.valueOf(k);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
