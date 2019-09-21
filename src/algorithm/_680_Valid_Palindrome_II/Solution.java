package algorithm._680_Valid_Palindrome_II;

public class Solution {

    /*给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。*/


    public boolean validPalindrome(String s) {
        int index = 0, end = s.length() - 1;
        while (index < end) {
            //如果不匹配，存在两种情况回文
            if (s.charAt(index) != s.charAt(end)) {
                return isPalindrome(s, index + 1, end) || isPalindrome(s, index, end - 1);
            }
            index++;
            end--;
        }
        return true;
    }

    //双指针判断回文
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
