package 学习模块.数据结构;

/**
 * 题目描述
 * <p>
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * <p>
 * 示例 1:
 * <p>
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * <p>
 * 示例 2:
 * <p>
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 * <p>
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 */

public class 题目_1 {

    public static void main(String[] args) {
        int[] A = {1, 2, 2};
        System.out.println(minIncrementForUnique(A));
    }

    public static int minIncrementForUnique(int[] A) {
        int rst = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] == A[j]) {
                    A[i] = A[i] + 1;
                    rst++;
                }
            }
        }
        return rst;
    }
}
