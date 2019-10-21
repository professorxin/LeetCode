package algorithm._075_Sort_Colors;

public class Solution {


    /*给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
    使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。*/

    /*荷兰国旗问题，定义数组的两个边界，等于1的话直接++，
    等于0就和边界的前一个元素交换，并且边界++，等于2同理，但是边界--。*/

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
