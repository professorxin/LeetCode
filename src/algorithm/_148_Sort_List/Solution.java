package algorithm._148_Sort_List;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。*/

    //借助额外空间
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.sort((o1, o2) -> o1.val - o2.val);
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                list.get(i).next = list.get(i + 1);
            } else {
                list.get(i).next = null;
            }
        }
        if (list.size() == 0) return null;
        return list.get(0);
    }

    //todo
    //不借助额外空间

}
