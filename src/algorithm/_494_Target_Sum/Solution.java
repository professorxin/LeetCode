package algorithm._494_Target_Sum;

public class Solution {



    //采用深度优先搜索算法
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    public int findTargetSumWays(int[] nums, int start, int S) {
        //递归终止条件，整个数组结束后，目标S能否为0
        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }
        //第一个函数表示第一位数用负数，第二个函数表示第一位数用正数。递归下去，直到用最后一个数，所有情况都列举了。
        return findTargetSumWays(nums, start + 1, S + nums[start]) +
                findTargetSumWays(nums, start + 1, S - nums[start]);
    }




    //采用动态规划
    public int findTargetSumWays1(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int W = (sum + S) / 2;
        int[] dp = new int[W + 1];
        dp[0] = 1;
        //整个遍历先把dp数组的元素从左到右慢慢填充，直到最后的dp数组的最后一个元素表示和为W的子集数量
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String args[]){
        new Solution().findTargetSumWays1(new int[]{2,5,4}, 3);
    }
}
