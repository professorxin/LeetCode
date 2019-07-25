package algorithm._153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution {

    /*找到旋转数组的最小值*/

    //利用二分查找
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            //最小值在右区间
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                //最小值在左区间，包含mid，所以直接赋值为mid的位置
                end = mid;
            }
        }
        return nums[start];
    }


    //利用二分查找
    public int findMin1(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            //如果start的数组值小于end的数组值，那么证明是升序的，直接返回start的数组值
            if (nums[start] < nums[end]) {
                return nums[start];
            }
            //取中间数
            int mid = (start + end) / 2;
            //如果mid的数组值大于等于start的数组值，说明最小值在下一个区间，更新start。注意等号
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                //反之最小值在这个区间，更新end
                end = mid;
            }
        }
        return nums[start];
    }
}
