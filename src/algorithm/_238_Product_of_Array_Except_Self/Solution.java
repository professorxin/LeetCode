package algorithm._238_Product_of_Array_Except_Self;

public class Solution {

    /*给定一个整数数组，输出除去该位置元素的其他元素的乘积的数组,时间复杂度要求O(n)*/
    /*
    Numbers:     2    3    4     5
    Lefts:       1    2  2*3 2*3*4
    Rights:  3*4*5  4*5    5     1
    */

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        //确定左边方向的成绩
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                left = left * nums[i - 1];
            }
            result[i] = left;
        }
        //确定右边方向的成绩
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                right = right * nums[i + 1];
            }
            //左边方向乘以右边方向
            result[i] *= right;
        }
        return result;
    }
}
