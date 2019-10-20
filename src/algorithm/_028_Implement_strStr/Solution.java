package algorithm._028_Implement_strStr;

public class Solution {

    //判断字符串s是否包含了字符串t
    public int strStrOther(String s, String t) {
        if (t.isEmpty()) return 0;
        for (int i = 0; i <= s.length() - t.length(); i++) {
            //两个字符串开始相等的部分
            for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
                //如果j到了字符串的最后一位，就可以说明包含了
                if (j == t.length() - 1) return i;
        }
        return -1;
    }


}
