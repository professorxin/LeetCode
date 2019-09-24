package algorithm._139_Word_Break;

import java.util.List;

public class Solution {

    /*给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
    判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。*/

    //字典的单词没有使用次数限制这是一个完全背包的问题，该问题涉及到字典中单词的使用顺序，因此可理解为涉及顺序的完全背包问题。
    //和求解完全背包问题不同的地方在于求解顺序的完全背包问题时，对物品的迭代应该放在最里层。
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= length; i++) {
            //物品迭代放里层
            for (String word : wordDict) {
                int len = word.length();
                //判断是否单词是否匹配字符串
                if ((i >= len) && word.equals(s.substring(i - len, i))) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[length];
    }
}
