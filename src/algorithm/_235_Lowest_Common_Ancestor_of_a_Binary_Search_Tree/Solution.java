package algorithm._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /*二叉查找树的两个结点的最近公共祖先*/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果两个结点都在左边的情况下
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        //如果两个结点都在右边的情况下
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        //两个结点一左一右或者其中一个是祖先结点的情况下直接返回祖先结点
        return root;
    }
}
