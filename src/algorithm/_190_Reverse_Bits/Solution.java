package algorithm._190_Reverse_Bits;

public class Solution {

    /*颠倒给定的 32 位无符号整数的二进制位。*/

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            //n最右边位置的二进制位
            result |= (n & 1);
            //n右移一位
            n = n >> 1;
        }
        return result;
    }

}
