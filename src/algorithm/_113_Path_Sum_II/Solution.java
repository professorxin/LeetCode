package algorithm._113_Path_Sum_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //回溯算法实现
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(root, sum, result, path);
        return result;
    }

    private void backtrack(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        //判断是否是叶子结点且满足目标和
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(path));
        } else {
            backtrack(root.left, sum, result, path);
            backtrack(root.right, sum, result, path);
        }
        //返回上一层结点
        path.remove(path.size() - 1);
    }
}
