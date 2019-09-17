package algorithm._260_Single_Number_III;

public class Solution {

    /*给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
    找出只出现一次的那两个元素。*/

    public int[] singleNumber(int[] nums) {
        int diff = 0;
        //所有异或，最后得出的是两个不重复的元素异或的结果
        for (int num : nums) {
            diff ^= num;
        }
        //找到最右边为1的数字，利用这个数字区分两个元素
        diff &= -diff;
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) == diff) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
