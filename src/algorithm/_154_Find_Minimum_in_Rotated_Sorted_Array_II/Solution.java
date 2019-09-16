package algorithm._154_Find_Minimum_in_Rotated_Sorted_Array_II;

public class Solution {

    /*假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    请找出其中最小的元素。
    注意数组中可能存在重复的元素。*/


    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                //nums[mid]==nums[end],存在重复的元素，只需让end指针左移缩小范围
                end--;
            }
        }
        return nums[start];
    }
}
