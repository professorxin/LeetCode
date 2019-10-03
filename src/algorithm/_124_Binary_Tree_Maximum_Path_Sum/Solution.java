package algorithm._124_Binary_Tree_Maximum_Path_Sum;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /*给定一个非空二叉树，返回其最大路径和。
    本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定
    经过根节点。*/

    //全局变量最大路径和
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        //以该结点向下进行搜索最大路径和
        maxPathDown(root);
        return maxValue;
    }

    public int maxPathDown(TreeNode node) {
        //递归结束条件
        if (node == null) return 0;
        //左结点向下搜索最大路径和，并将值返回
        int left = Math.max(0, maxPathDown(node.left));
        //右结点向下搜索最大路径和，并将值返回
        int right = Math.max(0, maxPathDown(node.right));
        //左结点最大路径和加上右结点最大路径和加上本结点的和比maxValue大的话，更新maxValue
        maxValue = Math.max(maxValue, left + right + node.val);
        //返回该结点向下搜索的最大路径和
        return Math.max(left, right) + node.val;
    }
}
