package algorithm._501_Find_Mode_in_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int curCnt = 1;
    int maxCnt = 1;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        List<Integer> maxCntNums = new ArrayList<>();
        inOrder(root, maxCntNums);
        int[] result = new int[maxCntNums.size()];
        int index = 0;
        for (int maxCntNum : maxCntNums) {
            result[index++] = maxCntNum;
        }
        return result;
    }

    private void inOrder(TreeNode root, List<Integer> maxCntNums) {
        if (root == null) {
            return;
        }
        inOrder(root.left, maxCntNums);
        if (pre != null && pre.val == root.val) {
            curCnt++;
        } else {
            curCnt = 1;
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            maxCntNums.clear();
            maxCntNums.add(root.val);
        } else if (curCnt == maxCnt) {
            maxCntNums.add(root.val);
        }
        pre = root;
        inOrder(root.right, maxCntNums);
    }
}
