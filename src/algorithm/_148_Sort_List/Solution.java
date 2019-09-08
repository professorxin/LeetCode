package algorithm._148_Sort_List;


public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。*/

    //归并排序的思想
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //prev为slow的前一个结点
        ListNode prev = null, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        //递归拆解
        ListNode l1 = sortList(slow);
        ListNode l2 = sortList(head);
        //合并
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode d = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                d.next = l1;
                l1 = l1.next;
            } else {
                d.next = l2;
                l2 = l2.next;
            }
            d = d.next;
        }
        if (l1 != null) {
            d.next = l1;
        }
        if (l2 != null) {
            d.next = l2;
        }
        return pre.next;
    }


}
