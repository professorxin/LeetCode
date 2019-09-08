package algorithm._016_3Sum_Closest;

import java.util.Arrays;

public class Solution {


    /*找到最接近目标值的三个数的总和，返回该目标值*/

    public int threeSumClosest(int[] nums, int target) {
        //第一种三个数的总和
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        //排序
        Arrays.sort(nums);
        //固定一个数
        for (int i = 0; i < nums.length; i++) {
            //定义首尾指针
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                //移动首指针或尾指针
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                //每一次都比较是否最接近目标值，并做更新
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
