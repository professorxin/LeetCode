package algorithm._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /*给定一个可包含重复数字的序列，返回所有不重复的全排列。*/

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        //排序
        Arrays.sort(nums);
        backtracking(result, list, visited, nums);
        return result;
    }


    private void backtracking(List<List<Integer>> result, List<Integer> list, boolean[] visited, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //元素重复了并且前一个元素还没有被访问，表示这是一个已经重复的组合了
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            backtracking(result, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
