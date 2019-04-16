package algorithm._763_Partition_Labels;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*分隔字符串使同种字符出现在一起*/
    public List<Integer> partitionLabels(String S) {
        //建立一个桶数组保存每个字母最后出现的位置
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexOfChar[charIndex(S.charAt(i))] = i;
        }
        List<Integer> result = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < S.length()) {
            //确定每一部分的最后分界
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < S.length() && i <= lastIndex; i++) {
                int index = lastIndexOfChar[charIndex(S.charAt(i))];
                //如果有字母的边界现在的边界，重新更新最后的边界
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            //添加一个部分的结果
            result.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return result;
    }

    private int charIndex(char c) {
        return c - 'a';
    }
}
