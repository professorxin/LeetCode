package algorithm._538_Convert_BST_to_Greater_Tree;

public class Solution {

    /*给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
    使得每个节点的值是原来的节点值加上所有大于它的节点值之和。*/


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    //全局变量
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    //右根左，中序遍历反过来
    /*一直递归右结点，找到最右的结点，更新它的值为结点值加上累加值，并将累加值更新为该结点的值。再递归左结点*/
    private void convert(TreeNode cur){
        if(cur == null){
            return;
        }
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
}
