package algorithm._392_Is_Subsequence;

public class Solution {

    //判断s是否是t的子序列
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            //indexOf代表从index+1开始查找c元素，返回对应索引
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;

    }
}
