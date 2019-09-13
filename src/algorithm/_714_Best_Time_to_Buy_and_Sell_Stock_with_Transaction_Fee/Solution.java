package algorithm._714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class Solution {

    /*给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易
    股票的手续费用。
    你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你
    就不能再继续购买股票了。
    返回获得利润的最大值。*/


    //状态机图片可查看images
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[] s1 = new int[length];
        int[] s2 = new int[length];
        int[] buy = new int[length];
        int[] sell = new int[length];
        s2[0] = sell[0] = 0;
        s1[0] = buy[0] = -prices[0];
        for (int i = 1; i < length; i++) {
            buy[i] = Math.max(s2[i - 1], sell[i - 1]) - prices[i];
            s1[i] = Math.max(s1[i - 1], buy[i - 1]);
            //增加交易股票的手续费用
            sell[i] = Math.max(s1[i - 1], buy[i - 1]) + prices[i] - fee;
            s2[i] = Math.max(s2[i - 1], sell[i - 1]);
        }
        return Math.max(s2[length - 1], sell[length - 1]);
    }
}
