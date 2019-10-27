package algorithm._047_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), visited, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, boolean[] visited, int[] nums) {
        if (list.size() == nums.length) {
            //直接在这里判断是否已经重复添加，容易理解
            if (!result.contains(list)) {
                result.add(new ArrayList<>(list));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            backtrack(result, list, visited, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
