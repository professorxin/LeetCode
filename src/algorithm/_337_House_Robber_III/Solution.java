package algorithm._337_House_Robber_III;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*这个地方的所有房屋的排列类似于一棵二叉树”。如果两个直接相连的房子在同一天晚上被打劫，房屋
    将自动报警。*/

    //该函数表示从这个结点进行打劫能获得最大的钱数
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        //继续偷左边房子
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        //继续偷右边房子
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        //比较偷当前结点和不偷当前结点的两种情况
        return Math.max(root.val + val, rob(root.left) + rob(root.right));
    }
}
