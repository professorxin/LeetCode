package algorithm._098_Validate_Binary_Search_Tree;

import java.util.Stack;

public class Solution {


    //二叉树结点的定义
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //题目描述：验证是否满足二叉搜索树，左结点小于根节点，右节点大于根节点
    //借助了中序遍历
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode pre = null;
        //使用栈来存储二叉树的节点，利用栈的后进先出
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //如果根节点不为null,就一直添加左结点进入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //栈的最上面结点出栈
            root = stack.pop();
            //当根结点的右结点为null时，root.val<=pre.val表示根节点小于等于左结点
            //当根结点的右结点不为null时，root.val<=pre.val表示右结点小于等于根节点
            //从而保证它是二叉搜索树
            if (pre != null && root.val <= pre.val) return false;
            //保存根节点
            pre = root;
            //将根节点的变为其右结点继续循环判断
            root = root.right;
        }
        return true;
    }


    //使用递归来验证，更加直观

    public boolean isValidBST1(TreeNode root) {
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST1(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST1(root.left, minVal, root.val) && isValidBST1(root.right, root.val, maxVal);
    }

}
