package algorithm._144_Binary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Solution {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /*非递归实现二叉树的前序遍历*/
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return res;
    }
}
