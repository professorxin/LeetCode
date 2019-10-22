package algorithm._462_Minimum_Moves_to_Equal_Array_Elements_II;

import java.util.Arrays;

public class Solution {

    /*给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素
    加1或减1。您可以假设数组的长度最多为10000。*/

    //a,b表示中间值两边的两个数，向中间移动的次数等于b-a
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        int move = 0;
        while (start <= end) {
            move += nums[end] - nums[start];
            start++;
            end--;
        }
        return move;
    }
}
