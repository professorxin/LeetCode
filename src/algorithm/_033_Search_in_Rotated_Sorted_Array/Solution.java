package algorithm._033_Search_in_Rotated_Sorted_Array;

public class Solution {

    /*在旋转数组中找到target，返回它的下标，没有找到就返回-1。
    时间复杂度要求O(log n)，也就是要用二分查找*/

    public int search(int[] nums, int target) {
        if(nums == null || nums.length <= 0){
            return -1;
        }
        int minIdx = findMinIdx(nums);
        //if (target == nums[minIdx]) return minIdx;
        int length = nums.length;
        //确定target所在的位置，更新start和end的值
        int start = (target <= nums[length - 1]) ? minIdx : 0;
        int end = (target > nums[length - 1]) ? minIdx : length - 1;

        //二分查找，注意等号
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //找到旋转数组的最小值，也是leetcode第153的题目
    private int findMinIdx(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
