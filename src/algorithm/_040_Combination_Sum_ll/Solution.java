package algorithm._040_Combination_Sum_ll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    //todo
    //还有更好的设置是否已经访问的解法

    /*给定一个数组，通过选取数组中的数字去组成目标数，每个数字只能使用一次，找出所有的组合*/
    /*思路和第39题类似，只是数字不可重复使用，每次添加到最终结果时判断一下是否已经存在*/
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        //排序是为了防止组合重复
        Arrays.sort(candidates);
        backtrack(combinations, new ArrayList<Integer>(), 0, target, candidates);
        return combinations;
    }

    public void backtrack(List<List<Integer>> combinations, List<Integer> combination, int start, int target, int[] candidates) {
        if (target == 0) {
            if (!combinations.contains(combination)) {
                combinations.add(new ArrayList<>(combination));
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                combination.add(candidates[i]);
                backtrack(combinations, combination, i + 1, target - candidates[i], candidates);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
