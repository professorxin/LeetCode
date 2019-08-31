package algorithm._283_Move_Zeroes;

public class Solution {

    /*给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。*/

    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return ;
        }
        int index = 0;
        for(int num : nums){
            if(num != 0){
                nums[index++] = num;
            }
        }
        while(index < nums.length){
            nums[index++] = 0;
        }
    }
}
