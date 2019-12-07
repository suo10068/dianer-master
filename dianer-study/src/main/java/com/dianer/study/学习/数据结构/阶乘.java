package com.dianer.study.学习.数据结构;

public class 阶乘 {

    /**
     * 计算 1！ + 2！ + 3！+ ... + n!
     */
    public static void main(String[] args) {
        int n = 4;
        System.out.println("1 ==" + fact1(n));
        System.out.println("2 ==" + fact2(n));
    }

    /** 时间复杂度
     * 大O表示法，O(n²) 表示 T(n) 的近似值
     * 记作 T(n) = O(n²)
     */
    static int fact1(int n) {
        int sum = 0, temp;
        for (int i = 1; i <= n; i++) {
            temp = 1;
            for (int j = 1; j <= i; j++) {
                temp = temp * j;
            }
            sum += temp;
        }
        return sum;
    }

    /**
     * T(n) = O(n)
     */
    static int fact2(int n) {
        int sum = 0, temp = 1;
        for (int i = 1; i <= n; i++) {
            temp = temp * i;
            sum = sum + temp;
        }
        return sum;
    }


}
