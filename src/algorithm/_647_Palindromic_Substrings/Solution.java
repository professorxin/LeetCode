package algorithm._647_Palindromic_Substrings;

public class Solution {
    /*给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
    具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。*/

    //回文字符串数量
    int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            //字符串长度为奇数，当前结点向外延长
            extendPalindrome(s, i, i);//odd
            //字符串长度为偶数，当前结点加上后一个结点向外延长
            extendPalindrome(s, i, i + 1);//even
        }
        return count;
    }

    //向外延长，继续找出回文字符串
    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
