package algorithm._198_House_Robber;

public class Solution {

    /*题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
    定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
    由于不能抢劫邻近住户，如果抢劫了第 i -1 个住户，那么就不能再抢劫第 i 个住户*/


    //pre2表示当前房子数减2的最大值，pre1表示当前房子数减1的最大值，cur表示现在房子数的最大值
    public int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(nums[i] + pre2, pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }


    //采用数组来进行dp
    public int rob1(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
        }
        return memo[nums.length];
    }
}
