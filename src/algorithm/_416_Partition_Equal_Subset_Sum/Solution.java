package algorithm._416_Partition_Equal_Subset_Sum;

public class Solution {

    /*划分数组为和相等的两部分*/
    //我的理解是构造一个dp数组，数组的元素表示能否有元素的总和为下标。
    public boolean canPartition(int[] nums) {
        int sum = computeSum(nums);
        if (sum % 2 == 1) {
            return false;
        }
        int W = sum / 2;
        boolean[] dp = new boolean[W + 1];
        dp[0] = true;
        //第一次循环就能得出dp[数组第一个元素]为true了，第二次又可以得出dp[数组第一个元素+第二个元素]为true了,以此类推
        //这样就能构建出所有能让总和为W的情况
        for (int num : nums) {
            for (int i = W; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[W];
    }

    public int computeSum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }


    public static void main(String[] args) {
        boolean[] flag = new boolean[5];
        System.out.println(flag[1]);
    }
}
