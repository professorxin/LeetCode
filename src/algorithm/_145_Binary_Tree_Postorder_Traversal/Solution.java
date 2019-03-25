package algorithm._145_Binary_Tree_Postorder_Traversal;


import java.util.ArrayList;
import java.util.Collections;
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


    /*非递归实现二叉树的后序遍历*/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }
}
