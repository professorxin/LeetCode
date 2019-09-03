package algorithm._300_Longest_Increasing_Subsequence;

public class Solution {

    /*求数组的最长递增子序列，子序列可以不连续的*/

    //使用动态规划求解，dp[n]表示以n结尾的最长递增子序列，时间复杂度O（n2）
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            //初始长度
            int max = 1;
            //循环后可以确定以nums[i]结尾的最长递增子序列
            for (int j = 0; j < i; j++) {
                //如果nums[j]<nums[i],说明以nums[i]结尾的递增子序列可以由nums[j]结尾的递增子序列推导出来
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        //整个序列中最长的需要通过遍历dp数组才能得出
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }


}
