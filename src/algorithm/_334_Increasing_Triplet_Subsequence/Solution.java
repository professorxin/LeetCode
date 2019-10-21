package algorithm._334_Increasing_Triplet_Subsequence;

public class Solution {

    /*给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
    数学表达式如下:
    如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
    使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
    说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。*/



    //small表示三个数中最小的数，big表示三个数中中间的数，如果能找到比中间数还要大的数，
    //就能构成长度为3的递增子序列
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int num : nums) {
            //更新较小的数
            if (num <= small) {
                small = num;
                //更新中间数
            } else if (num <= big) {
                big = num;
            } else {
                //找到比中间数还大的数
                return true;
            }
        }
        return false;
    }

}
