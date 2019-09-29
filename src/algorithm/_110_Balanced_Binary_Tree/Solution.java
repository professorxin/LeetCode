package algorithm._110_Balanced_Binary_Tree;

public class Solution {

    /*给定一个二叉树，判断它是否是高度平衡的二叉树。
    本题中，一棵高度平衡二叉树定义为：
    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = length(root.left);
        int right = length(root.right);
        //左边和右边高度相差小于等于1，继续递归判断左子树和右子树
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //计算树的高度
    private int length(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = length(root.left);
        int right = length(root.right);
        return 1 + Math.max(left, right);
    }
}
