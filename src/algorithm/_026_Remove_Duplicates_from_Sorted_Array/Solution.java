package algorithm._026_Remove_Duplicates_from_Sorted_Array;

public class Solution {

    /*给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。*/

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            //出现重复的数字，count次数加1
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        //总次数减去出现重复的次数
        return nums.length - count;
    }
}
