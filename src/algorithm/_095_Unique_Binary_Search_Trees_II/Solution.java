package algorithm._095_Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。*/

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<TreeNode>();
        }
        return generateSubtrees(1, n);
    }

    //生成start到end范围内的所有二叉搜索树
    private List<TreeNode> generateSubtrees(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            //左子树
            List<TreeNode> leftSubtrees = generateSubtrees(start, i - 1);
            //右子树
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    //创建根节点
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }
}
