package algorithm._001_Two_Sum;


import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。*/
    public int[] twoSum(int[] nums, int target) {
        int[] num = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        //return new int[] {i,j};
                        num[0] = i;
                        num[1] = j;
                        return num;
                    }
                }
            }
        }
        return null;
    }


    /*用一个hashmap来存储数值和对应的下标*/
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        //数值对应下标
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().twoSum1(new int[]{1,3,5,8},8 ));
    }
}
