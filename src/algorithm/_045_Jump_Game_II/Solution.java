package algorithm._045_Jump_Game_II;

public class Solution {

    /*给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    你的目标是使用最少的跳跃次数到达数组的最后一个位置。
    */

    public int jump(int[] nums) {
        int jump = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //每次更新跳到最远的位置
            curFarthest = Math.max(curFarthest, nums[i] + i);
            //如果等于当前结束值，步数增加1，并且更新当前结束值等于过程中更新的最远的位置
            if (i == curEnd) {
                jump++;
                curEnd = Math.max(curFarthest, curEnd);
            }
        }
        return jump;
    }
}
