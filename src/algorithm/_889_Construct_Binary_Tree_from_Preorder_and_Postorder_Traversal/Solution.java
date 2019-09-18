package algorithm._889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal;

public class Solution {

    /*返回与给定的前序和后序遍历匹配的任何二叉树。
    pre 和 post 遍历中的值是不同的正整数。*/


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    private int[] pre;
    private int[] post;

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        return make(0, 0, pre.length);
    }

    private TreeNode make(int preIndex, int postIndex, int length) {
        if (length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex]);
        if (length == 1) {
            return root;
        }
        //L表示左子树的数量
        int L = 1;
        for (; L < length; L++) {
            //从后序遍历中找到左子树的划分界限
            if (post[postIndex + L - 1] == pre[preIndex + 1]) {
                break;
            }
        }
        root.left = make(preIndex + 1, postIndex, L);
        root.right = make(preIndex + 1 + L, postIndex + L, length - L - 1);
        return root;
    }
}
