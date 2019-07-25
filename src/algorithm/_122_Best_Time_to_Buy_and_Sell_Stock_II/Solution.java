package algorithm._122_Best_Time_to_Buy_and_Sell_Stock_II;

public class Solution {

    /*给定一个数组，要求先买入后卖出，可进行多次购买，求最大利润*/

    public int maxProfit(int[] prices) {
        int total = 0;
        //后一个比前一个大的话直接累加
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }
}
