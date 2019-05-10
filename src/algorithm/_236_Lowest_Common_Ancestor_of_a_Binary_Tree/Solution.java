package algorithm._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*普通二叉树的最近公共祖先*/
    //后序遍历二叉树，左子树和右子树分别搜索
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //终止条件
        if (root == null || root == p || root == q) {
            return root;
        }
        //左子树查找
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //右子树查找
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果左子树和右子树都找到了，就返回根节点
        if (left != null && right != null) {
            return root;
        }
        //如果左右子树只有一个找到，那就返回找到的。如果都没有找到，那就返回空
        return left != null ? left : right;
    }
}
