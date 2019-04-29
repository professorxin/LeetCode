package algorithm._121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {

    /*给定一个数组，只能先买入后卖出，卖出价格要高于买入价格，求最大利润*/
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        //最大利润
        int max = 0;
        //最小的价格
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}
