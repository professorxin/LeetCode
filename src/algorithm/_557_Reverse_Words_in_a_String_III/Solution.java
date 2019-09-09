package algorithm._557_Reverse_Words_in_a_String_III;

public class Solution {

    /*给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。*/

    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (s.charAt(i) == ' ') {
                reverseWord(str, start, i - 1);
                start = i + 1;
            }
        }
        reverseWord(str, start, str.length - 1);
        return new String(str);
    }

    private void reverseWord(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
