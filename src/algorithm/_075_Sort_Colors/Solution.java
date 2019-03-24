package algorithm._075_Sort_Colors;

public class Solution {


    //荷兰国旗问题，定义数组的两个边界，等于1的话直接++，等于0就和边界的前一个元素交换，并且边界++，等于2同理，但是边界--。
    public void sortColors(int[] nums) {
        int less = -1, index = 0, more = nums.length;
        while (index < more) {
            if (nums[index] == 0) {
                swap(nums, ++less, index++);
            } else if (nums[index] == 2) {
                swap(nums, --more, index);
            } else {
                index++;
            }
        }

    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
