package algorithm._005_Longest_Palindromic_Substring;

public class Solution {

    /*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。*/

    //index为起始值，maxLen为长度
    private int index, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        //长度小于2直接返回
        if (len < 2) {
            return s;
        }
        //注意边界，要防止越界
        for (int i = 0; i < s.length() - 1; i++) {
            //长度为单数回文数
            findPalindrome(s, i, i);
            //长度为双数回文数
            findPalindrome(s, i, i + 1);
        }
        return s.substring(index, index + maxLen);
    }

    private void findPalindrome(String s, int m, int n) {
        //满足回文条件就循环
        while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
            m--;
            n++;
        }
        //更新起始值和长度
        if (maxLen < n - m - 1) {
            index = m + 1;
            maxLen = n - m - 1;
        }
    }


}
