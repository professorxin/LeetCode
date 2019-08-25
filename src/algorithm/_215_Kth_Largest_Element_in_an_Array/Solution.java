package algorithm._215_Kth_Largest_Element_in_an_Array;

public class Solution {

    /*TopK问题，找到无序数组第k大的元素*/


    //O(N) best case / O(N^2) worst case running time + O(1) memory
    public int findKthLargest(int[] nums, int k) {
        //将第k大的等价转换为第（nums.length - k）小的，从而利用快排
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int p = partition(nums, l, h);
            if (p == k) {
                break;
            } else if (p > k) {
                h = p - 1;
            } else {
                l = p + 1;
            }
        }
        return nums[k];
    }

    //快排的partition,数组第一个数为基准数
    private int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            //找到大于基准数的
            while (nums[++i] < nums[l] && i < h) ;
            //找到小于基准数的
            while (nums[--j] > nums[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
