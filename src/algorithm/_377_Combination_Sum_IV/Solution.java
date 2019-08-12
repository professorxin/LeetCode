package algorithm._377_Combination_Sum_IV;

import java.util.Arrays;

public class Solution {

    /*数组中的数字构成目标数的组合数，数字可重复*/

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //数组中的每一个数表示该数字的组合数
        int[] dp = new int[target + 1];
        //初始化状态
        dp[0] = 1;
        //对数组进行排序
        Arrays.sort(nums);
        //计算目标数字的组合数
        for (int i = 1; i <= target; i++) {
            //当目标数字分别减去数组中的数字的组合数相加
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                //状态转移方程
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
