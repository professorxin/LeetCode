package algorithm._413_Arithmetic_Slices;

public class Solution {

    /*如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
    函数要返回数组 A 中所有为等差数组的子数组个数。*/


    //dp[i] 表示以 A[i] 为结尾的等差递增子区间的个数。
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        //因为递增子区间不一定以最后一个元素为结尾，可以是任意一个元素结尾，因此需要返回 dp 数组累加的结果。
        int result = 0;
        for (int d : dp) {
            result += d;
        }
        return result;
    }
}
