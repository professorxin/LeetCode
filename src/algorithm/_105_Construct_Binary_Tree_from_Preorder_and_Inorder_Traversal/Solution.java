package algorithm._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /*根据一棵树的前序遍历与中序遍历构造二叉树。*/

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length - 1);
    }

    private TreeNode helper(int[] preorder,int preIndex,int preEnd,int[] inorder,int inIndex,int inEnd){
        //递归终止条件
        if(preIndex > preEnd || inIndex > inEnd){
            return null;
        }
        //创建出根结点
        TreeNode root = new TreeNode(preorder[preIndex]);
        //找出中序序列中根结点的位置
        int inOrderRoot = inIndex;
        for(int i = inIndex;i <= inEnd;i++){
            if(inorder[i] == root.val){
                inOrderRoot = i;
                break;
            }
        }
        //求出左边子树的长度
        int leftTreeLen = inOrderRoot - inIndex;
        //求出左子树根节点
        root.left = helper(preorder,preIndex +1,preIndex+leftTreeLen,inorder,inIndex,inOrderRoot-1);
        //求出右子树根节点
        root.right = helper(preorder,preIndex +1+leftTreeLen,preEnd,inorder,inOrderRoot+1,inEnd);
        return root;
    }
}
