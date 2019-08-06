package algorithm._438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    //leetcode的高票答案有这类型题目的模板解答

    /*给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
    字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。*/

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()){
            return result;
        }
        //用hashmap保存p字符中的字符出现的频数
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        //count表示p中的字符的数量
        int count = map.size();

        //定义双指针，表示可滑动窗口
        int start = 0, end = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c) - 1);
                //当频数为0时表示s中已经匹配完该字符
                if(map.get(c) == 0){
                    count--;
                }
            }
            //移动右指针
            end++;

            //如果匹配完p中的所有字符
            while(count == 0){
                //s的左指针指向的字符是否匹配p，匹配的话count数量加1，左指针向右一位，继续寻找新的
                char temp = s.charAt(start);
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp) + 1);
                    if(map.get(temp) > 0){
                        count++;
                    }
                }

                //如果右指针减左指针长度与p字符串的长度相等
                if((end - start) == p.length()){
                    result.add(start);
                }
                start++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("bdfbbcab", "abbbc"));
    }
}
