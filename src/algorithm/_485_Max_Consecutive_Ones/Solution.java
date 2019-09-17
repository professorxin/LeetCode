package algorithm._485_Max_Consecutive_Ones;

public class Solution {

    /*给定一个二进制数组， 计算其中最大连续1的个数。*/

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int num : nums) {
            cur = num == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
