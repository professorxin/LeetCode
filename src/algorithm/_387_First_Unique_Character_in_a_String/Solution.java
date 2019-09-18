package algorithm._387_First_Unique_Character_in_a_String;

public class Solution {

    /*给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。*/

    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        //存放在数组中
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
