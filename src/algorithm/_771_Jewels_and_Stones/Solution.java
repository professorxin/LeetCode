package algorithm._771_Jewels_and_Stones;

import java.util.HashSet;
import java.util.Set;

public class Solution {


    /* 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。
    S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。*/

    //借助HashSet,时间复杂度为O(M+N)
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Set set = new HashSet();
        for (char j : J.toCharArray()) {
            if (!set.contains(j)) {
                set.add(j);
            }
        }
        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                res++;
            }
        }
        return res;
    }
}
