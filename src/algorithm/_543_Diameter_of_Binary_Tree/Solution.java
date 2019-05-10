package algorithm._543_Diameter_of_Binary_Tree;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*二叉树中任意两节点的最长路径*/

    //定义一个初始的最大值
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        //左树的长度和右树的长度相加再和最大值比较
        max = Math.max(max,leftDepth+rightDepth);
        //树的层数
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
