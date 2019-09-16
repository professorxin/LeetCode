package algorithm._138_Copy_List_with_Random_Pointer;

public class Solution {

    /*给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
    要求返回这个链表的深拷贝。 */

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }


    //将复制结点复制在原结点后面
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //创建复制结点，并位于原结点后面
        Node cur = head;
        while (cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        //建立random连接
        cur = head;
        while (cur != null) {
            Node clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        //将复制链表和原链表分离开
        Node cloneHead = head.next;
        cur = head;
        while (cur.next != null) {
            Node next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return cloneHead;
    }
}
