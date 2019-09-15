package algorithm._687_Longest_Univalue_Path;

public class Solution {

    /*给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过
    根节点。
    注意：两个节点之间的路径长度由它们之间的边数表示。*/


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int path = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return path;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int leftLen = node.left != null && node.left.val == node.val ? left + 1 : 0;
        int rightLen = node.right != null && node.right.val == node.val ? right + 1 : 0;
        //更新最长同值路径，leftLen + rightLen表示经过该结点最长同值路径
        path = Math.max(path, leftLen + rightLen);
        //该节点向下的最长同值路径
        return Math.max(leftLen, rightLen);
    }
}
