package algorithm._257_Binary_Tree_Paths;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*给定一个二叉树，返回所有从根节点到叶子节点的路径。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            searchBT(result, "", root);
        }
        return result;
    }

    private void searchBT(List<String> result, String str, TreeNode root) {
        //叶子结点
        if (root.left == null && root.right == null) {
            result.add(str + root.val);
        }
        //拼接左结点
        if (root.left != null) {
            searchBT(result, str + root.val + "->", root.left);
        }
        //拼接右结点
        if (root.right != null) {
            searchBT(result, str + root.val + "->", root.right);
        }
    }
}
