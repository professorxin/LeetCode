package algorithm._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    //todo
    /*给定一个整型数组，返回频率最大的前k个元素*/

    public List<Integer> topKFrequent(int[] nums, int k) {
        //用于存放返回的k个最大频率的数
        List<Integer> result = new ArrayList<Integer>();
        //一个链表类型的数组，这个桶数组的下标表示存放元素频率，同一个频率可能有多个数组，所以要用链表。
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        //用于记录每个数出现的频率，记录后用于后面放入桶数组中
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //统计频率
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //放入桶中
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        //从后往前遍历取出前k个
        for (int p = bucket.length - 1; p >= 0 && result.size() < k; p--) {
            if (bucket[p] == null)
                continue;
            //要做个判断，确保取出的元素为k个
            if (bucket[p].size() <= k - result.size()) {
                result.addAll(bucket[p]);
            } else {
                result.addAll(bucket[p].subList(0, k - result.size()));
            }

        }
        return result;
    }
}
