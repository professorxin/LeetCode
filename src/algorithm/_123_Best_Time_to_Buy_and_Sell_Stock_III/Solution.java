package algorithm._123_Best_Time_to_Buy_and_Sell_Stock_III;

public class Solution {

    /*给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
    注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。*/


    /*采用状态机的思路，由于只能完成两笔交易，定义四个状态，分别是buy1,sell1,buy2,sell2*/
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            //买入价格更低的股
            buy1 = Math.max(buy1, -prices[i]);
            //卖出当前股或者不操作
            sell1 = Math.max(sell1, buy1 + prices[i]);
            //第二次买入，或者不操作
            buy2 = Math.max(buy2, sell1 - prices[i]);
            //第二次卖出，或者不操作
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
