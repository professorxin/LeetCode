package algorithm._141_Linked_List_Cycle;

public class Solution {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*判断链表有无环*/
    //定义两个指针，一个指针指向头指针，一次走一步，一个指针指向头指针下一个，一次走两步。如果指针能相等说明有环。如果为空则无环
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head, p2 = head.next;
        while (p1 != null && p2 != null && p2.next != null) {
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return false;
    }


}
