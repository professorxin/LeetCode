package algorithm._019_Remove_Nth_Node_From_End_of_List;

public class Solution {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }


    /*删除链表倒数第n个节点*/

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //构造一个节点，并让它连接首节点，很关键
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start,slow = start;
        //快指针先走n+1步
        for(int i = 0;i <= n;i++){
            fast = fast.next;
        }
        //快慢指针一起走
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        //移除倒数第n个节点
        slow.next = slow.next.next;
        return start.next;
    }
}
