package algorithm._239_Sliding_Window_Maximum;

import java.util.PriorityQueue;

public class Solution {


    /*给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
    你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。*/

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || k < 1) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        //大顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        result[0] = heap.peek();
        //滑动窗口，记录大顶堆的堆顶值
        for (int i = 0, j = k; j < nums.length; i++, j++) {
            heap.remove(nums[i]);
            heap.add(nums[j]);
            result[i + 1] = heap.peek();
        }
        return result;
    }
}
