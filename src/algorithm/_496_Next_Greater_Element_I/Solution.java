package algorithm._496_Next_Greater_Element_I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    /*给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
    找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
    nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
    如果不存在，对应位置输出-1。*/



    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //用于保存每个元素的下一个比其大的值
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            //栈不为空而且找到比栈顶元素大的值
            while (!stack.empty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
