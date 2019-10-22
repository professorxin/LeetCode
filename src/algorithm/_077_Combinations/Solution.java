package algorithm._077_Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。*/

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> combineList = new ArrayList<>();
        backtrack(resultList, combineList, 1, k, n);
        return resultList;
    }

    public void backtrack(List<List<Integer>> resultList, List<Integer> combineList, int start, int k, int n) {
        //递归终止条件
        if (k == 0) {
            resultList.add(new ArrayList<>(combineList));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {//剪枝，当i=4的时候可以剪掉
            combineList.add(i);
            backtrack(resultList, combineList, i + 1, k - 1, n);
            combineList.remove(combineList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}
