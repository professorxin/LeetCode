package algorithm._645_Set_Mismatch;

public class Solution {

    /*集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合
    里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
    给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢
    失的整数，将它们以数组的形式返回。*/

    //将1-n的整数摆放到正确的位置上
    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //如果整数位置不正确并且不和交换后的数字相等，就交换数字
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
