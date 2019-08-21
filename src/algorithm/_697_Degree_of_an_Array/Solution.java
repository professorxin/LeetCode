package algorithm._697_Degree_of_an_Array;

import java.util.HashMap;

public class Solution {

    /*给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
    你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。*/


    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //定义一个hashmap，key为数字，value为数组{该数的频数，该数第一次出现的地方，该数最后一次出现的地方}
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                //更新频数和最后出现的地方
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }

        int degree = Integer.MIN_VALUE, res = Integer.MAX_VALUE;

        for (int[] value : map.values()) {
            if (value[0] > degree) {
                degree = value[0];
                res = value[2] - value[1] + 1;
            } else if (value[0] == degree) { //频数相等
                res = Math.min(value[2] - value[1] + 1, res);
            }
        }
        return res;
    }
}
