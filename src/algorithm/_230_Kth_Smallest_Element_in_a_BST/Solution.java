package algorithm._230_Kth_Smallest_Element_in_a_BST;


public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /*给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。*/

    private int count = 0;
    private int number = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }

    private void helper(TreeNode root){
        if(root.left != null){
            helper(root.left);
        }
        count--;
        if(count == 0){
            number = root.val;
        }
        if(root.right != null){
            helper(root.right);
        }
    }
}
