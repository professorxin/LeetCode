package algorithm._572_Subtree_of_Another_Tree;

public class Solution {

    /*给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树
    包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //s是否具有t子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    //该结点开始判断树结构是否相同
    public boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
    }
}
