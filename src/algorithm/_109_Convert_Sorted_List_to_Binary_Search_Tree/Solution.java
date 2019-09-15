package algorithm._109_Convert_Sorted_List_to_Binary_Search_Tree;

public class Solution {

    /*给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。*/

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = preMid(head);
        ListNode mid = pre.next;
        //断开链表
        pre.next = null;
        //中间节点
        TreeNode root = new TreeNode(mid.val);
        //左子树
        root.left = sortedListToBST(head);
        //右子树
        root.right = sortedListToBST(mid.next);
        return root;
    }

    //奇数长度链表返回正中间位置前面的节点，偶数长度链表返回中间位置偏左的节点
    private ListNode preMid(ListNode head) {
        ListNode pre = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
