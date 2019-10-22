package algorithm._518_Coin_Change_2;

public class Solution {

    /*给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。
    假设每一种面额的硬币有无限个。*/


    //完全背包问题
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {//完全背包，硬币可重复，采用正序
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }

}
