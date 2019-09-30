package algorithm._025_Reverse_Nodes_in_k_Group;

public class Solution {

    /*给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
    k 是一个正整数，它的值小于或等于链表的长度。
    如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。*/

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode d = head;
        //计算链表长度
        while (d != null) {
            length++;
            d = d.next;
        }
        //设置一个头结点的前结点，用于返回结果
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        for (ListNode pre = preHead, tail = head; length >= k; length -= k) {
            //k个为一组进行反转
            for (int i = 1; i < k; i++) {
                ListNode next = tail.next.next;
                tail.next.next = pre.next;
                pre.next = tail.next;
                tail.next = next;
            }
            pre = tail;
            tail = tail.next;
        }
        return preHead.next;
    }
}
