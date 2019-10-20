package algorithm._049_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    /*给一字符串数组，字符串组成字母相同的分到一组*/

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        //hashmap用于保存排序好的字符串和对应分组字符串集合
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //将字符串转为字符数组，然后排序，再转回字符串
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            //如果map中没有该key
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            //添加字符串到该集合
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
