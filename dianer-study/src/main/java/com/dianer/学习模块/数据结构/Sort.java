package com.dianer.学习模块.数据结构;

public class Sort {

    static int[] a = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    static int[] b = new int[]{1, 3, 2, 4, 5};

    public static void main(String[] args) {
//        sort1(b);
//        sort3(a);
        quickSort(a);
    }


    /**
     * 冒泡排序
     * 时间复杂度 O(n²)
     */
    static void sort1(int[] a) {
        int l = a.length;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            print(a);
        }
    }

    /**
     * 插入排序 1
     * 时间复杂度 O(n²)
     */
    static void sort2(int[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            for (j = i; j > 0; j--) {
                if (tmp >= a[j - 1]) {
                    break;
                }
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
        print(a);
    }

    /**
     * 插入排序 2 (优化 1)
     */
    static void sort3(int[] k) {

        int j;
        for (int p = 1; p < k.length; p++) {
            int tmp = k[p];
            for (j = p; j > 0 && tmp < k[j - 1]; j--) {
                k[j] = k[j - 1];
            }
            k[j] = tmp;
        }
        print(k);
    }

    /**
     * 快速排序
     *
     * @param array
     */
    public static void quickSort(int[] array) {
        int len;
        if (array == null || (len = array.length) == 0 || len == 1) {
            return;
        }
        sort(array, 0, len - 1);
        print(array);
    }

    /**
     * 快排核心算法，递归实现
     *
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    static void print(int[] a) {
        for (int k = 0; k < a.length; k++) {
            System.out.print(a[k] + ", ");
        }
        System.out.println();
    }

}
