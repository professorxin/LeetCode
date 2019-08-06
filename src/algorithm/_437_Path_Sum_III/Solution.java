package algorithm._437_Path_Sum_III;

public class Solution {

    /*给定一个二叉树，它的每个结点都存放着一个整数值。
    找出路径和等于给定数值的路径总数。
    路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /*引用leetcode答案的一段话：写递归的技巧是：明白一个函数的作用并相信它能完成这个任务，千万不要跳进这个
    函数里面企图探究更多细节，否则就会陷入无穷的细节无法自拔。你就算浑身是铁，能压几个栈？

    按照前面说的技巧，先来定义清楚每个递归函数应该做的事：
    pathSum 函数：给他一个节点和一个目标值，他返回以这个节点为根的树中，和为目标值的路径总数。
    pathSumFrom 函数：给他一个节点和一个目标值，他返回以这个节点为根的树中，能凑出几个以该节点为路径开头，
    和为目标值的路径总数。*/

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return (root.val == sum ? 1 : 0) + pathSumFrom(root.left, sum - root.val)
                + pathSumFrom(root.right, sum - root.val);
    }
}
