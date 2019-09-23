package algorithm._669_Trim_a_Binary_Search_Tree;

public class Solution {

    /*给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点
    的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树
    的新的根节点。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        //根节点比左边界小，修剪的树的根节点在右子树中寻找
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        //根节点比右边界大，修剪的树的根节点在左子树中寻找
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        //根节点处于L和R中间
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
