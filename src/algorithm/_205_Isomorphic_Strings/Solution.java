package algorithm._205_Isomorphic_Strings;

public class Solution {

    /*给定两个字符串 s 和 t，判断它们是否是同构的。
    如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
    所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
    两个字符不能映射到同一个字符上，但字符可以映射自己本身。*/


    //记录每个字符之前出现的索引位置，从而进行判断
    public boolean isIsomorphic(String s, String t) {
        int[] preIndexOfS = new int[256];
        int[] preIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            //之前出现的位置不同，所以不是同构的
            if (preIndexOfS[sc] != preIndexOfT[tc]) {
                return false;
            }
            //记录出现的位置
            preIndexOfS[sc] = i + 1;
            preIndexOfT[tc] = i + 1;
        }
        return true;
    }
}
