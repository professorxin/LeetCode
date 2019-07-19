package algorithm._199_Binary_Tree_Right_Side_View;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /*二叉树的右视图，返回从顶层到底层你看到的结点*/


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(result, root, 0);
        return result;
    }

    public void rightView(List<Integer> result, TreeNode node, int depth) {
        //如果为空，直接返回
        if (node == null) return;
        //只有满足大小和层数的等价关系才添加，一层只会添加一个结点
        if (result.size() == depth) {
            result.add(node.val);
        }
        //先递归右边，右边没有的才递归左边。左视图的话就相反
        rightView(result, node.right, depth + 1);
        rightView(result, node.left, depth + 1);
    }
}
