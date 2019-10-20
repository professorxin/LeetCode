package algorithm._003_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;

public class Solution {


    /*给定一个字符串，查找最长不重复字符的子串*/

    //使用hashmap
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        //hashmap存储字符和出现位置的对应关系
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        //双指针i和j分别表示不重复子串的尾指针和首指针
        for (int i = 0, j = 0; i < s.length(); i++) {
            //判断是否之前已经加过这个key
            if (map.containsKey(s.charAt(i))) {
                //如果之前已经添加过了的话，就要更新起始不重复子串的边界值了
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            //每一个都更新加入key的位置
            map.put(s.charAt(i), i);
            //计算长度
            max = Math.max(max, i - j + 1);
        }
        return max;
    }



    //使用数组
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] nums = new int[256];
        //初始化数组的值都为-1而不是0，目的是为了后面计算长度
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -1;
        }
        //设置一个边界值
        int pre = -1;
        //设置长度
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            //边界值更新
            pre = Math.max(pre, nums[s.charAt(i)]);
            //更新数组中字符的值，值就是它的位置
            nums[s.charAt(i)] = i;
            //更新长度
            len = Math.max(len, i - pre);
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcdcefg"));
    }
}
