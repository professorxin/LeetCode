package algorithm._540_Single_Element_in_a_Sorted_Array;

public class Solution {

    /*给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
    要求O(log n)时间复杂度*/

    public int singleNonDuplicate(int[] nums) {
        int L = 0, R = nums.length - 1;
        while (L < R) {
            //中位数位置
            int mid = L + (R - L) / 2;
            //如果中位数的位置是奇数，那么进行减1操作，确保左边区间和右边区间的长度都为偶数
            if (mid % 2 == 1) {
                mid--;
            }
            //相等表示右边区间除去nums[mid + 1]之后，长度为奇数，那么该数肯定在这里面
            if (nums[mid] == nums[mid + 1]) {
                L = mid + 2;
                //反之表示右边区间的偶数都是两两匹配，该数不在这里面。
            } else {
                R = mid;
            }
        }
        return nums[L];
    }
}
