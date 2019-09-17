package algorithm._461_Hamming_Distance;

public class Solution {

    /*两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
    给出两个整数 x 和 y，计算它们之间的汉明距离。*/

    //两数异或，二进制不同的位置的值为1，只需计算有多少个1即可
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z != 0) {
            if ((z & 1) == 1) {
                count++;
            }
            z = z >> 1;
        }
        return count;
    }
}
