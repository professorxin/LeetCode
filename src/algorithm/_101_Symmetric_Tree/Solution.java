package algorithm._101_Symmetric_Tree;

public class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    /*给定一个二叉树，检查它是否是镜像对称的。*/

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }


    private boolean isSymmetric(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.val != t2.val){
            return false;
        }
        return isSymmetric(t1.right,t2.left)&&isSymmetric(t1.left,t2.right);
    }
}
