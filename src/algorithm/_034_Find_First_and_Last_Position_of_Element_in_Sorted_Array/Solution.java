package algorithm._034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

public class Solution {

    /*给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    你的算法时间复杂度必须是 O(log n) 级别。
    如果数组中不存在目标值，返回 [-1, -1]。*/

    public int[] searchRange(int[] nums, int target) {
        int start = firstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }//找到target+1的数的位置的下标再减1就是结束值
        int end = firstGreaterEqual(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    //二分查找，稍微有变形
    private int firstGreaterEqual(int[] nums, int target) {
        //注意这里的high为nums.length
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                //nums[mid]==target时更新high值，为了继续找出等于target的开始位置
                high = mid;
            }
        }
        return low;
    }
}
