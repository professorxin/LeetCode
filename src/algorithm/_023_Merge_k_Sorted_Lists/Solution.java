package algorithm._023_Merge_k_Sorted_Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /*合并多个已经排好序的链表*/

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //使用小顶堆排序每条链表的节点
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        //创建一个节点，用于连接合并链表的首节点
        ListNode start = new ListNode(0);
        ListNode p = start;
        //将链表入小顶堆
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        //如果小顶堆不为空，弹出最小节点进行连接
        while (!queue.isEmpty()) {
            p.next = (ListNode) queue.poll();
            p = p.next;
            //弹出节点的下一个节点如果不为空，就入小顶堆
            if (p.next != null) {
                queue.add(p.next);
            }
        }
        return start.next;
    }

}
