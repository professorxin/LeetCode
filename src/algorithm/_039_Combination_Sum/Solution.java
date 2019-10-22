package algorithm._039_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*给定一个数组，通过选取数组中的数字去组成目标数，数字可重复使用，找出所有的组合*/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(combinations, new ArrayList<Integer>(), 0, target, candidates);
        return combinations;
    }

    private void backtrack(List<List<Integer>> combinations, List<Integer> combination, int start, int target, int[] candidates) {
        //满足条件时
        if (target == 0) {
            //要注意重新构造一个ArrayList保存
            combinations.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //如果数组的数字小于目标，则加入组合中
            if (candidates[i] <= target) {
                combination.add(candidates[i]);
                //System.out.println("回溯前："+combination);
                //回溯的时候target变成target-数组的元素
                backtrack(combinations, combination, i, target - candidates[i], candidates);
                //移除组合的最后一个数，达到回溯
                //System.out.println("回溯后："+combination);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
