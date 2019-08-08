package algorithm._338_Counting_Bits;

public class Solution {

    /*给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
    计算其二进制数中的 1 的数目并将它们作为数组返回。*/

    //主要是找到递推关系
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            /*一个数右移一位就等于去掉了二进制的最后一个数，去掉后得出的二进制数中1的数目加上
            该数和1相与得出的值（该数二进制最后一位为1值就是1，反之是0）就是该数的二进制1的数目*/
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
