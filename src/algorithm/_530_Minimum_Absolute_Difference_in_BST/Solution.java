package algorithm._530_Minimum_Absolute_Difference_in_BST;

public class Solution {

    /*给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    //中序遍历
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        //当前节点和前一个节点的差值
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        //更新前一个结点
        pre = root;
        inOrder(root.right);
    }
}
