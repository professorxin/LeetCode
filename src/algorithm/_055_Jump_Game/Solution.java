package algorithm._055_Jump_Game;

public class Solution {

    /*给定一个数组，初始定位在第一个索引，数组中的每个元素值代表你能跳到的最大长度，
    判断是否能跳到最后一个位置*/

    public boolean canJump(int[] nums) {
        //能跳到的最大位置
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            //如果最大位置比i小，表示跳不到
            if (i > max) {
                return false;
            }
            //每一次都更新能跳到的最大位置
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

}
