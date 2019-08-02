package algorithm._076_Minimum_Window_Substring;

import java.util.HashMap;

public class Solution {

    /*给定一个字符串s和字符串t,在s中找到最小的窗口可以包含整个t的所有字符，时间复杂度为O(n)*
     */

    //定义一个hashmap和两个指针，hashmap用于保存t中的字符出现的次数，两个指针表示窗口
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, 0);
        }
        //map统计出t中的字符出现的次数
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                return "";
            }
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, count = t.length();

        while (end < s.length()) {
            char c1 = s.charAt(end);
            //含有t中的字符，长度减1
            if (map.get(c1) > 0) {
                count--;
            }
            //该字符已经使用过，减1
            map.put(c1, map.get(c1) - 1);
            //移动end指针，找窗口
            end++;

            //长度减为0，表示已经找到窗口
            while (count == 0) {
                //更新minStart,minLen
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }

                char c2 = s.charAt(start);
                map.put(c2, map.get(c2) + 1);
                //如果为t中的字符，让count+1,从而跳出该循环重新寻找窗口
                if (map.get(c2) > 0) {
                    count++;
                }
                //移动start指针，继续找是否存在更小窗口
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
