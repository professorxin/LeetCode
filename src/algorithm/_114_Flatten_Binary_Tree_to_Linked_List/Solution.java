package algorithm._114_Flatten_Binary_Tree_to_Linked_List;

public class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    /*给定一个二叉树，原地将它展开为链表。*/



    /*题目其实就是将二叉树通过右指针，组成一个链表。
    1 -> 2 -> 3 -> 4 -> 5 -> 6
    我们知道题目给定的遍历顺序其实就是先序遍历的顺序，所以我们能不能利用先序遍历的代码，
    每遍历一个节点，就将上一个节点的右指针更新为当前节点。
    先序遍历的顺序是1 2 3 4 5 6。
    遍历到2，把1的右指针指向2。1 -> 2 3 4 5 6。
    遍历到3，把2的右指针指向3。1 -> 2 -> 3 4 5 6。
    ... ...
    一直进行下去似乎就解决了这个问题。但现实是残酷的，原因就是我们把1的右指针指向2，
    那么1的原本的右孩子就丢失了，也就是5 就找不到了。
    */


    /*解决方法的话，我们可以逆过来进行。
    我们依次遍历6 5 4 3 2 1，然后每遍历一个节点就将当前节点的右指针更新为上一个节点。
    遍历到5，把5的右指针指向6。6 <- 5 4 3 2 1。
    遍历到4，把4的右指针指向5。6 <- 5 <- 4 3 2 1。
    ... ...
    这样就不会有丢失孩子的问题了，因为更新当前的右指针的时候，当前节点的右孩子已经访问过了。
    而6 5 4 3 2 1的遍历顺序其实变形的后序遍历，遍历顺序是右子树->左子树->根节点。
    利用一个全局变量pre，更新当前根节点的右指针为pre,左指针为null。更新完后pre结点更新为当前结点
    */

    TreeNode pre = null;

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }




    /*1、将左子树插入到右子树的地方
      2、将原来的右子树接到左子树的最右边节点
      3、考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null*/
    public void flatten1(TreeNode root) {
        while(root != null){
            if(root.left == null){
                root = root.right;
            }else{
                TreeNode pre = root.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }
}
