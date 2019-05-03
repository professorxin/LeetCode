package algorithm._328_Odd_Even_Linked_List;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*将链表元素按照奇偶位置聚集，然后偶位置链表放在奇位置链表后面*/
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        //将链表进行分割，分为两部分
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        //奇链表连接偶链表
        odd.next = evenHead;
        return head;
    }
}
