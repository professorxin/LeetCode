package algorithm._041_First_Missing_Positive;

public class Solution {

    /*给定一个未排序的整数数组，找出其中没有出现的最小的正整数。*/

    //时间复杂度要求o(n)
    //算法的思想就是让数组里面存放着1-n的正数，第0个位置放1，第1个位置放2，以此类推
    // 最后遍历数组如果没有存放匹配的正数，返回最小正数的值为该位置+1
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //如果满足下述匹配规则，就一直交换
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }

        }
        //遍历数组找出不匹配的
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //表示数组完全匹配规则，最小正数为数组长度+1
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
