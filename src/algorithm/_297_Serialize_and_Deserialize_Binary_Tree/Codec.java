package algorithm._297_Serialize_and_Deserialize_Binary_Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    /*请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
    你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。*/

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //使用前序遍历的思想

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serial(root, new StringBuilder()).toString();
    }

    private StringBuilder serial(TreeNode root, StringBuilder stb) {
        //叶子结点用#表示
        if (root == null) {
            return stb.append("#");
        }
        stb.append(root.val).append(",");
        //左子树，以，号结束
        serial(root.left, stb).append(",");
        //右子树
        serial(root.right, stb);
        return stb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserial(new LinkedList<String>(Arrays.asList(data.split(","))));
    }

    private TreeNode deserial(Queue<String> queue) {
        String val = queue.poll();
        //叶子节点
        if ("#".equals(val)) {
            return null;
        }
        //构造根节点
        TreeNode root = new TreeNode(Integer.valueOf(val));
        //左子树
        root.left = deserial(queue);
        //右子树
        root.right = deserial(queue);
        return root;
    }
}

