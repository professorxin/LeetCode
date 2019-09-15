package algorithm._404_Sum_of_Left_Leaves;

public class Solution {

    /*计算给定二叉树的所有左叶子之和。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //左结点是叶子节点
        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    //是否是叶子节点
    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
