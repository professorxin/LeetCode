package algorithm._152_Maximum_Product_Subarray;

public class Solution {


    /*给定一个整型数组，找出数组内连续子数组乘积的最大值*/

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0], min = nums[0], result = nums[0];
        //每一次都找出最大值和最小值，然后最大值和最小值分别乘以下一个数。因为负数乘负数为正数，所以要保存最小值
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

}
