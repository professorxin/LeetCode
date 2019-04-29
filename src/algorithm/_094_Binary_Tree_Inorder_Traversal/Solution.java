package algorithm._094_Binary_Tree_Inorder_Traversal;


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

    /*非递归实现二叉树的中序遍历*/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            //一直压左结点入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //弹出栈顶的结点
            TreeNode node = stack.pop();
            //添加结点到集合中
            res.add(node.val);
            //根结点打印完之后，跳到右结点
            cur = node.right;
        }
        return res;
    }
}
