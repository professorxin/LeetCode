package algorithm._083_Remove_Duplicates_from_Sorted_List;

public class Solution {

    /*给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。*/

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //如果结点相同
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head);
        } else {
            //如果结点不同
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
