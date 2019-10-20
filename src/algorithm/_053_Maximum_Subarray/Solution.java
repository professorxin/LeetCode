package algorithm._053_Maximum_Subarray;


public class Solution {

    /*给定一个整型数组，求连续子数组的最大和*/


    //没有借助额外空间复杂度
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                //如果sum小于等于0，重新开始设值
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }


    //借助o(n)的额外空间复杂度
    public int maxSubArray1(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
