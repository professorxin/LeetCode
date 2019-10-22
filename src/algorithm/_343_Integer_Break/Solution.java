package algorithm._343_Integer_Break;

public class Solution {

    //分割整数为至少两个正数，算出分割后的数的最大乘积

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                //从这三种情况中取最大值
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, j * (i - j)));
            }
        }
        return dp[n];
    }
}
