package algorithm._213_House_Robber2;

public class Solution {

    //由于房子是环形的，所以分两种情况考虑，一种是要偷第一间，一种是不偷第一间，然后取这两种情况的最大值，
    //这样的话这两种情况都能转化成在一条街上偷这些房子的最大值
    public int rob(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0)
            return 0;
        if (length == 1)
            return nums[0];
        //抢劫第一间（也可能不抢）+不抢劫第一间
        return Math.max(rob(nums, 0, length - 2), rob(nums, 1, length - 1));
    }

    public int rob(int[] nums, int index, int end) {
        int pre1 = 0, pre2 = 0;
        for (int i = index; i <= end; i++) {
            int cur = Math.max(nums[i] + pre2, pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
