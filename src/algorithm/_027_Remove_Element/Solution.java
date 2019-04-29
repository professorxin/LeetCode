package algorithm._027_Remove_Element;

import java.util.Arrays;

public class Solution {

    /*给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。*/

    //对数组进行排序，然后跳过相同值的元素，再把比val值大的元素根据step的值（跳过的数目）移动到数组前面
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int step = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == val) {
                i++;
                step++;
                if (i == nums.length) return nums.length - step;
            }
            if (nums[i] > val) {
                nums[i - step] = nums[i];
            }
        }
        return nums.length - step;
    }

    //更好的思路，设置一个初始值，有不相同的开始覆盖数组，在同一个数组进行操作
    public int removeElementOther(int[] A, int elem) {
        int m = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[m] = A[i];
                m++;
            }
        }
        return m;
    }
}
