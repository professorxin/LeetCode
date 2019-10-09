package algorithm._503_Next_Greater_Element_II;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    /*给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的
    下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个
    比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。*/


    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        //栈保存之前的元素
        Stack<Integer> stack = new Stack<>();
        //2*n表示要遍历两遍
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            //栈不为空而且栈顶索引指向的元素比当前元素小，更新next数组的对应索引元素为当前元素
            while (!stack.empty() && nums[stack.peek()] < num) {
                next[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return next;
    }
}
