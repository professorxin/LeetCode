package algorithm._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.*;

public class Solution {

    /*题目描述
    请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
    第三行按照从左到右的顺序打印，其他行以此类推。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //采用队列完成
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (reverse) {
                Collections.reverse(list);
            }
            reverse = !reverse;
            if (list.size() != 0) {
                result.add(list);
            }
        }
        return result;
    }




    //采用递归
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,root,0);
        return res;
    }

    private void helper(List<List<Integer>> res,TreeNode root,int level){
        if(root == null){
            return;
        }
        //每一层都会创建一个集合保存该层元素
        if(res.size() == level){
            List<Integer> newLevel = new ArrayList<>();
            res.add(newLevel);
        }
        //取出当前层元素
        List<Integer> list = res.get(level);
        //如果是偶数层，从左到右直接添加，形成正序
        if(level % 2 == 0){
            list.add(root.val);
        }else{
            //如果是奇数层，也是从左到右添加，只是每次添加到第0号元素位置，其他的元素就都要右移一位，从而形成逆序
            list.add(0,root.val);
        }
        //先加左边的
        helper(res,root.left,level+1);
        //再加右边的
        helper(res,root.right,level+1);
    }
}
