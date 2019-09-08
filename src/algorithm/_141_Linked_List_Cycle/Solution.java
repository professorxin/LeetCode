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
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


}
