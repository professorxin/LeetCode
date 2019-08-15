package algorithm._234_Palindrome_Linked_List;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /*判断该链表是不是回文链表*/

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //如果链表是奇数的情况下
        if (fast != null) {
            slow = slow.next;
        }
        //链表反转
        slow = reverse(slow);
        fast = head;
        //进行对比
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    //链表反转
    private ListNode reverse(ListNode node) {
        ListNode pre = null, next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
