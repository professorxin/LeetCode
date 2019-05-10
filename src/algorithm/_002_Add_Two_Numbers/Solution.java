package algorithm._002_Add_Two_Numbers;

public class Solution {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
    并且它们的每个节点只能存储一位数字。
    也就是说第一位是个位，第二位是十位，以此类推*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode head = new ListNode(0);
        ListNode d = head;
        int sum = 0;
        //利用除以10判断进位，余10来判断相加数值
        //只要有不为空的就继续生成节点
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        //判断进位
        if (sum / 10 == 1) {
            d.next = new ListNode(1);
        }
        return head.next;
    }
}
