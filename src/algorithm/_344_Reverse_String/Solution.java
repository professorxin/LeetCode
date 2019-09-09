package algorithm._344_Reverse_String;

public class Solution {

    /*编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。*/

    public void reverseString(char[] s) {
        int start = 0, end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
