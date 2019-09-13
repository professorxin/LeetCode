package algorithm._309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown;

public class Solution {

    /*给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
    设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
    你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。*/


    //状态机图片可查看images
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[] s1 = new int[length];
        int[] s2 = new int[length];
        int[] sell = new int[length];
        int[] buy = new int[length];
        buy[0] = s1[0] = -prices[0];
        sell[0] = s2[0] = 0;
        for (int i = 1; i < length; i++) {
            buy[i] = s2[i - 1] - prices[i];
            s1[i] = Math.max(buy[i - 1], s1[i - 1]);
            sell[i] = Math.max(buy[i - 1], s1[i - 1]) + prices[i];
            s2[i] = Math.max(sell[i - 1], s2[i - 1]);
        }
        //肯定是股票已经卖出去的利润高
        return Math.max(s2[length - 1], sell[length - 1]);
    }
}
