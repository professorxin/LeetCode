package algorithm._581_Shortest_Unsorted_Continuous_Subarray;

public class Solution {

    /*给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，
    那么整个数组都会变为升序排序。*/


    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //从左到右找出不符合升序的数字，更新end的值为该数字下标
        int end = -2;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            max = Math.max(nums[i],max);
            if(nums[i] < max){
                end = i;
            }
        }
        //从右到左找出不符合降序的数字，更新begin的值为该数字下标
        int begin = -1;
        int min = Integer.MAX_VALUE;
        for(int i = nums.length - 1;i >= 0;i--){
            min = Math.min(nums[i],min);
            if(nums[i] > min){
                begin = i;
            }
        }
        //返回距离的长度
        return end - begin + 1;
    }
}
