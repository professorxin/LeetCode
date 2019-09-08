package algorithm._078_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。*/

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    void backtrack(List<List<Integer>> list, List<Integer> templist, int[] nums, int start) {
        list.add(new ArrayList<>(templist));
        //不能使用下面这个方法，下面这个添加的是最后templist指针指向的元素，而不是每次templist的内容
        //list.add(templist);
        for (int i = start; i < nums.length; i++) {
            templist.add(nums[i]);
            backtrack(list, templist, nums, i + 1);
            templist.remove(templist.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().subsets(nums));
    }
}
