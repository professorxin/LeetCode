package algorithm._206_Reverse_Linked_List;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /*反转一个单链表。*/
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
