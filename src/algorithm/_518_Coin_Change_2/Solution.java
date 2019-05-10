package algorithm._518_Coin_Change_2;

public class Solution {

    /*给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 */
    public int change(int amount, int[] coins) {
        if (amount == 0 || coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
                //System.out.println("当前coin为："+coin+",数组第"+i+"位的值为："+dp[i]);
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        new Solution().change(5, new int[]{1, 2, 5});
    }
}
