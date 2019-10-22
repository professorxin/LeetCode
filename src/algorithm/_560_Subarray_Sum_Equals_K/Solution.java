package algorithm._560_Subarray_Sum_Equals_K;

import java.util.HashMap;

public class Solution {

    /*要求连续子数组的和为k，求子数组的个数*/



    /*采用的方式是用hashmap保存的key是前面数字相加的和，value是该和出现的次数。将该问题转化为前面数字的和减去k后
    的数字和的个数*/
    public int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //当和为0时，次数为1
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //如果sum-k这个key存在，该和出现的次数就表示子数组和为k的个数
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            //将前面数字的和作为key放入，map有已经有这个key的话value就加1
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
