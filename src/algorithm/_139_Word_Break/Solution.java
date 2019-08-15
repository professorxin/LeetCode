package algorithm._139_Word_Break;

import java.util.List;

public class Solution {

    /*给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
    判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。*/


    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[n]表示s的前n位可以被字典的单词拆分
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;


        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                //前j位可以被字典的单词拆分并且字典中包含第j到i-1位，就可以更新dp[i]的值为true
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        //表示字符串s是否能被字典中的单词拆分
        return dp[s.length()];
    }
}
