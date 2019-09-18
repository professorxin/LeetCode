package algorithm._242_Valid_Anagram;

public class Solution {

    /*给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。*/

    //只需要判断s中出现的字符，t是否全部包含即可
    public boolean isAnagram(String s, String t) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) nums[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) nums[t.charAt(i) - 'a']--;
        for (int num : nums) if (num != 0) return false;
        return true;
    }
}
