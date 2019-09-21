package algorithm._665_Non_decreasing_Array;

public class Solution {

    /*给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成
    一个非递减数列。
    我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 
    array[i] <= array[i + 1]。*/


    /*在出现 nums[i] < nums[i - 1] 时，需要考虑的是应该修改数组的哪个数，使得本次修改能使 i 之
    前的数组成为非递减数组，并且 不影响后续的操作 。优先考虑令 nums[i - 1] = nums[i]，因为如果
    修改 nums[i] = nums[i - 1] 的话，那么 nums[i] 这个数会变大，就有可能比 nums[i + 1] 大，
    从而影响了后续操作。还有一个比较特别的情况就是 nums[i] < nums[i - 2]，修改
     nums[i - 1] = nums[i] 不能使数组成为非递减数组，只能修改 nums[i] = nums[i - 1]。*/
    public boolean checkPossibility(int[] nums) {
        //改变元素的次数
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            cnt++;
            if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return cnt < 2;
    }
}
