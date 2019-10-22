package algorithm._216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*从 1-9 数字中选出 k 个数不重复的数，使得它们的和为 n。*/

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        //回溯算法
        backtrack(combinations, new ArrayList<Integer>(), 1, k, n);
        return combinations;
    }

    public void backtrack(List<List<Integer>> combinations, List<Integer> combination, int start, int k, int n) {
        //递归终止条件
        if (n == 0 && k == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }
/*        if (n == 0 || k == 0) {
            return;
        }*/
        for (int i = start; i <= 9; i++) {
            //如果加入的数字小于n并且k大于0
            if (i <= n && k > 0) {
                combination.add(i);
                backtrack(combinations, combination, i + 1, k - 1, n - i);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
