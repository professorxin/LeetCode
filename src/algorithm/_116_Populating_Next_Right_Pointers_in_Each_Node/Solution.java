package algorithm._116_Populating_Next_Right_Pointers_in_Each_Node;

public class Solution {

    /*给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }
    填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将
    next 指针设置为 NULL。
    初始状态下，所有 next 指针都被设置为 NULL。*/


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        connectNodes(root.left, root.right);
        return root;
    }

    private void connectNodes(Node node1, Node node2) {
        //连接结点
        node1.next = node2;
        //判断左结点不为空表示下一层有节点，避免空指针异常
        if (node1.left != null) {
            connectNodes(node1.left, node1.right);
            connectNodes(node1.right, node2.left);
            connectNodes(node2.left, node2.right);
        }
    }
}
