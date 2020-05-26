package 学习模块.数据结构;

/**
 * 求销售利润最大额
 * 只能买入、卖出一次，[9,1,4,5,8,2,7] --> 代表第i天市场价格
 */
public class 题目_3 {

    private static final int[] P = {9, 1, 4, 5, 8, 2, 7};

    public static void main(String[] args) {
        int rst = 0;
        for (int i = 0; i < P.length - 1; i++) {
            for (int j = i + 1; j < P.length; j++) {
                int temp = P[j] - P[i];
                if (temp > rst) {
                    rst = temp;
                }
            }
        }
        System.out.println("最大利润为：" + rst);
    }
}
