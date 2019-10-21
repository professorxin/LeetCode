package algorithm._128_Longest_Consecutive_Sequence;

import java.util.HashMap;

public class Solution {


    /*给定一个未排序的整数数组，找出最长连续序列的长度。时间复杂度要求O(n)*/


    //利用hashmap，key表示数组的数字，value表示该数字所在的连续序列的长度
    public int longestConsecutive(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                //左边一个数字的连续序列长度
                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                //右边一个数字的连续序列长度
                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
                //该数字的连续序列长度
                int sum = left + right + 1;
                map.put(num, sum);

                //更新最大值
                result = Math.max(result, sum);

                //左边界的连续序列长度
                map.put(num - left, sum);
                //右边界的连续序列长度
                map.put(num + right, sum);
            } else {
                continue;
            }
        }
        return result;
    }
}
