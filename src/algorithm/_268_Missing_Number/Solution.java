package algorithm._268_Missing_Number;

public class Solution {

    /*给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。*/

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int x = 0, i = 0;
        for (; i < nums.length; i++) {
            x = x ^ i ^ nums[i];
        }
        return x ^ i;
    }


}
