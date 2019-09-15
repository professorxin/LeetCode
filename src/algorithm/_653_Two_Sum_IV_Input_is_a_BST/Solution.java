package algorithm._653_Two_Sum_IV_Input_is_a_BST;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，
    则返回 true。*/


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    //采用中序遍历然后双指针查找
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inOrder(root, nums);
        int i = 0, j = nums.size() - 1;
        //双指针
        while (i < j) {
            if (nums.get(i) + nums.get(j) < k) {
                i++;
            } else if (nums.get(i) + nums.get(j) > k) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    //中序遍历
    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }
}
