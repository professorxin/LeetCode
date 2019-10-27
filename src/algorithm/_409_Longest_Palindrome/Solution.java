package algorithm._409_Longest_Palindrome;

public class Solution {

    /*给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
    在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。*/


    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        //记录每个字符出现的次数
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }
        int palindrome = 0;
        for (int cnt : cnts) {
            //能构成回文的字符数量
            palindrome += (cnt / 2) * 2;
        }
        //小于字符串总长度的话，还能增加单个字符放在回文串正中间
        if (palindrome < s.length()) {
            palindrome++;
        }
        return palindrome;
    }
}
