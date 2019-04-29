package algorithm._014_Longest_Common_Prefix;

public class Solution {

    //计算出strs数组里面的最长前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = strs[0];
        String temp = "";
        for (int i = 0; i < strs.length - 1; i++) {
            //取出较短的字符串的长度，防止越界
            int length = strs[i].length() > strs[i + 1].length() ? strs[i + 1].length() : strs[i].length();
            for (int j = 0; j < length; j++) {
                //如果有不同的字符串结束循环
                if (strs[i].charAt(j) != strs[i + 1].charAt(j)) {
                    break;
                } else {
                    temp += strs[i].charAt(j);
                }
            }
            //将判断后的前缀赋值给下次字符串的比较
            strs[i + 1] = temp;
            result = temp;
            temp = "";
        }
        return result;
    }


    /*找出字符串数组的最长前缀*/
    //这个思路就是前把数组第一个字符串当成前缀，再与后面的判断是否有共同前缀，如果没有就对前缀截取，截取到有之后重新对前缀赋值，再进行下一个判断。
    public String longestCommonPrefixOther(String[] strs) {
        if (strs.length == 0) return "";
        //定义数组的第一个字符串为前缀
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            //如果strs[i]的前缀索引不等于0，代表着没有共同前缀，需要进行截取
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
