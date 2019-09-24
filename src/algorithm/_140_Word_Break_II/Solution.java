package algorithm._140_Word_Break_II;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    /*给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建
    一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。*/

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    //该函数返回的是字符串s包含的所有可能的句子
    private List<String> dfs(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        //记忆化搜素
        if (map.containsKey(s)) {
            return map.get(s);
        }
        //包含的句子
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            //如果该单词为该字符串的开头
            if (s.startsWith(word)) {
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                //组合所有可能的句子
                for (String sub : sublist) {
                    String str = word + (sub.isEmpty() ? "" : " ") + sub;
                    res.add(str);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
