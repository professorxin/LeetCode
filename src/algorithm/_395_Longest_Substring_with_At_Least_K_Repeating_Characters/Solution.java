package algorithm._395_Longest_Substring_with_At_Least_K_Repeating_Characters;

public class Solution {

    /*找到给定字符串（由小写字符组成）中的最长子串T，要求T中的每一字符出现次数都不少于 k。
    输出 T 的长度。*/



    //通过设置最长子串包含的不同字符数量，利用滑动窗口的思想去找出最长子串。
    public int longestSubstring(String s, int k) {
        int max = 0;
        //设置最长子串包含的字符数量，一共有26个小写字符。每一次的查找出的最长子串都和max做对比
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            max = Math.max(max, longestSubstringWithUniqueNum(s, k, numUniqueTarget));
        }
        return max;
    }


    //当最长子串包含的字符数量固定时，利用滑动指针思想寻找最长子串
    private int longestSubstringWithUniqueNum(String s, int k, int numUniqueTarget) {
        //存放字符出现的次数
        int[] chars = new int[128];
        //不小于K的字符数量
        int numNoLessThanK = 0;
        //最长子串包含的字符数量
        int numUniqueChars = 0;
        //前指针和后指针，后续用于滑动窗口
        int begin = 0, end = 0;
        int max = 0;

        while (end < s.length()) {
            //该字符第一次出现
            if (chars[s.charAt(end)]++ == 0) numUniqueChars++;
            //该字符数量不小于k
            if (chars[s.charAt(end++)] == k) numNoLessThanK++;

            //当我们的字符数量超过了我们设置的固定字符数量时，就要减少字符数量
            while (numUniqueChars > numUniqueTarget) {
                //该字符数量不小于k
                if (chars[s.charAt(begin)]-- == k) numNoLessThanK--;
                //该字符只出现过一次
                if (chars[s.charAt(begin++)] == 0) numUniqueChars--;
            }

            //只有在字符数量等于我们设置的固定字符数量并且不小于k的字符数量等于我们设置的固定字符数量时才去更新最大值
            if (numUniqueChars == numUniqueTarget && numNoLessThanK == numUniqueTarget) {
                max = Math.max(max, end - begin);
            }
        }

        return max;
    }
}
