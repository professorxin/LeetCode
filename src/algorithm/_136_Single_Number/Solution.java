package algorithm._136_Single_Number;

public class Solution {


    /*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
    找出那个只出现了一次的元素。*/

    //0 ^ N = N     N ^ N = 0

    /*N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
    = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
    = 0 ^ 0 ^ ..........^ 0 ^ N
    = N*/

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
