package algorithm._031_Next_Permutation;

public class Solution {

    /*需要将给定数字序列重新排列成字典序中下一个更大的排列。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。*/


    //以2，3，6，5，4，1为例
    public void nextPermutation(int[] nums) {
        int n = nums.length - 1, p = -1, pv = 0;
        //从右到左找出不是升序的数字，此例为数字3
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                pv = nums[i];
                break;
            }
        }

        //如果没有找到不是升序的数字，表示这一个排列就是最大的排列，下一个排列为该排列的反转
        if (p == -1) {
            reverse(nums, 0, n);
            return;
        }

        //找到不是升序的数字后，从右到左找到比该数字大的数，此例为数字4，交换3和4
        for (int i = n; i > 0; i--) {
            if (nums[i] > nums[p]) {
                swap(nums, i, p);
                break;
            }
        }
        //反转数字4的右边部分的数组
        reverse(nums, p + 1, n);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
