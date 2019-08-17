package algorithm._208_Implement_Trie_Prefix_Tree;

public class Solution {


    /*实现一个Trie，Trie又称前缀树或字典树，用于判断字符串是否存在或者是否具有某种字符串前缀。*/


    //结点包含一个是否为单词末尾的属性和一个表示下一个结点（a-z）的数组
    class TrieNode {
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }
    }

    class Trie {

        //根节点
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //没有子节点就创建
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                //移动到子节点
                node = node.children[c - 'a'];
            }
            //更新最后结点的标记单词末尾属性为true;
            node.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //没有子节点直接返回false
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;
        }
    }
}
