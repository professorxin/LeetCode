package algorithm._143_Reorder_List;

public class Solution {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*重新排列链表，按照规则如下，Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…*/

    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        //find the middle
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the second half
        ListNode head2 = reverse(slow.next);
        slow.next = null;

        //Link
        while(head != null && head2 != null){
            ListNode temp1 = head.next;
            ListNode temp2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = temp1;
            head2 = temp2;
        }

    }

    //反转链表
    private ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode cur = node;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
