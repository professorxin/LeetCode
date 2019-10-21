package algorithm._279_Perfect_Squares;

import java.util.Arrays;

public class Solution {

    /*给定一个正整数，找到最少能构成该正整数的完全平方数的个数*/

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //初始状态
        dp[0] = 0;
        //每一次循环确定i这个正整数的最少完全平方数个数
        for (int i = 1; i <= n; i++) {
            //尝试不同的完全平方数，找出最小值
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
