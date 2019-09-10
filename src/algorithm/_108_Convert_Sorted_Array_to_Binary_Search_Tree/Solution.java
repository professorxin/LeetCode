package algorithm._108_Convert_Sorted_Array_to_Binary_Search_Tree;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /*给定一个升序的数组，构建成一个高度平衡的二叉查找树*/

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        TreeNode root = helper(nums,0,nums.length-1);
        return root;
    }

    private TreeNode helper(int[] nums,int start,int end){
        if(start > end){
            return null;
        }
        //找出位于中间的结点
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        //左边去构建左子树
        node.left = helper(nums,start,mid-1);
        //右边去构建右子树
        node.right = helper(nums,mid+1,end);
        return node;
    }
}
